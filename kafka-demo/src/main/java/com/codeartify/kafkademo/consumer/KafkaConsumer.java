package com.codeartify.kafkademo.consumer;

import com.codeartify.kafkademo.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    public void consumeMessage(String message) {
        log.info("Consumed message: %s".formatted(message));
    }

    @KafkaListener(
            topics = "my-topic",
            groupId = "myGroup"
    )
    public void consumeStudent(Student student) {
        log.info("Consumed message: %s".formatted(student.toString()));
    }
}
