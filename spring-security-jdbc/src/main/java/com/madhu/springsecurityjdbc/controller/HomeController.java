package com.madhu.springsecurityjdbc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/")
    public ResponseEntity<Object> home(){
        return ResponseEntity.status(HttpStatus.OK).body("<h1>Welcome</h1>");
    }

    @GetMapping(value = "/user")
    public ResponseEntity<Object> user(){
        return ResponseEntity.status(HttpStatus.OK).body("<h1>Welcome, User</h1>");
    }

    @GetMapping(value = "/admin")
    public ResponseEntity<Object> admin(){
        return ResponseEntity.status(HttpStatus.OK).body("<h1>Welcome, Admin</h1>");
    }
    
}
