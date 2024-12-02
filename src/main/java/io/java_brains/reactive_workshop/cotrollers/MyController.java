package io.java_brains.reactive_workshop.cotrollers;

import io.java_brains.reactive_workshop.services.MyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MyController {
    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    /**
     * Will take 5 seconds for the response to be ready
     * No thread will be waiting
     * The process returns immediately, Netty will take care of delay in reactive way
     * @return a Mono containing the message
     */
    @GetMapping("/demo")
    public Mono<String> greeting() {
        return myService.computeMessage()
                .zipWith(myService.getNameFromDB())
                .map(tuple -> tuple.getT1() + tuple.getT2());
    }
}
