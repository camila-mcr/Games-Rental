package com.misiontic.GameRental.controller;

import com.misiontic.GameRental.entities.Category;
import com.misiontic.GameRental.entities.Game;
import com.misiontic.GameRental.service.CategoryService;
import com.misiontic.GameRental.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category c){
        return categoryService.save(c);
    }

}
