package com.misiontic.GameRental.service;

import com.misiontic.GameRental.entities.Game;
import com.misiontic.GameRental.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll(){
        return gameRepository.getAll();
    }

    public Optional<Game> getGame(int id){
        return gameRepository.getGame(id);
    }

    public Game save(Game g){
        if (g.getId()==null){
            return gameRepository.save(g);
        }else{
            Optional<Game> e=gameRepository.getGame(g.getId());
            if (e.isPresent()){
                return g;
            }else{
                return gameRepository.save(g);
            }
        }
    }

    public Game update(Game g){
        if (g.getId()!=null){
            Optional<Game> q=gameRepository.getGame(g.getId());
            if(q.isPresent()){
                if(g.getDeveloper()!=null){
                    q.get().setDeveloper(g.getDeveloper());
                }
                if(g.getMinage()!=null){
                    q.get().setMinage(g.getMinage());
                }
                if(g.getCategory_id()!=null){
                    q.get().setCategory_id(g.getCategory_id());
                }
                if(g.getCategory()!=null){
                    q.get().setCategory(g.getCategory());
                }
                gameRepository.save(q.get());
                return q.get();
            }else{
                return g;
            }
        }else{
            return g;
        }
    }

    public boolean delete(int id){

        boolean flag=false;
        Optional<Game> g=gameRepository.getGame(id);
        if(g.isPresent()){
            gameRepository.delete(g.get());
            flag=true;
        }
        return flag;
    }

}
