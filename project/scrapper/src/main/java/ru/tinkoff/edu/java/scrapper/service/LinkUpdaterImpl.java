package ru.tinkoff.edu.java.scrapper.service;

import ru.tinkoff.edu.java.parser.response.GitHubParsingResponse;
import ru.tinkoff.edu.java.parser.response.ParsingResponse;
import ru.tinkoff.edu.java.parser.response.StackOverflowParsingResponse;
import ru.tinkoff.edu.java.scrapper.model.Link;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class LinkUpdaterImpl implements LinkUpdater {
    @Override
    public void update() {
        // Реализация метода update()
        // ...
    }

    @Override
    public Optional<Map.Entry<Link, String>> processGitHubLink(Link link, GitHubParsingResponse response) {
        // Реализация метода processGitHubLink()
        // ...

        return Optional.empty(); // Добавлен оператор return
    }

    @Override
    public Optional<Map.Entry<Link, String>> processStackOverflowLink(Link link, StackOverflowParsingResponse response) {
        // Реализация метода processStackOverflowLink()
        // ...

        return Optional.empty(); // Добавлен оператор return
    }

    @Override
    public Optional<ParsingResponse> parseUrl(String url) {
        // Реализация метода parseUrl()
        // ...

        return Optional.empty(); // Добавлен оператор return
    }
}
