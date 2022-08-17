package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);

        set.add(0);
        set.addAll(list);
        System.out.println("Should be 0 1 2: " + set.toString());

        set.contains(1);
        set.remove(0);
        System.out.println("should be 1 2: " + set.toString());

        set.clear();
        System.out.println("should be true: " + set.isEmpty());
    }
}
