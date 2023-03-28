package ru.tinkoff.edu.java.scrapper;

import java.time.OffsetDateTime;

public record RepositoryResponse(String name, String description, String language, OffsetDateTime updatedAt) {}
