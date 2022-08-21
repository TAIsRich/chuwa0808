package collection;

import org.junit.Test;
import java.util.*;

/**
 * @author Flora Zhong
 * @date 8/14/22
 */

public class CollectionsExerciseTest {

    /**
     * Collections.min(list)
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */
    @Test
    public void learn_common_collections_operations() {
        List<Integer> list = new ArrayList<> (Arrays.asList(12, 3, 6, 57, 66, 65, 6, 10, 7, 66));
        System.out.println("the original list: " + list);

        int min1 = Collections.min(list);
        int min2 = Collections.min(list, (a, b) -> b.compareTo(a));
        System.out.println("default min: " + min1);
        System.out.println("self-defined min: " + min2);

        int max1 = Collections.max(list);
        int max2 = Collections.max(list, (a, b) -> b.compareTo(a));
        System.out.println("default max: " + max1);
        System.out.println("self-defined max: " + max2);

        int target = 66;
        // Integer target = 66;
        int freq = Collections.frequency(list, target);
        System.out.format("the element %d occurs %d times", target, freq);
    }

    /**
     * synchronizedList()
     */
    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = new ArrayList<> (Arrays.asList(12, 3, 6, 57, 66, 65, 6, 10, 7, 66));
        List<Integer> syncList = Collections.synchronizedList(list);
        System.out.println("the original list: " + list);
        System.out.println("the synchronized list: " + syncList);

        list.set(2, 66);
        System.out.println("the original list after list.set(2, 66) : " + list);
        System.out.println("the synchronized list after list.set(2, 66): " + syncList);
        System.out.println("the synchronized list is same with the original list after list.set(2, 66)? " + list.equals(syncList));
    }
}
