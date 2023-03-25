package controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScrapperController {

    @PostMapping("/tg-chat/{id}")
    public ResponseEntity<Void> registerChat(@PathVariable("id") Long chatId) {
        // Заглушка - пока нет реальных данных
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/tg-chat/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable("id") Long chatId) {
        // Заглушка - пока нет реальных данных
        return ResponseEntity.ok().build();
    }

    @GetMapping("/links")
    public ResponseEntity<List<LinkResponse>> getAllLinks(@RequestHeader("Tg-Chat-Id") Long chatId) {
        // Заглушка - пока нет реальных данных
        return ResponseEntity.ok(Collections.emptyList());
    }

    @PostMapping("/links")
    public ResponseEntity<LinkResponse> addLink(@RequestHeader("Tg-Chat-Id") Long chatId, @RequestBody AddLinkRequest addLinkRequest) {
        // Заглушка - пока нет реальных данных
        return ResponseEntity.ok(new LinkResponse(null, null));
    }

    @DeleteMapping("/links")
    public ResponseEntity<LinkResponse> removeLink(@RequestHeader("Tg-Chat-Id") Long chatId, @RequestBody RemoveLinkRequest removeLinkRequest) {
        // Заглушка - пока нет реальных данных
        return ResponseEntity.ok(new LinkResponse(null, null));
    }

    @ControllerAdvice
    public static class ScrapperControllerExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<String> handleException(Exception e) {
            // Логируйте ошибку здесь или отправляйте уведомление
            return ResponseEntity.status(500).body("Произошла ошибка: " + e.getMessage());
        }

    }

}