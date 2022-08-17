package myTest;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExerciseTest {
    public static void main(String[] args){
        learn_Inserting_And_Retrieving();
        learn_Iterator();
    }

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
    //@Test
    public static void learn_Inserting_And_Retrieving() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("a");
        list.add(1,"b");
        System.out.println(list);
        List<String> newList = new CopyOnWriteArrayList<>();
        newList.addAll(list);
        System.out.println(newList);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    //@Test
    public static void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();
        System.out.println(itr.hasNext() + "," + itr.next() + "," + itr.next());
        //itr.remove();
        //System.out.println(list);
    }
}
