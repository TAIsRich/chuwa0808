package collection;

import org.junit.Test;
import java.util.*;

/**
 * @author Flora Zhong
 * @date 8/14/22
 */

public class LinkedListExerciseTest {

    /**
     * e.g.
     * LinkedList<Integer> list = new LinkedList<Integer>();
     *
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
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println("the original linked list: " + list);

        list.add(2);
        list.addLast(6);
        list.addFirst(1);
        list.add(1, 7);
        System.out.println("the current linked list after inserting: " + list);

        list.addAll(new LinkedList<> (Arrays.asList(16, 17)));
        System.out.println("the current linked list after inserting a list: " + list);

        list.addAll(2, new LinkedList<Integer> (Arrays.asList(19, 20)));
        System.out.println("the current linked list after inserting a list at index 2: " + list);

        System.out.println("the element at first: " + list.getFirst());
        System.out.println("the element at last: " + list.getLast());
        System.out.println("the element at index 2: " + list.get(2));
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
        list.add(2);
        list.add(12);
        list.add(22);
        list.add(32);
        list.addLast(6);
        list.addFirst(1);
        list.add(1, 7);
        System.out.println("the original linked list: " + list);

        list.remove();
        list.removeFirst();
        list.removeLast();
        list.remove(1);

        Integer i = 22;
        list.remove(i);
        System.out.println("the current linked list after deleting: " + list);

        list.sort((a, b) -> a - b);
        System.out.println("after sorting in ascending order with sort((a, b) -> a - b): " + list);
        list.sort((a, b) -> b - a);
        System.out.println("after sorting in descending order with sort((a, b) -> b - a): " + list);

        Collections.sort(list);
        System.out.println("after sorting in ascending order with Collections.sort(list): " + list);
        Collections.sort(list, (a, b) -> b - a);
        System.out.println("after sorting in descending order with  Collections.sort(list, (a, b) -> b - a): " + list);
    }
}
