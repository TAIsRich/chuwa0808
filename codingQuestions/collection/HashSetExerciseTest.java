package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
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
        set.add(1);

        //List<Integer> list = Arrays.asList(1,2,3,4,5);
        set.addAll(Arrays.asList(1,2,3,4,5));

        //HashSet has no get() method
        set.contains(3);

        set.remove(4);
        set.clear();

        boolean check = set.isEmpty();

    }
}
