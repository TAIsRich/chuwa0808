package myTest;

import java.util.*;

public class TreeSetExerciseTest {

    public static void main(String[] args) {
        learn_Inserting_And_Retrieving_Removing();
    }
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

    //@Test
    public static void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set= new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);
        Set<Integer> newSet= new TreeSet<>(set.subSet(1,3));
        newSet.addAll(set);
        System.out.println(newSet);
        System.out.println(set.contains(1));
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        Set<Integer> newSet2= new TreeSet<>(set.headSet(1));
        System.out.println(newSet2);
        newSet2.addAll(set.tailSet(1));
        System.out.println(newSet2);
    }
}
