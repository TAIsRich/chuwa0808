package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:45 PM
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

        //* e.g.
        LinkedList<Integer> list = new LinkedList<Integer>();

        //Inserting:
        //add(E e) or addLast(E e)
        boolean cur1 = list.add(1);

        //addFirst(E e)
        list.addFirst(0);

        //add(int index, E element)
        list.add(0, 3);

        //addAll(Collection c)
        List<Integer> newList = Arrays.asList(4,5,6);

        //addAll(int index, Collection c)
        list.addAll(1, newList);

        //Retrieving:
        //getFirst()
        int first = list.getFirst();
        //getLast()
        int last = list.getLast();
        //get(int index)
        int cur = list.get(2);

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

        //* removeFirst()
        list.removeFirst();
        //* removeLast()
        list.removeLast();
        //* remove(int index)
        list.remove(1);

        //* remove(Object o)
        list.remove(new Object());
        //* removeLastOccurrence()
        list.removeLastOccurrence(1);
        //* sort()
        list.sort(Comparator.naturalOrder());

    }
}
