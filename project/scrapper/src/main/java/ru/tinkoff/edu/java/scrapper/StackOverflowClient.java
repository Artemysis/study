package ru.tinkoff.edu.java.scrapper;

import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.core.publisher.Mono;

public interface StackOverflowClient {
    QuestionResponse getQuestion(long id) throws WebClientResponseException;
    Mono<QuestionResponse> fetchQuestion(long questionId);
}

