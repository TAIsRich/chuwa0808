package stream_api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collections 讲的是数据，Stream讲的是计算（CPU）
 * 1. Stream 自己不会存储元素
 * 2. Stream 不会改变源对象，相反，他们会返回一个持有结果的新stream
 * 3. Stream操作是延迟执行的，这意味着他们会等到需要结果的时候才执行。
 * Stream执行流程：
 * 1. 创建Stream： 获取一个数据源
 * 2. 中间操作： 一个操作链： 对数据进行处理
 * 3. 终止操作： 一旦执行中止操作，则会开始执行中间操作链，并产生结果。之后，不会再被使用。
 */
public class StreamApiEndOperation {
    public static void main(String[] args) {
        testMatch();
    }
    private static final List<Employee> EMPLOYEES = EmployeeData.getEmployees();


    public static void testMatch() {
//        1， allMatch(Predicate p) - 检查是否匹配所有的元素
        boolean allMatch = EMPLOYEES.stream().allMatch(e -> e.getName().length() > 2);
        System.out.println(allMatch);

        System.out.println("***************************");

//        2， anyMatch(Predicate p) - 检查是否至少匹配一个元素
        boolean anyMatch = EMPLOYEES.stream().anyMatch(e -> e.getName().length() > 3);
        System.out.println(anyMatch);

        System.out.println("**************************");

//        3， noneMatch(Predicate p) - 检查是否没有匹配的元素
        boolean noneMatch = EMPLOYEES.stream().noneMatch(e -> e.getName().startsWith("Yun"));
        System.out.println(noneMatch);
    }

    public static void testFind() {
//        4, findFirst - 返回第一个元素
        Optional<Employee> employee = EMPLOYEES.stream().findFirst();
        System.out.println(employee);

//        5， findAny - 返回当前流中的任意元素
        Optional<Employee> any = EMPLOYEES.parallelStream().findAny();
        System.out.println(any);
    }

    public static void testCountMaxMin() {
//        6, count - 返回流中元素的个数
        long count = EMPLOYEES.stream().filter(e -> e.getAge() > 40).count();
        System.out.println("num of employees(age > 40): " + count);

//        7, max(Comparator c) - 返回流中的最大值
        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> max = stream.max(Integer::compare);
        System.out.println("max age is: " + max);

//        8, min(Comparator c) - 返回流中的最小值
        Optional<Employee> min = EMPLOYEES.stream()
                .min(Comparator.comparingInt(Employee::getId));
        System.out.println("min age is : " + min);

        EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40)
                .map(e -> e.getName() + " ： OLD PPL")
                .forEach(System.out::println);

        List<String> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40).map(e -> e.getName() + " ： OLD PPL")
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public static void testIteration() {
//        9, forEach(Consumer c) - 内部迭代
        EMPLOYEES.stream().forEach(System.out::println);

        System.out.println("\n********************************\n");
        // 使用集合的迭代
        EMPLOYEES.forEach(System.out::println);
    }

    public static void testReduce() {
//        1, reduce(T identity, BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
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

    public static void testCollect() {
        List<Employee> collect = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Set<Employee> collect2 = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toSet());
        collect2.forEach(System.out::println);
    }

    public static void testChain() {
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
