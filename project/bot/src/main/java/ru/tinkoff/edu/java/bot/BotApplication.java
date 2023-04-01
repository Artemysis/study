package ru.tinkoff.edu.java.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;
import parser.GithubLinkParser;
import parser.LinkParser;
import parser.StackoverflowLinkParser;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class BotApplication {
	String userRepo;
    public static void main(String[] args) {
        var ctx = SpringApplication.run(BotApplication.class, args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        LinkParser linkParser = new GithubLinkParser();
        String userRepo = linkParser.parseLink("");
        linkParser = new StackoverflowLinkParser();
        String questionId = linkParser.parseLink("");
        System.out.println(userRepo);
        System.out.println(questionId);
    }
}
