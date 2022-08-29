import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionsExerciseTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);
        int min = Collections.min(list);
        System.out.println(min);
    }
}
