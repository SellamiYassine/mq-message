package service;



import org.bank.MqApplication;
import org.bank.entity.Message;
import org.bank.repository.MessageRepository;
import org.bank.service.MessageService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MqApplication.class)
@ActiveProfiles("test")
class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    @Test
    void shouldReturnAllMessages() {
        List<Message> mockMessages = Arrays.asList(new Message(1L, "msg1", LocalDateTime.now()), new Message(2L, "msg2", LocalDateTime.now()));
        when(messageRepository.findAll()).thenReturn(mockMessages);

        List<Message> result = messageService.findAll();
        assertEquals(2, result.size());
    }

    @Test
    void shouldReturnMessageById() {
        Message message = new Message(1L, "msg", LocalDateTime.now());
        when(messageRepository.findById(1L)).thenReturn(Optional.of(message));

        Optional<Message> result = messageService.findById(1L);
        assertTrue(result.isPresent());
        assertEquals("msg", result.get().getMessage());
    }
}

