package ru.tinkoff.edu.java.bot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class BotApiController {

    @PostMapping("/updates")
    public ResponseEntity<Object> processUpdate(@RequestBody LinkUpdate linkUpdate) {
        // process the update here
        return ResponseEntity.ok().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
        ApiErrorResponse errorResponse = new ApiErrorResponse(
                "An error occurred while processing the request",
                "500",
                ex.getClass().getSimpleName(),
                ex.getMessage(),
                Collections.singletonList(ex.getStackTrace().toString()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}

