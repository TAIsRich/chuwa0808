package myTest;

import java.util.*;

public class HashSetExerciseTest {

    public static void main(String[] args) {
        learn_Inserting_And_Retrieving_Removing();
    }
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

    //@Test
    public static void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set= new HashSet<>();
        set.add(1);
        set.add(2);
        System.out.println(set);

        Set<Integer> newSet = new HashSet<>();
        newSet.addAll(set);
        System.out.println(newSet);
        System.out.println(newSet.contains(2));
        newSet.clear();
        System.out.println(newSet);
        System.out.println(newSet.isEmpty());
    }
}
