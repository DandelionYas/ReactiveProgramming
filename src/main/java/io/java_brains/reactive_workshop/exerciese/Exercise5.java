package io.java_brains.reactive_workshop.exerciese;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(
                System.out::println,
                e -> System.out.println(e.getMessage()),
                () -> System.out.println("Completed"));

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }
}

class MySubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");
        // Define the backpressure volume
        // It says give me items when they are ready
        // Otherwise the Publisher would not send it when its ready
        request(1);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value.toString() + " Received");
        // It's still working based on push model
        // Item will be sent based on producer's schedule
        // It's just saying I'm ready for the next item, whenever you want to send
        request(1);
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        System.out.println(throwable.getMessage());
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("Completed!");
    }
}