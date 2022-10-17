package com.example.demo.crudrepository;

import com.example.demo.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}