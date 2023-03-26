package ru.tinkoff.edu.java.scrapper;



import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class ScrapperController {

    @PostMapping("/tg-chat/{id}")
    public void registerChat(@PathVariable Long id) {
        // реализация метода
    }

    @DeleteMapping("/tg-chat/{id}")
    public void deleteChat(@PathVariable Long id) {
        // реализация метода
    }

    @GetMapping("/links")
    public List<LinkResponse> getAllLinks(@RequestHeader("Tg-Chat-Id") Long chatId) {
		return null;
        // реализация метода
    }

    @PostMapping("/links")
    public LinkResponse addLink(@RequestHeader("Tg-Chat-Id") Long chatId, @RequestBody AddLinkRequest request) {
		return null;
        // реализация метода
    }

    @DeleteMapping("/links")
    public LinkResponse removeLink(@RequestHeader("Tg-Chat-Id") Long chatId, @RequestBody RemoveLinkRequest request) {
		return null;
        // реализация метода
    }
}
