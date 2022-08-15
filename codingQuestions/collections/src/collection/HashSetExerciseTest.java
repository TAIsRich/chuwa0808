package collection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhiyu Li
 * @date 08/14/22 9:00 PM
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
        Set<Integer> set= new HashSet<>();
        set.add(1);
        set.add(2);

        set.addAll(new HashSet<>());

        set.contains(1);
        set.remove(2);
        set.clear();
        set.isEmpty();
    }
}
