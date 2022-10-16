package com.misiontic.GameRental.repository;

import com.misiontic.GameRental.entities.Message;
import com.misiontic.GameRental.repository.crudRepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    public Message save(Message g){
        return messageCrudRepository.save(g);
    }

    public void delete(Message g){
        messageCrudRepository.delete(g);
    }
}
