package edu.javagroup.seabattle.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static edu.javagroup.seabattle.controller.PathConstants.*;

public interface GameController {

    @GetMapping(LAN_TEST)
    ResponseEntity<Boolean> lanTest();

    /**
     * враг проверяет готовность
     */
    @GetMapping(IM_READY)
    ResponseEntity<Boolean> enemyReady();

    /**
     * враг отправляет бомбу
     */
    @PostMapping(SET_BOMB)
    ResponseEntity<Boolean> enemySetBomb(@RequestParam("row") int row, @RequestParam("col") int col);
}
