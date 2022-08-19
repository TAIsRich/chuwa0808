package myTest;

import java.util.*;

public class LinkedListExerciseTest {
    public static void main(String[] args) {
        learn_Inserting_And_Retrieving();
        learn_Remove_Sort();
    }
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
    //@Test
    public static void learn_Inserting_And_Retrieving() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.addFirst("b");
        list.add(3,"c");
        System.out.println(list);
        LinkedList<String> newList = new LinkedList<String>();
        newList.addAll(list);
        System.out.println(newList);
        newList.addAll(1,list);
        System.out.println(newList);

        System.out.println(list.get(1));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

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

    //@Test
    public static void learn_Remove_Sort() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("e");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        Collections.sort(list);
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove("d");
        System.out.println(list);
        list.removeLastOccurrence("c");
        System.out.println(list);

    }
}
