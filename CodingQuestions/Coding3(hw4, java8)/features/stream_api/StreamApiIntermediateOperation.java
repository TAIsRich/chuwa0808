import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiIntermediateOperation {

    private static final List<Employee> EMPLOYEES = new ArrayList<Employee>();

    public static void main(String[] args) {
        Employee e1 = new Employee(1001, "tom", 23, 2222);
        Employee e2 = new Employee(1002, "Jerry", 18, 5000);
        Employee e3 = new Employee(1003, "Tony", 20, 1000);
        Employee e4 = new Employee(1004, "Liam", 18, 4000);
        EMPLOYEES.add(e1);
        EMPLOYEES.add(e2);
        EMPLOYEES.add(e3);
        EMPLOYEES.add(e4);
        // testFilter();
        // test_Limit_Skip();
        // testFlatMap();
        // testFlatMap2();
        // testIntermediateOperationChain();
        testSorted();
    }
    public static void testFilter() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = col.stream();
        // stream.filter(t -> t % 2 == 0).forEach(System.out::println);

        Stream<Integer> is = EMPLOYEES.stream().map(e->e.age);
        is.filter(e->e>20).forEach(System.out::println);
    }

    public static void test_Limit_Skip() {
        List<Integer> s = Arrays.asList(1,2,3,3,3,4,4,5);
        // s.stream().limit(3).forEach(System.out::println);

        // s.stream().skip(2).forEach(System.out::println);

        // s.stream().distinct().forEach(System.out::println);

        List<String> s1 = Arrays.asList("aa","nn");
        s1.stream().map(String::toUpperCase).forEach(System.out::println);




    }

    public static void testFlatMap() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");

        Stream<Stream<Character>> s = list.stream().map(StreamApiIntermediateOperation::fromStringToStream);
        // s.forEach(s1 -> s1.forEach(System.out::println));
        // System.out.println("test");

        Stream<Character> s1 = list.stream().flatMap(StreamApiIntermediateOperation::fromStringToStream);
        s1.forEach(System.out::println);

    }

    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for(Character x : str.toCharArray()){
            list.add(x);
        }
        // char [] c= str.toCharArray();
        return list.stream();

    }

    public static void testFlatMap2() {
        List<String> list1 = Arrays.asList("1","2","3","4");
        List<String> list2 = Arrays.asList("5","6","7","8");

        List<List<String>> list = new ArrayList<>(Arrays.asList(list1,list2));

        // Integer sum = 
        Optional<Integer> num = list.stream().flatMap(nums -> nums.stream().map(Integer::parseInt)).reduce((a,b)->a+b );
        // .forEach(System.out::println);
        System.out.println(num.get());

        


    }
    public static void testIntermediateOperationChain() {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(4,5,6));

        // list1.addAll(list2);

        list1.addAll(list2.stream().filter(e -> e%2 == 0).collect(Collectors.toList()));
        System.out.println(list1);

    }

    public static void testSorted() {
        List<Integer> l = Arrays.asList(1,2,3,9,4,7);
        // l.stream().sorted((a,b)->b-a).forEach(System.out::println);

        EMPLOYEES.stream().sorted((a,b)->a.salary-b.salary).map(e->e.salary).forEach(System.out::println);

    }


}
