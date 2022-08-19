import java.util.*;
import java.util.stream.*;

public class Practice {

    public static void main(String[] args){

        //Stream examples && Stream Structure
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            list.add(i);
        }

        //case 1: filter for even numbers and output to an array
        Stream<Integer> stream = list.stream();
        Integer[] evenNumArray = stream
                .filter(i -> i%2 == 0)
                .toArray(Integer[]::new);

        System.out.print(evenNumArray);


        //case 1.1: output to a list
        Stream<Integer> stream2 = list.stream();
        List<Integer> evenNumList = stream2
                .filter(i -> i%2 == 0)
                .collect(Collectors.toList());

        System.out.print(evenNumList);

        //Empty stream - need to double check its purpose
        Stream<Integer> streamEmpty = Stream.empty();

        //Stream of collection
        Collection<String> collection = Arrays.asList("a","b","c");
        Stream<String> streamOfCollection = collection.stream();

        //Stream of Array
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1,3);

        //Stream.builder()
        /*when builder is used, the desired type should be additionally specified in the
        right part of the stmt, otherwise the builder() method will create an instance of the Stream<Object>
        */

        //<String> is specified

        Stream<String> streamBuilder = Stream.<String>builder()
                .add("a")
                .add("b")
                .add("c")
                .add("d")
                .build(); // need review

        //Stream.generate()
        /*The generate() method accepts a Supplier<T> for element generation.
        As the resulting stream is infinite, the developer should **specify the desired size**,
        or the generate() method **will work until it reaches the memory limit
        */

        Stream<String> streamGenerated = Stream.generate(() -> "ele").limit(10);


        //Stream.iterate()
        /*The first element of the resulting stream is the first parameter of the iterate() method.
        When creating every following element, the specified function is applied to the previous element.
        In the example below the second element will be 42.
        */

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n+2).limit(20);

        //Stream of Primitives
        /*Since Stream<T> is a generic interface,
        and there is no way to use primitives as a type parameter with generics,
        however, Java 8 provide **IntStream, LongStream, DoubleStream** to create streams out of primitive types.
         */

        IntStream intStream = IntStream.range(1,3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);

        //Referencing a Stream
        Stream<String> stream3 = Stream.of("a", "b", "c")
                .filter(ele -> ele.contains("b"));

        Optional<String> anyEle = stream3.findAny();// success since stream object can be used only once.
        Optional<String> firstEle = stream3.findFirst();// failed, throw IllegalStateException. since it cannot be reused

        /*
        As the IllegalStateException is a RuntimeException, a compiler will not signalize about a problem.
        So it is very important to remember that **Java 8 streams can't be reused.**
        If we want to reuse it, we need convert it to collections, then use collection to create stream, then use it.
         */

        List<String> elements = Stream.of("a", "b", "c")
                .filter(ele -> ele.contains("b"))
                .collect(Collectors.toList());

        Optional<String> anyEle2 = elements.stream().findAny();
        Optional<String> firstEle2 = elements.stream().findFirst();

        //Stream: intermediate operations
        /*
        Stream.filter();
        Stream.map();
        Stream.sorted();
        */

        //Stream: termination operations
        /*
        Stream.forEach();
        Stream.collect();
        Stream.match();
        Stream.count();
        Stream.reduce();
        */

        //Stream Collectors
        //Collectors.toList();
        List<Integer> evenNumbersList = stream.filter(i -> i%2 == 0)
                .collect(Collectors.toList());
        //toArray(Integer[]::new)
        Integer[] evenNumbersArr = stream.filter(i -> i%2 == 0).toArray(Integer[]::new);
        //more collectors: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html

        /*
        * Stream is usually performed on all elements inside a collection.
* In some cases, we want to stop the operation when we get what we want instead of processing all elements
    * Stream.anyMatch()
                * `boolean matched = memberNames.stream()
                .anyMatch((s) -> s.startsWith("A"));`
        * return true when it finds fist name starting with 'A' and stop performing the rest of elements
                * Stream.findFirst()
                * String firstMatchedName = memberNames.stream()
                .filter((s) -> s.startsWith("L"))
                .findFirst()
                .get();
        * return the firstMatchedName and stop performing on the rest of elements

         */

        //Parallel Streams
        /*In any of the above-listed stream examples,
        anytime we want to do a particular job using multiple threads in parallel cores,
        all we have to call parallelStream() method instead of stream() method.
         */

        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list2.add(i);
        }

        //creat a parallel stream
        Stream<Integer> stream4 = list.parallelStream();
        Integer[] evenNumArr2 = stream4
                .filter(i -> i % 2 == 0)
                .toArray(Integer[] :: new);

        System.out.print(evenNumArr2);














    }
}
