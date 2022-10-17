package com.misiontic.GameRental.controller;

import com.misiontic.GameRental.entities.Reservation;
import com.misiontic.GameRental.entities.Score;
import com.misiontic.GameRental.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score s){
        return scoreService.save(s);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Score update(@RequestBody Score score) {
        return scoreService.update(score);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return scoreService.delete(id);
    }

}
