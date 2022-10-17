package com.example.demo.repository;

import com.example.demo.crudrepository.MachineCrudRepository;
import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Machine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MachineRepository {
    
    @Autowired
    private MachineCrudRepository machineCrudRepository;
    
    public List<Machine> getAll(){
        return (List<Machine>) machineCrudRepository.findAll();
    }
    
    public Optional<Machine> getById(Integer id){
        return machineCrudRepository.findById(id);
    }
    
    public Machine save(Machine machine){
        return machineCrudRepository.save(machine);
    }
    
    public void delete (Machine machine){
        machineCrudRepository.delete(machine);
    }
    
}
