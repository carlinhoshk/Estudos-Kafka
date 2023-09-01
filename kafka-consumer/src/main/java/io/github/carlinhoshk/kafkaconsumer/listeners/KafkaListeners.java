package io.github.carlinhoshk.kafkaconsumer.listeners;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.carlinhoshk.kafkaconsumer.entities.Message;
import io.github.carlinhoshk.kafkaconsumer.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaListeners {
    @Autowired
    private MessageRepository messageRepository; // Certifique-se de que você injetou o repository corretamente

    @KafkaListener(topics = "test-topic", groupId = "testGroup")
    public void listener(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Message messageObj = objectMapper.readValue(message, Message.class);

            System.out.println("--------------------------------------------------------------");
            System.out.printf("{Consumer} - Message received: %s \n%n", messageObj);

            messageRepository.save(messageObj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}