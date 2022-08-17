package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        //* add(E e)
        list.add(1);
        //* add(int index, E element)
        list.add(0,2);
        //* addAll(Collection c)
        List<Integer> newList = new ArrayList<>();
        list.addAll(newList);
        //* addIfAbsent(E e)
        list.addIfAbsent(3);
        //* addAllAbsent(Collection c)
        list.addAllAbsent(newList);
        //The addAllAbsent (E e) method of CopyOnWriteArrayList appends all of the
        // elements in the specified collection that are not already contained in this list,
        // to the end of this list, in the order that they are returned by the specified collection’s iterator.

    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();
        itr.hasNext();
        itr.next();
        itr.remove();
    }
}
