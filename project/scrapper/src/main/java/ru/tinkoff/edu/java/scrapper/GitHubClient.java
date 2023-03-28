package ru.tinkoff.edu.java.scrapper;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public interface GitHubClient {
    Mono<RepositoryResponse> getRepository(String owner, String repo);
}