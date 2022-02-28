package com.madhu.springsecurityldap.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HomeController {

    @GetMapping(value = "/")
    public ResponseEntity<Object> index() {
        return ResponseEntity.status(HttpStatus.OK).body("Home Page");
    }

}
