package com.project.portfolio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping(value = "/")
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
    }
}
