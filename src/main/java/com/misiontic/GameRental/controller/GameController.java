package com.misiontic.GameRental.controller;

import com.misiontic.GameRental.entities.Game;
import com.misiontic.GameRental.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Game")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/all")
    public List<Game> getAll(){
        return gameService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody Game g){
        return gameService.save(g);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Game update(@RequestBody Game game) {
        return gameService.update(game);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return gameService.delete(id);
    }

}
