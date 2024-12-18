package io.java_brains.reactive_workshop.exerciese;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        List<Integer> numbers = ReactiveSources.intNumbersFlux()
                .log()
                .toStream()
                .toList();
        System.out.println("List is " + numbers);
        System.out.println("Size is " + numbers.size());

        // We don't need this lines anymore
        // Because the toStream() method is blocking the process
        // System.out.println("Press a key to end");
        // System.in.read();
    }

}
