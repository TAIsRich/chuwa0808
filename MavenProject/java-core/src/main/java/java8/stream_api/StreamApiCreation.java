package java8.stream_api;


import common.pojos.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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
 * @author bigo
 */

public class StreamApiCreation {

    /**
     * 创建Stream的方式
     * 1. 通过集合
     * 2. 通过数组Arrays
     * 3. 通过Stream的Of()
     * 4. 创建无限流
     * 5. 通过Builder
     * 6. Stream of Primitives
     */

    @Test
    public void testArrays() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(arr);
        System.out.println("stream object: " + stream);

        Employee e1 = new Employee(1001, "tom", 20, 2222);
        Employee e2 = new Employee(1002, "Jerry", 18, 5000);
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
        System.out.println("stream object: " + stream1);
    }

    @Test
    public void testOf() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        System.out.println("Stream object: " + stream);
    }

    @Test
    public void testIterate(){
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);
    }

    @Test
    public void testGenerate() {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(System.out::println);
    }

    @Test
    public void testBuilder() {
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").build();
        System.out.println("Stream Object: " + streamBuilder);
        streamBuilder.forEach(System.out::println);
    }

    @Test
    public void testStreamOfPrimitives() {
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        System.out.println("Stream Object: " + intStream);
        intStream.forEach(System.out::println);

        System.out.println("Stream Object: " + longStream);
        longStream.forEach(System.out::println);
    }

}
