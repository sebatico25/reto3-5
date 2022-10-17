package com.example.demo.repository;

import com.example.demo.crudrepository.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    
    public Optional<Message> getById(Integer id){
        return messageCrudRepository.findById(id);
    }
    
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    
    public void delete (Message message){
        messageCrudRepository.delete(message);
    }
    
}