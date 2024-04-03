package com.codeartify.kafkademo.producer;

import com.codeartify.kafkademo.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class StudentProducer {
    private final KafkaTemplate<String, Student> kafkaTemplate;

    public void publishStudent(Student student) {

        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC, "my-topic")
                .build();

        kafkaTemplate.send(message);
        log.info("Sending message to my topic: %s".formatted(student));
    }
}
