package com.misiontic.GameRental.repository.crudRepository;

import com.misiontic.GameRental.entities.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameCrudRepository extends CrudRepository<Game, Integer> {
}
