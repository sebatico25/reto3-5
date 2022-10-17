package com.example.demo.service;

import com.example.demo.entities.Message;
import com.example.demo.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getById(Integer id) {
        return messageRepository.getById(id);
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> optional = messageRepository.getById(message.getIdMessage());
            if (!optional.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }

    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> optional = messageRepository.getById(message.getIdMessage());
            if (!optional.isEmpty()) {
                if (message.getMessageText() != null) {
                    optional.get().setMessageText(message.getMessageText());
                    optional.get().setClient(message.getClient());
                    optional.get().setMachine(message.getMachine());
                }
                messageRepository.save(optional.get());
                return optional.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getById(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    
    }
}
