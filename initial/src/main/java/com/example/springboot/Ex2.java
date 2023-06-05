package com.example.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

public class Ex2 {
    @GetMapping(value = "/greeting")
    public ResponseEntity<String> greeting() {
        if (new Date().getHours() < 12) {
            return ResponseEntity.badRequest().body("è mattina");
        }
        return ResponseEntity.status(200).body("Buon pomeriggio");
    }
}
