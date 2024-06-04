package com.codeartify.wikimedia.producer.stream;

import com.codeartify.wikimedia.producer.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class WikiMediaStreamConsumer {

    private final WebClient webClient;
    private final WikimediaProducer wikimediaProducer;

    public WikiMediaStreamConsumer(WebClient.Builder builder, WikimediaProducer wikimediaProducer) {
        this.webClient = builder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.wikimediaProducer = wikimediaProducer;
    }

    public void consumeStreamAndPublish() {
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(wikimediaProducer::publishMessage);
    }

}
