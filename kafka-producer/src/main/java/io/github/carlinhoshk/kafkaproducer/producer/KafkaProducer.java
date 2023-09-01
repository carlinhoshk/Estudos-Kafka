package io.github.carlinhoshk.kafkaproducer.producer;

import io.github.carlinhoshk.kafkaproducer.dto.UserRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, UserRequest> kafkaTemplate;
    private static final String TOPIC = "test-topic";

    public KafkaProducer(KafkaTemplate<String, UserRequest> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(UserRequest request){
        Message<UserRequest> message = MessageBuilder
                .withPayload(request)
                .setHeader(KafkaHeaders.TOPIC, TOPIC)
                .build();

        System.out.println("{Producer} Message send.");
        kafkaTemplate.send(message);
    }

}
