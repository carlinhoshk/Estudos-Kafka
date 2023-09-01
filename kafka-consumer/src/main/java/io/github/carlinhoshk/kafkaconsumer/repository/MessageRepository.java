package io.github.carlinhoshk.kafkaconsumer.repository;

import io.github.carlinhoshk.kafkaconsumer.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
