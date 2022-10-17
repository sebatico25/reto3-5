package com.example.demo.crudrepository;

import com.example.demo.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Integer>{
    
}