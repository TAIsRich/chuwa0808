package com.xiazhao.newfeature.stream_api;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercise {
    @Test
    public void testMapAndFlatMap() {
        List<String> words = new ArrayList<>();
        words.add("hi");
        words.add("hello");

        words.stream()
                .map(w -> w.split(""))
                .map(s -> Arrays.toString(s))
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void testMapAndFlatMap2() {
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");

        List<Stream<String>> collect = words.stream()
                .map(s -> Arrays.stream(s.split("")))
                .distinct()
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
        for (Stream<String> stringStream : collect) {
            stringStream.forEach(System.out::println);
        }
    }
}
