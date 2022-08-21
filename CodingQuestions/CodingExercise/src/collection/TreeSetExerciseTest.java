package collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Flora Zhong
 * @date 8/14/22
 */

public class TreeSetExerciseTest {
    /**
     * e.g.
     * TreeSet<Integer> set= new TreeSet<>();
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
     */
    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.addAll(Arrays.asList(16, 12, 5, 7, 2, 19));
        System.out.println("the original set: " + set);

        System.out.println(set.contains(16));

        System.out.format("the first element is %d\n", set.first());
        System.out.format("the last element is %d\n", set.last());

        // required type: TreeSet<Integer>, provided type: SortedSet <Integer>
        TreeSet<Integer> subSet = (TreeSet<Integer>) set.subSet(7, 12);
        System.out.println("the subset from element 7 to 10: " + subSet);

        subSet = (TreeSet<Integer>) set.headSet(19);
        System.out.println("the subset from head to 16: " + subSet);

        subSet = (TreeSet<Integer>) set.tailSet(5);
        System.out.println("the subset from element 7 to tail: " + subSet);

        set.remove(Integer.valueOf(2));

        if (!set.isEmpty()) {
            // %d does not work: s holds place for set.size() + "\nthe current set: " + set but not set.size() only
            System.out.format("the size of current set is %s", set.size() + "\nthe current set: " + set);
        }

        // %d: number placeholder %0nd means zero-padded number with a length
        // %xnd: number placeholder with x-padded in length n
        // %s: string placeholder
        System.out.format("\n%03d%s", 1, "apple");
    }
}
