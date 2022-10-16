package com.misiontic.GameRental.repository.crudRepository;

import com.misiontic.GameRental.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
