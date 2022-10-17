package com.example.demo.service;

import com.example.demo.entities.Machine;
import com.example.demo.repository.MachineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineService {

    @Autowired
    private MachineRepository machineRepository;

    public List<Machine> getAll() {
        return machineRepository.getAll();
    }

    public Optional<Machine> getById(Integer id) {
        return machineRepository.getById(id);
    }

    public Machine save(Machine machine) {
        if (machine.getId() == null) {
            return machineRepository.save(machine);
        } else {
            Optional<Machine> optional = machineRepository.getById(machine.getId());
            if (optional.isEmpty()) {
                return machineRepository.save(machine);
            } else {
                return machine;
            }
        }
    }

    public Machine update(Machine machine) {
        if (machine.getId() != null) {
            Optional<Machine> optional = machineRepository.getById(machine.getId());
            if (!optional.isEmpty()) {
                if (machine.getName() != null) {
                    optional.get().setName(machine.getName());
                }
                if (machine.getBrand() != null) {
                    optional.get().setBrand(machine.getBrand());
                }
                if (machine.getYear() != null) {
                    optional.get().setYear(machine.getYear());
                }
                if (machine.getDescription() != null) {
                    optional.get().setDescription(machine.getDescription());
                }
                if (machine.getCategory() != null) {
                    optional.get().setCategory(machine.getCategory());
                }
                machineRepository.save(optional.get());
                return optional.get();
            } else {
                return machine;
            }
        } else {
            return machine;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getById(id).map(machine -> {
            machineRepository.delete(machine);
            return true;
        }).orElse(false);
        return aBoolean;

    }
}
