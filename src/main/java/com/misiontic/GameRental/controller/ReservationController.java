package com.misiontic.GameRental.controller;

import com.misiontic.GameRental.entities.Message;
import com.misiontic.GameRental.entities.Reservation;
import com.misiontic.GameRental.entities.custom.CountClient;
import com.misiontic.GameRental.entities.custom.StatusAmount;
import com.misiontic.GameRental.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return reservationService.delete(id);
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationDescriptionAmount() {
        return reservationService.getStatusReport();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getCountClient() {
        return reservationService.getTopClient();
    }

    @GetMapping("report-dates/{startDate}/{devolutionDate}")
    public List<Reservation> getReservationReport(@PathVariable("startDate") String startDateString, @PathVariable("devolutionDate") String devolutionDateString) {
        return reservationService.getReservationPeriod(startDateString, devolutionDateString);
    }

}
