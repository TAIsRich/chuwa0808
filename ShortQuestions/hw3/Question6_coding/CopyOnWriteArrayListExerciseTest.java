package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
        System.out.println("learn_Inserting_And_Retrieving");
        CopyOnWriteArrayList list1 = new CopyOnWriteArrayList();
        LinkedList<Integer> list2 = new LinkedList<>();

        list1.add("A");
        list1.add(55);
        list1.add(2,"hello");
        System.out.println(list1.toString());


        list2.add(33);
        list2.add(66);
        list1.addAll(list2);
        list1.addIfAbsent(75);
        System.out.println(list1.toString());

        list1.addAllAbsent(list2);
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


        while(itr.hasNext()){
            itr.next();
        }

        itr.remove();




    }
}
