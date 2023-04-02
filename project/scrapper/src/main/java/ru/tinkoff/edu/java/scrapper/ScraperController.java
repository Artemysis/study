package ru.tinkoff.edu.java.scrapper;



import java.util.List;

import org.springframework.web.bind.annotation.*;

import ru.tinkoff.edu.java.scrapper.http.ScraperHttpClient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ScraperController {

    private Map<Integer, List<String>> linksByChatId = new HashMap<>();
    


    private final ScraperHttpClient scraperHttpClient;

    public ScraperController(ScraperHttpClient scraperHttpClient) {
        this.scraperHttpClient = scraperHttpClient;
    }

    @PostMapping("/tg-chat/{id}")
    public ResponseEntity<Void> registerChat(@PathVariable int id) {
        if (linksByChatId.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        linksByChatId.put(id, new ArrayList<>());
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/tg-chat/{id}")
    public ResponseEntity<Void> deleteChat(@PathVariable int id) {
        if (!linksByChatId.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        linksByChatId.remove(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/links/{id}")
    public ResponseEntity<List<String>> getLinksByChatId(@PathVariable int id) {
        if (!linksByChatId.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(linksByChatId.get(id));
    }


    @PostMapping("/links/{id}")
    public ResponseEntity<LinkResponse> addLink(@PathVariable int id, @RequestBody AddLinkRequest request) {
        List<String> links = linksByChatId.getOrDefault(id, new ArrayList<>());
        links.add(request.Link());
        linksByChatId.put(id, links);
        LinkResponse response = new LinkResponse(request.Link());
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/links/{id}")
    public ResponseEntity<LinkResponse> removeLink(@PathVariable int id, @RequestBody RemoveLinkRequest request) {
        List<String> links = linksByChatId.get(id);
        if (links == null || !links.contains(request.Link())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        links.remove(request.Link());
        linksByChatId.put(id, links);
        LinkResponse response = new LinkResponse(null);
        return ResponseEntity.ok(response);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}


