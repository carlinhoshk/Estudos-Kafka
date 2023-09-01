package io.github.carlinhoshk.kafkaconsumer.listeners;

import io.github.carlinhoshk.kafkaconsumer.entities.Message;
import io.github.carlinhoshk.kafkaconsumer.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {

    @Autowired
    private MessageRepository messageRepository;

    @KafkaListener(topics = "test-topic", groupId = "testGroup")
    public void listener(Message data){
        System.out.println("--------------------------------------------------------------");
        System.out.printf("{Consumer} - Messenger receiver: %s \n%n", data);


        messageRepository.save(data);
    }
}