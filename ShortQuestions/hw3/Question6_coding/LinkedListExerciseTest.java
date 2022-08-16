package org.example;

import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import java.util.List;

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
        System.out.println("learn_Inserting_And_Retrieving");
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.add(1);
        list1.add(0, 4);
        list1.add(5);

        list2.addAll(list1);
        list2.addAll(0, list1);
        System.out.println("afterAddAll list2 is: " + list2.toString());


        System.out.println("getFirst, should be 4: " + list1.getFirst());
        System.out.println("getLast, should be 5: " + list1.getLast());
        System.out.println("getFirst, should be 1: " + list1.get(1));
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
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        list1.removeFirst();
        list1.removeLast();
        list1.remove(0);
        list1.remove(new Integer(3));
        list1.removeLast();
        System.out.println("should be empty for now " + list1.toString());
    }
}