package io.github.carlinhoshk.kafkaconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {

    @KafkaListener(topics = "teste-topic", groupId = "testeGroup")
    public void listener(String data){
        System.out.println("--------------------------------------------------------------");
        System.out.println(String.format("{Consumer} - Messenger receiver: %s \n", data));
    }
}
