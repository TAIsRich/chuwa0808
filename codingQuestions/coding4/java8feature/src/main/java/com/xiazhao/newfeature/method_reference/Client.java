package com.xiazhao.newfeature.method_reference;

import java.util.Arrays;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        Stream<String> s = Arrays.stream(new String[]{"A", "B"});
        s.map(String::toLowerCase).forEach(System.out::println);
    }
}
