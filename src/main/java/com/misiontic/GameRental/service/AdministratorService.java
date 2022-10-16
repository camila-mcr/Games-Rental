package com.misiontic.GameRental.service;

import com.misiontic.GameRental.entities.Administrator;
import com.misiontic.GameRental.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public List<Administrator> getAll(){
        return administratorRepository.getAll();
    }

    public Optional<Administrator> getAdministrator(int id){
        return administratorRepository.getAdministrator(id);
    }

    public Administrator save(Administrator c){
        if (c.getId()==null){
            return administratorRepository.save(c);
        }else{
            Optional<Administrator> e= administratorRepository.getAdministrator(c.getId());
            if (e.isPresent()){
                return c;
            }else{
                return administratorRepository.save(c);
            }
        }
    }

    public Administrator update(Administrator c){
        if (c.getId()!=null){
            Optional<Administrator> q= administratorRepository.getAdministrator(c.getId());
            if(q.isPresent()){
                if(c.getName()!=null){
                    q.get().setName(c.getName());
                }
                if(c.getEmail()!=null){
                    q.get().setEmail(c.getEmail());
                }
                if(c.getPassword()!=null){
                    q.get().setPassword(c.getPassword());
                }

                administratorRepository.save(q.get());
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
        Optional<Administrator> c= administratorRepository.getAdministrator(id);
        if(c.isPresent()){
            administratorRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }

}
