package collection;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Flora Zhong
 * @date 8/14/22
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
     */
    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(6);
        set.addAll(new ArrayList<Integer> (Arrays.asList(1, 2, 3)));
        System.out.println("the original set: " + set);


        if (set.contains(1)) {
            set.remove(2);
        }
        System.out.println("the current set after removing 2: " + set);

        set.clear();
        System.out.println("the current set is empty? " + set.isEmpty());
    }
}
