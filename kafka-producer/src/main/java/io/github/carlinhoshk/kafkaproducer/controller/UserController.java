package io.github.carlinhoshk.kafkaproducer.controller;


import io.github.carlinhoshk.kafkaproducer.dto.UserRequest;
import io.github.carlinhoshk.kafkaproducer.producer.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class UserController {

    private final KafkaProducer producer;

    public UserController(KafkaProducer producer){
        this.producer = producer;
    }

    @PostMapping(value = "/new")
    public ResponseEntity<String> newUser(@RequestBody UserRequest request){
        producer.send(request);
        return new ResponseEntity<>("User create", HttpStatus.CREATED);
    }
}
