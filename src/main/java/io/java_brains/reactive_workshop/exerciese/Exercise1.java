package io.java_brains.reactive_workshop.exerciese;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(i -> i<5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(i -> i>5)
                .skip(1)
                .limit(2).forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        StreamSources.intNumbersStream().filter(i -> i>5)
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("-1"));
        // Doing it in another way:
        Integer value = StreamSources.intNumbersStream().filter(i -> i > 5)
                .findFirst().orElse(-1);
        System.out.println(value);

        // Print first names of all users in userStream
        StreamSources.userStream()
                .map(User::getFirstName)
                .forEach(System.out::println);

        // Print first names in userStream for users that have IDs from number stream
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(i -> user.getId() == i))
                .map(User::getFirstName)
                .forEach(System.out::println);
        // Doing it using flatMap
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(User::getFirstName)
                .forEach(System.out::println);
        // flatMap is used for this situations in which the result of map is also a stream
    }
}
