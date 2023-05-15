//package bot;
//
//import org.junit.jupiter.api.Test;
//
//import com.pengrad.telegrambot.TelegramBot;
//import com.pengrad.telegrambot.model.Message;
//import com.pengrad.telegrambot.request.SendMessage;
//
//import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;
//import ru.tinkoff.edu.java.bot.tinkbot.BotCommandProcessor;
//import ru.tinkoff.edu.java.bot.tinkbot.User;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
//
//class BotCommandProcessorTest {
//
//	@Test
//	void testListCommand() {
//	    String test = "12345";
//	    String schedulerInterval = "PT10S";
//	    String telegramBotToken = "6273670538:AAG7f-mAgVCb5xzw2nXnHgjJ_CxvaxZB4os";
//
//	    ApplicationConfig config = new ApplicationConfig(test, schedulerInterval, telegramBotToken);
//	    BotCommandProcessor botCommandProcessor = new BotCommandProcessor(config);
//
//	    // создаем пользователя и добавляем ему несколько отслеживаемых ссылок
//	    User user = new User(1, null);
//	    user.addTrackedLink("https://example.com/1");
//	    botCommandProcessor.users.put(1, user);
//
	    // вызываем команду /list
//	    botCommandProcessor.list(1);
//
	    // проверяем, что бот отправил пользователю сообщение со списком отслеживаемых ссылок
//	    String expected = "Список отслеживаемых ссылок:\n- https://example.com/1";
//	    Message result = botCommandProcessor.bot.execute(new SendMessage(1, "")).message();
//
//	        assertEquals(expected, result.text());
//	   
//	}
//}

