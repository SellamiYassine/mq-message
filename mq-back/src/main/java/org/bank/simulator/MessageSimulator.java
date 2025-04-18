package org.bank.simulator;

import org.bank.entity.Message;
import org.bank.service.MessageService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class MessageSimulator {

    private final MessageService service;

    public MessageSimulator(MessageService service) {
        this.service = service;
    }

    // Simuler un nouveau message toutes les 30 secondes
    @Scheduled(fixedRate = 30000)
    public void simulateMessage() {
        Message message = Message.builder()
                .message("Message simulé pour tester le système")
                .receivedDateTime(LocalDateTime.now()).build();
        service.save(message);
    }
}

