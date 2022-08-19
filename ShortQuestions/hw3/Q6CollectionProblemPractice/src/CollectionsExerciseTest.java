import org.junit.Test;

import java.util.ArrayList;
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
        Collections.min(new ArrayList<Integer>()); //minimum element of the given collection
        Collections.min(new ArrayList<Integer>(), Comparator.reverseOrder());

        Collections.max(new ArrayList<Integer>());
        Collections.max(new ArrayList<Integer>(), Comparator.reverseOrder());

        Collections.frequency(new ArrayList<>(), 1);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        Collections.synchronizedList(new ArrayList<>());
        // A synchronized list means a thread won't be able to modify the list
        // while another thread is currently running a method from this list.
        // The object is locked while processing method.
    }
}
