package com.madhu.springsecurityjpa.controller;

import com.madhu.springsecurityjpa.command.UserCommand;
import com.madhu.springsecurityjpa.exception.NoRecordFoundException;
import com.madhu.springsecurityjpa.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<Object> welcome(@RequestParam String user) {
        return ResponseEntity.status(HttpStatus.OK).body(String.format("<h1>Welcome, %s</h1>", user));
    }

    @GetMapping(value = "/user")
    public ResponseEntity<Object> user(@RequestParam String user) {
        return ResponseEntity.status(HttpStatus.OK).body(String.format("<h1>Welcome User, %s</h1>", user));
    }

    @GetMapping(value = "/admin")
    public ResponseEntity<Object> admin(@RequestParam String user) {
        return ResponseEntity.status(HttpStatus.OK).body(String.format("<h1>Welcome Admin, %s</h1>", user));
    }

    @GetMapping(value = "/getUser")
    public ResponseEntity<UserCommand> getUser(@RequestParam long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @GetMapping(value = "/getUserByName")
    public ResponseEntity<Object> getUserByName(@RequestParam String user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByName(user));
    }

    @ExceptionHandler(NoRecordFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNoRecordFoundException(NoRecordFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}
