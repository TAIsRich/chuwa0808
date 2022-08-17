package stream_api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
public class StreamApiIntermediateOperation {

    public static void main(String[] args) {
        testFilter();
    }

    public static void testFilter() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = col.stream();
        stream.filter(t -> t % 2 == 0).forEach(System.out::println);

        // 获取员工姓名长度大于3的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(name -> name.length() > 6).forEach(System.out::println);
    }

    public static void testLimit() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.stream().limit(3).forEach(System.out::println);
    }

    public static void testSkip() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.stream().skip(2).forEach(System.out::println);
    }

    public static void testDistinct() {
        int[] arr = new int[]{1, 2, 3, 4, 4, 2, 5};
        IntStream st = Arrays.stream(arr);
        st.distinct().forEach(System.out::println);
    }

    public static void testMap() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    public static void testFlatMap() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");

        System.out.println("****** 使用map ********");

        Stream<Stream<Character>> streamStream = list.stream().map(StreamApiIntermediateOperation::fromStringToStream);
        streamStream.forEach(stream -> stream.forEach(System.out::println));

        System.out.println("**** 使用flatMap *****");

        Stream<Character> characterStream = list.stream().flatMap(StreamApiIntermediateOperation::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }

        return list.stream();
    }

    public static void testFlatMap2() {
        List<String> lists1 = Arrays.asList("1", "2", "33", "4", "5");
        List<String> lists2 = Arrays.asList("6", "7", "8", "9", "10");
        List<List<String>> listsOfStrings = new ArrayList<>();
        listsOfStrings.add(lists1);
        listsOfStrings.add(lists2);

        System.out.println("listsOfStrings: " + listsOfStrings);

        System.out.println("****** 使用map ********");
        Stream<List<Integer>> listStream = listsOfStrings.stream().map(nums -> nums.stream().map(Integer::parseInt).collect(Collectors.toList()));
        listStream.forEach(System.out::println);
        Stream<List<Integer>> listStream2 = listsOfStrings.stream().map(nums -> nums.stream().map(Integer::parseInt).collect(Collectors.toList()));
        OptionalInt max1 = listStream2.map(list -> Collections.max(list)).mapToInt(Integer::intValue).max();
        System.out.println(max1);
        Stream<Stream<Integer>> streamStream = listsOfStrings.stream().map(nums -> nums.stream().map(Integer::parseInt));
        Stream<OptionalInt> optionalIntStream = streamStream.map(stream -> stream.mapToInt(Integer::intValue).max());
        Optional<OptionalInt> max2 = optionalIntStream.max((n1, n2) -> n1.getAsInt() - n2.getAsInt());
        System.out.println(max2);
        System.out.println("**** 使用flatMap *****");
        Stream<Integer> integerStream = listsOfStrings.stream().flatMap(nums -> nums.stream().map(Integer::parseInt).collect(Collectors.toList()).stream());
        System.out.println(integerStream);
        integerStream.forEach(System.out::println);
        Stream<Integer> integerStream2 = listsOfStrings.stream().flatMap(nums -> nums.stream().map(Integer::parseInt).collect(Collectors.toList()).stream());
        OptionalInt max = integerStream2.mapToInt(Integer::intValue).max();
        System.out.println(max);
    }

    public static void testIntermediateOperationChain() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        list1.addAll(list2.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 10)
                .collect(Collectors.toList()));

        long count = list2.stream().filter(e -> e % 2 == 0).count();
        System.out.println(count);
        System.out.println(list1);
    }

    public static void testSorted() {
        List<Integer> list = Arrays.asList(87, 2, 65, 34, 72, 12);
        list.stream().sorted().forEach(System.out::println);

        System.out.println("\n***********\n");

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);

        System.out.println("\n********* equals ***************\n");
        Stream<Employee> stream = employees.stream();
        Stream<Employee> sorted = stream.sorted(Comparator.comparingInt(Employee::getAge));
        sorted.forEach(System.out::println);
    }
}
