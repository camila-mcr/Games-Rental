package com.misiontic.GameRental.service;

import com.misiontic.GameRental.entities.Reservation;
import com.misiontic.GameRental.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation c){
        if (c.getIdReservation()==null){
            return reservationRepository.save(c);
        }else{
            Optional<Reservation> e= reservationRepository.getReservation(c.getIdReservation());
            if (e.isEmpty()){
                return reservationRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Reservation update(Reservation c){
        if (c.getIdReservation()!=null){
            Optional<Reservation> q= reservationRepository.getReservation(c.getIdReservation());
            if(!q.isPresent()){
                if(c.getStartDate()!=null){
                    q.get().setStartDate(c.getStartDate());
                }
                if(c.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(c.getDevolutionDate());
                }
                if(c.getStatus()!=null){
                    q.get().setStatus(c.getStatus());
                }
                if(c.getGame()!=null){
                    q.get().setGame(c.getGame());
                }
                if(c.getClient()!=null){
                    q.get().setClient(c.getClient());
                }
                if(c.getScore()!=null){
                    q.get().setScore(c.getScore());
                }
                reservationRepository.save(q.get());
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
        Optional<Reservation> c= reservationRepository.getReservation(id);
        if(c.isPresent()){
            reservationRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }

}
