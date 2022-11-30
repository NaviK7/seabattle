package edu.javagroup.seabattle.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface PulseController {

    @GetMapping
    ResponseEntity<String> pulse();
}
