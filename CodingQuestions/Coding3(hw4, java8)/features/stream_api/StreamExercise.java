import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercise {
    public static void main(String[] args) {
        // testMapAndFlatMap();
        testMapAndFlatMap2();
    }
    public static void testMapAndFlatMap() {
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");

        List<String> l = words.stream()
        .flatMap(s -> Arrays.stream(s.split("")))
        .collect(Collectors.toList());
        System.out.println(l);
    }
    public static void testMapAndFlatMap2() {
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");
        
        List<Stream<String>> collect = words.stream()
                .map(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());
        collect.forEach(e -> System.out.println(e));
    }
}
