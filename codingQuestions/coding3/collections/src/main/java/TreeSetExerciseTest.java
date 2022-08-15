import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set= new TreeSet<>();

        set.add(1);
        set.addAll(new HashSet<>());

        boolean a = set.contains(1);

        int c = set.first();
        int b = set.last();
        Set<Integer> subSet = set.subSet(0, 1);
        Set<Integer> headSet = set.headSet(1);
        Set<Integer> tailSet = set.tailSet(1);

        set.remove(1);

        int size = set.size();
        boolean f = set.isEmpty();
    }
}
