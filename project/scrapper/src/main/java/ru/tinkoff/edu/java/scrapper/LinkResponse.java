package ru.tinkoff.edu.java.scrapper;

import java.time.LocalDateTime;

public record LinkResponse(String url, String title, LocalDateTime addedDateTime) {}
