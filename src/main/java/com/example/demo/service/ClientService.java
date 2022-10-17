package com.example.demo.service;

import com.example.demo.entities.Client;
import com.example.demo.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getById(Integer id) {
        return clientRepository.getById(id);
    }

    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> optional = clientRepository.getById(client.getIdClient());
            if (optional.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> optional = clientRepository.getById(client.getIdClient());
            if (!optional.isEmpty()) {
                if (client.getEmail() != null) {
                    optional.get().setName(client.getEmail());
                }
                if (client.getPassword() != null) {
                    optional.get().setPassword(client.getPassword());
                }
                if (client.getName() != null) {
                    optional.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    optional.get().setAge(client.getAge());
                }
                clientRepository.save(optional.get());
                return optional.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getById(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}