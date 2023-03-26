package ru.tinkoff.edu.java.scrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class RepositoryController {

    private final GitHubClient gitHubClient;

    @Autowired
    public RepositoryController(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    @GetMapping("/repos/{owner}/{repo}")
    public Mono<RepositoryResponse> getRepository(@PathVariable String owner, @PathVariable String repo) {
        return gitHubClient.getRepository(owner, repo);
    }
}
