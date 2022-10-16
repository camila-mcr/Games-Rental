package com.misiontic.GameRental.repository;

import com.misiontic.GameRental.entities.Message;
import com.misiontic.GameRental.entities.Reservation;
import com.misiontic.GameRental.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation g){
        return reservationCrudRepository.save(g);
    }

    public void delete(Reservation g){
        reservationCrudRepository.delete(g);
    }
}
