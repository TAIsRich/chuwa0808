package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        set.add(0);
        set.addAll(list);
        System.out.println("set contain 0: " + set.contains(0));
        System.out.println("set first: " + set.first());
        System.out.println("set last: " + set.last());


        System.out.println("subset: " + set.subSet(0,2).toString());
        System.out.println("headSet: " + set.headSet(3).toString());
        System.out.println("tailset: " + set.tailSet(1).toString());

        set.remove(0);
        System.out.println("size: " + set.size());
        System.out.println("empty -> false: " + set.isEmpty());




    }
}
