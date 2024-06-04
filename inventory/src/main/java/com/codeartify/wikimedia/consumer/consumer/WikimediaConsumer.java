package com.codeartify.wikimedia.consumer.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WikimediaConsumer {

    @KafkaListener(
            topics = "wikimedia-stream",
            groupId = "myGroup"
    )
    public void consumeMessage(String message) {
        log.info("Consumed message: %s".formatted(message));
    }

 }
