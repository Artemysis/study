package ru.tinkoff.edu.java.scrapper.configuration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ru.tinkoff.edu.java.scrapper.http.ScraperHttpClient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public record ApplicationConfig(@NotNull String test, @NotBlank String schedulerInterval, @NotBlank String baseUrl) {

    @Bean
    public ScraperHttpClient scraperHttpClient() {
        return new ScraperHttpClient(baseUrl);
    }
}
