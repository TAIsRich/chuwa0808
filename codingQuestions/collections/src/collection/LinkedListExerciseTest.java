package collection;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Zhiyu Li
 * @date 08/14/22 9:00 PM
 */
public class LinkedListExerciseTest {

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
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(2);
        list.addLast(3);
        list.addFirst(1);
        list.add(0, 0);
        list.addAll(new LinkedList<>());
        list.addAll(4, new LinkedList<>());

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

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.removeFirst();
        list.removeLast();
        list.remove(2);
        Integer i = 2;
        list.remove(i);
        list.removeLastOccurrence(2);

        list.sort((a, b) -> (b - a));

    }
}
