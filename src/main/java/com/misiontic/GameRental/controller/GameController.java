package com.misiontic.GameRental.controller;

import com.misiontic.GameRental.entities.Game;
import com.misiontic.GameRental.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/all")
    public List<Game> getAll(){
        return gameService.getAll();
    }

    @PostMapping("/save")
    public Game save(@RequestBody Game g){
        return gameService.save(g);
    }
}
