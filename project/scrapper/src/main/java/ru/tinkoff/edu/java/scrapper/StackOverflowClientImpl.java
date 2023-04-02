package ru.tinkoff.edu.java.scrapper;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import reactor.core.publisher.Mono;

public class StackOverflowClientImpl implements StackOverflowClient {

    private final WebClient webClient;

    public StackOverflowClientImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    public QuestionResponse getQuestion(int id) throws WebClientResponseException {
        return webClient.get()
                .uri("/questions/{ids}", id)
                .retrieve()
                .bodyToMono(QuestionResponse.class)
                .block();
    }

	@Override
	public Mono<QuestionResponse> getQuestion(long id) throws WebClientResponseException {
		// TODO Auto-generated method stub
		return null;
	}

}