package io.java_brains.reactive_workshop.services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class MyService {


    public Mono<String> computeMessage() {
        return Mono.just("Hello ").delayElement(Duration.ofSeconds(5));
    }

    public Mono<String> getNameFromDB() {
        return Mono.just("Yaser").delayElement(Duration.ofSeconds(2));
    }
}
