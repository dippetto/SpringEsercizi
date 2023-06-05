package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Ex1 {
    @GetMapping(value = "/hello")
    public String index() {
        return "Hello World!";
    }
    }