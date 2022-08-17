package collection;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Zhiyu Li
 * @date 08/14/22 9:00 PM
 */
public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        List<Integer> list = ArrayListExerciseTest.createList();
        int min = Collections.min(list);
        Collections.min(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);
        System.out.format("the min is %d\n", min);
        int max = Collections.max(list);
        Collections.max(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.format("the max is %d\n", max);
        Integer searchVal = 4;
        int count  = Collections.frequency(list, searchVal);
        System.out.println(count);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = ArrayListExerciseTest.createList();
        System.out.println(list);
        List<Integer> synList = Collections.synchronizedList(list);
        System.out.println(synList);
    }
}
