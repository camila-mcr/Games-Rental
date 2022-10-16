package com.misiontic.GameRental.repository;

import com.misiontic.GameRental.entities.Administrator;
import com.misiontic.GameRental.repository.crudRepository.AdministratorCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdministratorRepository {

    @Autowired
    private AdministratorCrudRepository administratorCrudRepository;

    public List<Administrator> getAll(){
        return (List<Administrator>) administratorCrudRepository.findAll();
    }

    public Optional<Administrator> getAdministrator(int id){
        return administratorCrudRepository.findById(id);
    }

    public Administrator save(Administrator c){
        return administratorCrudRepository.save(c);
    }

    public void delete(Administrator c){
        administratorCrudRepository.delete(c);
    }


}
