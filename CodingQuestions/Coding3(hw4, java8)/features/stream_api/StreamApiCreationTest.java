import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamApiCreationTest {
     /**
     * 创建Stream的方式
     * 1. 通过集合
     * 2. 通过数组Arrays
     * 3. 通过Stream的Of()
     * 4. 创建无限流
     * 5. 通过Builder
     * 6. Stream of Primitives
     */

    

    public static void main(String[] args) {
        // System.out.println("fasdfsdfasfsd");
        // testCollection();
        // testArrays();
        // testOf();
        // testIterate();
        // testGenerate();
        // testBuilder();
        testStreamOfPrimitives();
    }

    public static void testCollection() {
        List<Integer> col = Arrays.asList(1,2,3,4);
        col.forEach(System.out::println);

        // 返回一个顺序流
        Stream<Integer> stream = col.stream();
        System.out.println("Stream object:      " + stream);
        // 返回一个并行流
        Stream<Integer> parallelStream = col.parallelStream();
        System.out.println("Parallel Stream object:     " + parallelStream);
    }

    public static void testArrays() {
        
        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(arr);
        System.out.println("Stream object:      " + stream);


        Employee e1 = new Employee(1001, "tom", 20, 2222);
        Employee e2 = new Employee(1002, "Jerry", 18, 5000);
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
        System.out.println("Stream object:     " + stream1);
    }

    public static void testOf() {
        Stream<Integer> s = Stream.of(1,2,3,4);
        s.forEach(System.out::print);
    }

    public static void testIterate() {
        Stream.iterate(1, t->t+2).limit(10).forEach(System.out::println);
    }

    public static void testGenerate() {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        Stream<String> s = Stream.generate(()->"element").limit(10);
        s.forEach(System.out::println);
    }

    public static void testBuilder() {
        Stream<String> s = Stream.<String>builder().add("a").add("n").add("d").build();
        Stream<Integer> s1 = Stream.<Integer>builder().add(1).add(2).add(3).build();
        s.forEach(System.out::println);
        s1.forEach(System.out::println);
    }

    public static void testStreamOfPrimitives() {
        IntStream is = IntStream.range(1, 4);
        LongStream ls =  LongStream.rangeClosed(1, 4);

        is.forEach(System.out::println);
        ls.forEach(System.out::println);
        
    }


    
}


 class Employee {
    int id;
    String name;
    int age;
    int salary;
    public Employee(int id, String n, int a, int sa){
        this.id = id;
        this.name = n;
        this.age = a;
        this.salary = sa;
    }
 }