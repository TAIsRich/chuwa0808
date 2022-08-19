import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
 */
public class  LinkedListExerciseTest {

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
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1); //list.addLast(1);
        list.addFirst(1);
        list.add(1, 1); // insert the element to the index position (rest will shift right)
        list.addAll(new LinkedList<>()); //Appends all of the elements in collection to the end of this list
        list.addAll(1, new LinkedList<>());

        list.getFirst();
        list.getLast();
        list.get(2);
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
        LinkedList<Integer> list = new LinkedList<>();

        list.removeFirst();
        list.removeLast();
        list.remove(1);
        list.remove(new Object());
        list.removeLastOccurrence(1);

        Collections.sort(list);
        list.sort(Comparator.naturalOrder());
    }
}
