package com.misiontic.GameRental.controller;

import com.misiontic.GameRental.entities.Category;
import com.misiontic.GameRental.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c){
        return categoryService.save(c);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return categoryService.delete(id);
    }

}
