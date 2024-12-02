package io.java_brains.reactive_workshop.exerciese;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        ReactiveSources.intNumbersFluxWithException()
                // By only having this the error will not be caught, this message will be printed as additional message
                .doOnError(e -> System.err.println("Error: " + e.getMessage()))
                .subscribe(System.out::println,
                        // This parameter acts like a catch: Swallows the error
                        err -> System.out.println("Error Happened: " + err.getMessage())
                );

        // Print values from intNumbersFluxWithException and continue on errors
        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((e, item) -> System.out.println("Error!!! " + e.getMessage()))
                .subscribe(System.out::println);

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }
}
