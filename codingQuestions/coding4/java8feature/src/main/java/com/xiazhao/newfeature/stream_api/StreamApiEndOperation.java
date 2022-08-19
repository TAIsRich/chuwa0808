package com.xiazhao.newfeature.stream_api;

import com.xiazhao.data.Employee;
import com.xiazhao.data.EmployeeData;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiEndOperation {
    private static final List<Employee> EMPLOYEES = EmployeeData.getEmployees();

    @Test
    public void testMatch() {
        boolean allMatch = EMPLOYEES.stream().allMatch(e -> e.getName().length() > 2);
        System.out.println(allMatch);

        System.out.println("==============================");

        boolean anyMatch = EMPLOYEES.stream().anyMatch(e -> e.getName().length() > 3);
        System.out.println(anyMatch);
        System.out.println("+++++++++++++++++++++++++++++++");

        boolean noneMatch = EMPLOYEES.stream().noneMatch(e -> e.getName().length() > 4);
        System.out.println(noneMatch);
    }

    @Test
    public void testFind() {
        Optional<Employee> optional = EMPLOYEES.stream().findFirst();
        System.out.println(optional.get().getName());

        Optional<Employee> optional1 = EMPLOYEES.parallelStream().findAny();
    }

    @Test
    public void testCountMaxMin() {
        long count = EMPLOYEES.stream().filter(e -> e.getAge() > 34).count();
        System.out.println(count);

        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        int max = stream.max(Integer::compare).get();
        System.out.println(max);

        Optional<Employee> min = EMPLOYEES.stream()
                .min(Comparator.comparing(Employee::getId));
        System.out.println(min.get().getAge());

        EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40)
                .map(e -> e.getName() + " : OLD PPL")
                .forEach(System.out::println);

        List<String> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40)
                .map(e -> e.getName() + " : OLD PPL")
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void testIteration() {
        EMPLOYEES.stream().forEach(System.out::println);
        EMPLOYEES.forEach(System.out::println);
    }

    @Test
    public void testReduce() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

//        2, reduce(BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce1 = stream.reduce(Integer::sum);
        System.out.println(reduce1);

        Stream<Integer> stream2 = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce2 = stream2.reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce2.get());
    }

    @Test
    public void testCollect() {
        List<Employee> collect = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Set<Employee> collect2 = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toSet());
        collect2.forEach(System.out::println);
    }

    @Test
    public void testChain() {
        List<Double> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .map(e -> e.getSalary() * 0.8)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("********************");

        Optional<Integer> reduce = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .map(e -> e.getSalary() * 0.8)
                .map(e -> {
                    System.out.println(e);
                    return e.intValue();
                })
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }
}
