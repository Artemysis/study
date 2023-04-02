package ru.tinkoff.edu.java.scrapper;

import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.core.publisher.Mono;

public interface StackOverflowClient {
    Mono<QuestionResponse> getQuestion(long id) throws WebClientResponseException;
    QuestionResponse getQuestion(int id);
}

