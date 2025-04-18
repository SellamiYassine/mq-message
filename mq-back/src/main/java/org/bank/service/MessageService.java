package org.bank.service;


import org.bank.entity.Message;
import org.bank.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public List<Message> findAll() {
        return repository.findAll();
    }

    public Optional<Message> findById(Long id) {
        return repository.findById(id);
    }

    public Message save(Message msg) {
        return repository.save(msg);
    }
}

