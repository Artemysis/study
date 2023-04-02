package ru.tinkoff.edu.java.scrapper.http;

import org.springframework.web.reactive.function.client.WebClient;
import java.net.URI;
import reactor.core.publisher.Mono;
import ru.tinkoff.edu.java.scrapper.AddLinkRequest;
import ru.tinkoff.edu.java.scrapper.LinkResponse;
import ru.tinkoff.edu.java.scrapper.ListLinksResponse;
import ru.tinkoff.edu.java.scrapper.RemoveLinkRequest;

public class ScraperHttpClient {

    private final WebClient webClient;

    public ScraperHttpClient(String baseUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public Mono<LinkResponse> addLink(int id, AddLinkRequest request) {
        URI uri = URI.create(String.format("/links/%d", id));
        return webClient.post()
                .uri(uri)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(LinkResponse.class);
    }

    public Mono<LinkResponse> removeLink(int id, RemoveLinkRequest request) {
        URI uri = URI.create(String.format("/links/%d", id));
        return webClient.delete()
                .uri(uri)
                .retrieve()
                .bodyToMono(LinkResponse.class);
    }

    public Mono<ListLinksResponse> getLinks(int id) {
        URI uri = URI.create(String.format("/links/%d", id));
        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(ListLinksResponse.class);
    }

    public Mono<Void> registerChat(int id) {
        URI uri = URI.create(String.format("/tg-chat/%d", id));
        return webClient.post()
                .uri(uri)
                .retrieve()
                .bodyToMono(Void.class);
    }

    public Mono<Void> deleteChat(int id) {
        URI uri = URI.create(String.format("/tg-chat/%d", id));
        return webClient.delete()
                .uri(uri)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
