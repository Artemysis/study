package ru.tinkoff.edu.java.bot.tinkbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;

@Component
public class MyTelegramBot extends TelegramLongPollingBot {
    private final BotCommandProcessor commandProcessor;
    
    
    @Autowired
    public MyTelegramBot(BotCommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            commandProcessor.processCommand(message);
        }
    }

    @Override
    public String getBotUsername() {
        return "@Test_Bot_1111_tinkbot";
    }

    @Override
    public String getBotToken() {
        return "6273670538:AAG7f-mAgVCb5xzw2nXnHgjJ_CxvaxZB4os";
    }
    
    public void execute() throws TelegramApiException {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(this);
        } catch (TelegramApiRequestException e) {
            throw new TelegramApiException("Failed to register bot", e);
        }
    }

}
