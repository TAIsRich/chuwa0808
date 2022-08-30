package stream_api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercise {
    @Test
    public void testMapAndFlatMap() {
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");

        List<String> stringList = words.stream()
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());
        stringList.forEach(e -> System.out.println(e));
    }

    @Test
    public void testMapAndFlatMap2() {
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");

        List<Stream<String>> collect = words.stream()
                .map(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());
        collect.forEach(e -> System.out.println(e));
        System.out.println("**** above are stream objects, below are character *****");
        for (Stream<String> stringStream : collect) {
            stringStream.forEach(System.out::println);
        }
    }
}
