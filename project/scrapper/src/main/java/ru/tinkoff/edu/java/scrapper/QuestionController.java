package ru.tinkoff.edu.java.scrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class QuestionController {
    
    private final StackOverflowClient stackOverflowClient;
    
    @Autowired
    public QuestionController(StackOverflowClient stackOverflowClient) {
        this.stackOverflowClient = stackOverflowClient;
    }
    
    @GetMapping("/questions/{id}")
    public Mono<QuestionResponse> getQuestion(@PathVariable long id) {
        return stackOverflowClient.fetchQuestion(id);
    }
}
