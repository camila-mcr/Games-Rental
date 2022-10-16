package com.misiontic.GameRental.controller;

import com.misiontic.GameRental.entities.Administrator;
import com.misiontic.GameRental.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("/all")
    public List<Administrator> getAll(){
        return administratorService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrator save(@RequestBody Administrator a){
        return administratorService.save(a);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Administrator update(@RequestBody Administrator administrator) {
        return administratorService.update(administrator);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return administratorService.delete(id);
    }

}
