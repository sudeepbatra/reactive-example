package com.stoxalpha.reactiveworkshop;

import java.util.Optional;

public class Exercise1 {
    public static void main(String[] args) {

        StreamSources.intNumbersStream().forEach(number -> {
            System.out.println("Number:" + number);
        });

        StreamSources.intNumbersStream().filter(number -> number < 5).forEach(number -> {
            System.out.println("Number less than five: " + number);
        });

        StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(number -> {
                    System.out.println("Number greater than five (Second and Third numbers only): " + number);
                });

        Integer value = StreamSources.intNumbersStream().filter(number -> number > 5).findFirst().orElse(-1);
        System.out.println("First number greater than 5 else -1: " + value);

        StreamSources.userStream()
                .map(User::getFirstName)
                .forEach(System.out::println);

        StreamSources.intNumbersStream().flatMap(id -> StreamSources.userStream().filter(user -> user.getUserId() == id))
                .map(User::getFirstName)
                .forEach(userName -> System.out.println(userName));

        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(integer -> integer == user.getUserId()))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);
    }
}
