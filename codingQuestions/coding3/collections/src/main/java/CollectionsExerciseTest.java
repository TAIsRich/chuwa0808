import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
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
        Collections.min(new ArrayList<>());
        Collections.min(new ArrayList<>(), new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        Collections.max(new ArrayList<>(), new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        Collections.frequency(new ArrayList<>(), new Object());
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        Collections.synchronizedList(new ArrayList<>());
    }
}
