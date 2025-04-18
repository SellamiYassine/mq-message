package controller;

import org.bank.MqApplication;
import org.bank.controller.MessageController;
import org.bank.entity.Message;
import org.bank.service.MessageService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MqApplication.class)
@ActiveProfiles("test")
class MessageControllerTest {

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

    @Test
    void shouldReturnAllMessages() {
        List<Message> mockMessages = Arrays.asList(new Message(1L, "msg1", LocalDateTime.now()), new Message(2L, "msg2", LocalDateTime.now()));
        when(messageService.findAll()).thenReturn(mockMessages);

        List<Message> result = messageController.getAllMessages();
        assertEquals(2, result.size());
        verify(messageService, times(1)).findAll();
    }

    @Test
    void shouldReturnMessageById() {
        Message message = new Message(1L, "msg1", LocalDateTime.now());
        when(messageService.findById(1L)).thenReturn(Optional.of(message));

        ResponseEntity<Message> response = messageController.getMessage(1L);
        assertEquals("msg1", response.getBody().getMessage());
    }
}
