package com.stoxalpha.reactiveworkshop;

import java.util.stream.Stream;

public class StreamSources {

    public static Stream<String> stringNumbersStream() {
        return Stream.of("one", "two", "three", "four", "five", "six", "seven");
    }

    public static Stream<Integer> intNumbersStream() {
        return Stream.iterate(0, i -> i + 2).limit(10);
    }

    public static Stream<User> userStream() {
        return Stream.of(
                new User(1, "A", "B"),
                new User(2, "C", "D"),
                new User(3, "E", "F"),
                new User(3, "G", "H"),
                new User(4, "I", "J"),
                new User(5, "L", "L")
        );
    }
}
