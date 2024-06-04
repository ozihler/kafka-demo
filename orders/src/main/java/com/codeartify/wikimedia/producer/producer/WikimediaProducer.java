package com.codeartify.wikimedia.producer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
@Slf4j
public class WikimediaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void publishMessage(String message) {
        log.info(format("Publish message to wikimedia-stream: %s", message));
        kafkaTemplate.send("wikimedia-stream", message);
    }
}
