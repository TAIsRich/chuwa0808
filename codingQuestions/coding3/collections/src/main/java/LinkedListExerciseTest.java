import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class LinkedListExerciseTest {
    LinkedList<Integer> list = new LinkedList<>();
    /**
     * e.g.
     * List<Integer> list = new LinkedList<Integer>();
     * Inserting:
     * add(E e) or addLast(E e)
     * addFirst(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addAll(int index, Collection c)
     *
     * Retrieving:
     * getFirst()
     * getLast()
     * get(int index)
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        list.add(3);
        list.add(4);
        list.addFirst(5);
        list.addLast(5);
        list.add(3, 5);
        list.addAll(new HashSet<>());
        int a = list.getFirst();
        int b = list.getLast();
        int c = list.get(3);
    }

    /**
     * removeFirst()
     * removeLast()
     * remove(int index)
     * remove(Object o)
     * removeLastOccurrence()
     *
     * sort()
     */

    @Test
    public void learn_Remove_Sort() {
        list.add(3);
        list.add(4);
        list.addFirst(5);
        list.addLast(5);
        list.add(3, 5);
        int a = list.removeFirst();
        int b = list.removeLast();
        int c = list.remove(3);
        list.remove(new Integer(3));
        list.removeLastOccurrence(new Integer(3));
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 01 - 02;
            }
        });
    }
}
