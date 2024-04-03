package com.codeartify.kafkademo.rest;

import com.codeartify.kafkademo.payload.Student;
import com.codeartify.kafkademo.producer.KafkaProducer;
import com.codeartify.kafkademo.producer.StudentProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final KafkaProducer kafkaProducer;
    private final StudentProducer studentProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.publishMessage(message);
        return ResponseEntity.ok("Message sent to Kafka topic");
    }

    @PostMapping("/student")
    public ResponseEntity<String> sendStudent(@RequestBody Student student) {
        studentProducer.publishStudent(student);
        return ResponseEntity.ok(student+" sent to Kafka topic");
    }


}
