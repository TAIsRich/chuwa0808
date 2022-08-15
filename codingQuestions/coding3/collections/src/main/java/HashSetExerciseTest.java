import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();
        set.add(3);
        int[] array = new int[]{2, 4, 5, 6};
        List<Integer> result = new ArrayList<>();
        for (int i : array) {
            Integer integer = i;
            result.add(integer);
        }
        List<Integer> list = new ArrayList<>();
        set.addAll(list);
        set.remove(2);
        set.clear();
        boolean m = set.isEmpty();
    }
}
