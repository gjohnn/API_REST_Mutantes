package com.juanGuerrero.adn_mutantes.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/adn")
public class ADNController {
    @GetMapping("")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok().body("ADN");
    }

    @PostMapping("")
    public ResponseEntity<?> store() {
        return ResponseEntity.ok().body("ADN");
    }

    @GetMapping("{id}")
    public ResponseEntity<?> show(@PathVariable UUID id) {
        return ResponseEntity.ok().body(id);
    }
    
}
