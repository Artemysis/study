package ru.tinkoff.edu.java.bot.tinkbot;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;

import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class BotCommandProcessor {
    private final TelegramBot bot;
    private final Map<Integer, User> users = new HashMap<>();

    @Autowired
    public BotCommandProcessor(ApplicationConfig config) {
        bot = new TelegramBot(config.telegramBotToken());
    }

    public void processCommand(Message message) {
        String command = message.getText();
        int userId = message.getFrom().getId();

        User user = users.getOrDefault(userId, new User(userId, null));
        switch (command) {
            case "/start":
                registerUser(user);
                break;
            case "/help":
                sendHelpMessage(userId);
                break;
            case "/track":
                trackLink(user, "link to track");
                break;
            case "/untrack":
                untrackLink(user, "link to untrack");
                break;
            case "/list":
                listTrackedLinks(user);
                break;
            default:
                sendUnknownCommandMessage(userId);
        }
    }

    private void registerUser(User user) {
        users.putIfAbsent(user.userId(), user);
        bot.execute(new SendMessage(user.userId(), "Добро пожаловать в бот"));
    }   
    private void sendHelpMessage(int userId) {
        bot.execute(new SendMessage(userId, "Доступные команды:\n" +
                "/start - Зарегистрировать пользователя\n" +
                "/help - Показать доступные команды\n" +
                "/track - Начните отслеживать ссылку\n" +
                "/untrack - Прекратить отслеживание ссылки\n" +
                "/list - Список отслеживаемых ссылок"));
    }

    private void trackLink(User user, String link) {
        user.addTrackedLink(link);
        bot.execute(new SendMessage(user.userId(), "Ссылка добавлена в список отслеживания: " + link));
    }

    private void untrackLink(User user, String link) {
        if (user.removeTrackedLink(link)) {
            bot.execute(new SendMessage(user.userId(), "Ссылка удалена из списка отслеживания: " + link));
        } else {
            bot.execute(new SendMessage(user.userId(), "Ссылка не найдена в списке отслеживания: " + link));
        }
    }

    private void listTrackedLinks(User user) {
        Set<String> trackedLinks = user.getTrackedLinks();
        if (trackedLinks.isEmpty()) {
            bot.execute(new SendMessage(user.userId(), "В настоящее время никакие ссылки не отслеживаются."));
        } else {
            StringBuilder messageBuilder = new StringBuilder("Отслеживаемые ссылки: \n");
            trackedLinks.forEach(link -> messageBuilder.append("- ").append(link).append("\n"));
            bot.execute(new SendMessage(user.userId(), messageBuilder.toString()));
        }
    }

    private void sendUnknownCommandMessage(int userId) {
        bot.execute(new SendMessage(userId, "Неизвестная команда. Используйте /help, чтобы просмотреть доступные команды."));
    }
}

