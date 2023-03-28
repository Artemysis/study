package ru.tinkoff.edu.java.scrapper;



import java.util.List;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ScraperController {

    private Map<Integer, List<String>> linksByChatId = new HashMap<>();

    @PostMapping("/tg-chat/{id}")
    public ResponseEntity<Void> registerChat(@PathVariable int id) {
        // do something to register the chat
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/tg-chat/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable int id) {
        // do something to delete the chat
        return ResponseEntity.ok().build();
    }

    @GetMapping("/links")
    public ResponseEntity<List<String>> getLinksByChatId(@RequestHeader("Tg-Chat-Id") int chatId) {
        if (!linksByChatId.containsKey(chatId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(linksByChatId.get(chatId));
    }

    @PostMapping("/links")
    public ResponseEntity<LinkResponse> addLink(@RequestHeader("Tg-Chat-Id") int chatId,
                                                @RequestBody AddLinkRequest request) {
        // do something to add the link
        LinkResponse response = new LinkResponse("https://example.com");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/links")
    public ResponseEntity<LinkResponse> removeLink(@RequestHeader("Tg-Chat-Id") int chatId,
                                                   @RequestBody RemoveLinkRequest request) {
        // do something to remove the link
        LinkResponse response = new LinkResponse("https://example.com");
        return ResponseEntity.ok(response);
    }

    // Exception handling
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}


