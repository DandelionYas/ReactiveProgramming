package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        ReactiveSources.intNumbersFlux().subscribe(System.out::println);

        // Print all users in the ReactiveSources.userFlux stream
        ReactiveSources.userFlux().subscribe(System.out::println);

        // This line's responsibility is to keep process running to see the reactive events happening.
        // Because reactive APIs don't block the thread
        System.out.println("Press a key to end");
        System.in.read();
    }

}
