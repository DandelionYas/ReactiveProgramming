package io.java_brains.reactive_workshop.exerciese;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

        // Get the value from the Mono into a String variable but give up after 5 seconds
        String foo = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        List<String> list = ReactiveSources.unresponsiveFlux()
                .collectList() // Gives us a Mono of the list: then we can block on mono to get the value
                .block(Duration.ofSeconds(5));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
