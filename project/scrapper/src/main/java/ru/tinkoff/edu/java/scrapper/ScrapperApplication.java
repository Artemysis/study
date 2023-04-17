package ru.tinkoff.edu.java.scrapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import ru.tinkoff.edu.java.scrapper.configuration.ApplicationConfig;
import parser.GithubLinkParser;
import parser.StackoverflowLinkParser;
import parser.LinkParser;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig.class)
public class ScrapperApplication {
	
	 @Bean
	    public ApplicationConfig applicationConfig() {
	        return new ApplicationConfig("test", "schedulerInterval", "baseUrl");
	    }
	 
    public static void main(String[] args) {
        var ctx = SpringApplication.run(ScrapperApplication.class, args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig.class);
        LinkParser linkParser = new GithubLinkParser();
        String userRepo = linkParser.parseLink("");
        linkParser = new StackoverflowLinkParser();
        String questionId = linkParser.parseLink("");
        System.out.println(userRepo);
        System.out.println(questionId);
        System.out.println(config);
    }
}