package com.madhu.firstproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @GetMapping(value = "/greet")
    public ResponseEntity<Object> greet(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World!!");
    }
}
