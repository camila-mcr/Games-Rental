package com.misiontic.GameRental.service;

import com.misiontic.GameRental.entities.Reservation;
import com.misiontic.GameRental.entities.custom.CountClient;
import com.misiontic.GameRental.entities.custom.StatusAmount;
import com.misiontic.GameRental.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public List<CountClient> getTopClient() {
        return reservationRepository.getTopClient();
    }

    public StatusAmount getStatusReport() {
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");
        StatusAmount statusAmount = new StatusAmount(completed.size(), cancelled.size());
        return statusAmount;
    }

    public List<Reservation> getReservationPeriod(String startDateString, String devolutionDateString) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date();
        Date devolutionDate = new Date();
        try {
            startDate = parser.parse(startDateString);
            devolutionDate = parser.parse(devolutionDateString);
        } catch (ParseException e) {
        }
        if (startDate.before(devolutionDate)) {
            return reservationRepository.getReservationPeriod(startDate, devolutionDate);
        }
        return new ArrayList<>();
    }

}
