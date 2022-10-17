package com.example.demo.crudrepository;

import com.example.demo.entities.Machine;
import org.springframework.data.repository.CrudRepository;

public interface MachineCrudRepository extends CrudRepository<Machine, Integer>{
    
}
