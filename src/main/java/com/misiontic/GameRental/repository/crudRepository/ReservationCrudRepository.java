package com.misiontic.GameRental.repository.crudRepository;

import com.misiontic.GameRental.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
