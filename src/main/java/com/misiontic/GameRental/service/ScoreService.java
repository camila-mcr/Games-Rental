package com.misiontic.GameRental.service;

import com.misiontic.GameRental.entities.Score;
import com.misiontic.GameRental.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score c){
        if (c.getIdScore()==null){
            return scoreRepository.save(c);
        }else{
            Optional<Score> e= scoreRepository.getScore(c.getIdScore());
            if (e.isEmpty()){
                return scoreRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Score update(Score c){
        if (c.getIdScore()!=null){
            Optional<Score> q= scoreRepository.getScore(c.getIdScore());
            if(!q.isPresent()){
                if(c.getMessageText()!=null){
                    q.get().setMessageText(c.getMessageText());
                }
                if(c.getStars()!=null){
                    q.get().setStars(c.getStars());
                }

                scoreRepository.save(q.get());
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
        Optional<Score> c= scoreRepository.getScore(id);
        if(c.isPresent()){
            scoreRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }

}
