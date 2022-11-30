package edu.javagroup.seabattle.controller.rest.impl;

import edu.javagroup.seabattle.controller.rest.PulseController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PulseControllerImpl implements PulseController {

    @Override
    public ResponseEntity<String> pulse() {
        return new ResponseEntity<>("Im alive!", HttpStatus.OK);
    }
}
