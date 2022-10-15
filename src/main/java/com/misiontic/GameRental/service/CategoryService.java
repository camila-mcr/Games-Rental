package com.misiontic.GameRental.service;

import com.misiontic.GameRental.entities.Category;
import com.misiontic.GameRental.entities.Game;
import com.misiontic.GameRental.repository.CategoryRepository;
import com.misiontic.GameRental.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getGame(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c){
        if (c.getId()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> e=categoryRepository.getCategory(c.getId());
            if (e.isPresent()){
                return c;
            }else{
                return categoryRepository.save(c);
            }
        }
    }

    public Category update(Category c){
        if (c.getId()!=null){
            Optional<Category> q=categoryRepository.getCategory(c.getId());
            if(q.isPresent()){
                if(c.getName()!=null){
                    q.get().setName(c.getName());
                }
                categoryRepository.save(q.get());
                return q.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }

    public boolean delete(int id){

        boolean flag=false;
        Optional<Category> c=categoryRepository.getCategory(id);
        if(c.isPresent()){
            categoryRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }

}
