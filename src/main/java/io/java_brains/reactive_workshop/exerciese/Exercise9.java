package io.java_brains.reactive_workshop.exerciese;

import java.io.IOException;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        // Count returns a Mono which contains the total number of elements
        // So we can subscribe to it or call a block method on it
        ReactiveSources.intNumbersFlux().count().subscribe(System.out::println);

        // Collect all items of intNumbersFlux into a single list and print it
        // collectList() returns a Mono of a single list
        ReactiveSources.intNumbersFlux().collectList().subscribe(System.out::println);

        // Transform to a sequence of sums of adjacent two numbers
        ReactiveSources.intNumbersFlux()
                        .buffer(2) // returns a Flux of list of two elements: every event will happen after two
                        .map(list -> list.get(0) + list.get(1))
                        .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
