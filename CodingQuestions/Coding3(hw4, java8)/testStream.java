import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class testStream {
     public static void main(String[] args) {
        Stream<Integer> streamIterated = 
        Stream.iterate(40,n->n+2).limit(20);
        // .forEach(System.out::println);
        Integer [] arr = streamIterated.toArray(Integer[]::new);

        List<Integer> list = Arrays.asList(1,2,3,4);
        Stream<Integer> s = list.stream();
        // s.forEach(System.out::println);

        list.stream().filter(x->{System.out.println(x.getClass());return x%2 == 0;}).forEach(System.out::println);

    }
    
}
