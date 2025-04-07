package io.github.irfnhanif.urlshorterner.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class URLShortenerController {

    @GetMapping("/short-url")
    public ResponseEntity<> getRedirectURL(@RequestParam String param) {
        return new String();
    }

}
