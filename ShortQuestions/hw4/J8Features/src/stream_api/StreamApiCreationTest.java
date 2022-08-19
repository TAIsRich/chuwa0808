package stream_api;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.builder;

public class StreamApiCreationTest {
    public void testCollection(){
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.forEach(System.out::println);

        Stream<Integer> stream = col.stream();
        System.out.println("Stream object: " + stream);

        Stream<Integer> paralleStream = col.parallelStream();
        System.out.println("Parallel Stream object: " + paralleStream);
    }

    public void testArrays() {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001, "tom", 20, 2222);
        Employee e2 = new Employee(1002, "Jerry", 18, 5000);
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
        System.out.println("Stream object: " + stream1);
    }

    public void testOf() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4,5);
        System.out.println("Stream object: " + stream);
    }

    public void testIterate(){
        /**
         * 遍历前10个偶数
         * seed : 0, means t's initial value is 0
         * then t is updated every time
         * limit(10) means that it only produce 10 elements then stop.
         */
        Stream.iterate(0, t -> t+2).limit(10).forEach(System.out::println);
    }

    public void testGenerate() {
        Stream.generate(Math :: random).limit(10).forEach(System.out::println);
        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(System.out::println);
    }

    public void testBuilder(){
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();
        System.out.println("Stream object: " + streamBuilder);
        streamBuilder.forEach(System.out::println);
    }

    public void testStreamOfPrimitives(){
        IntStream intStream = IntStream.range(1,3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        System.out.println("Stream object: " + intStream);
        intStream.forEach(System.out::println);

        System.out.println("Stream object: " + longStream);
        longStream.forEach(System.out::println);
    }
}
