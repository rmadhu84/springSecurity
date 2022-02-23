package com.madhu.firstproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @GetMapping(value = "/")
    public ResponseEntity<Object> welcome(){
        return ResponseEntity.status(HttpStatus.OK).body("<h1>Welcome</h1>");
    }

    @GetMapping(value = "/greet")
    public ResponseEntity<Object> greet(){
        return ResponseEntity.status(HttpStatus.OK).body("Hello World!!");
    }

    @GetMapping(value = "/sayHello")
    public ResponseEntity<Object> sayHello(@RequestParam("name") String user){
        return ResponseEntity.status(HttpStatus.OK).body(String.format("%s wishes you Good Day !!", user));
    }

    @GetMapping(value = "/hired")
    public ResponseEntity<Object> hire(@RequestParam("name") String user){
        return ResponseEntity.status(HttpStatus.OK).body(String.format("%s, you are hired !!", user));
    }

    @GetMapping(value = "/fired")
    public ResponseEntity<Object> fire(@RequestParam("name") String user){
        return ResponseEntity.status(HttpStatus.OK).body(String.format("%s, you are fired !!", user));
    }
}
