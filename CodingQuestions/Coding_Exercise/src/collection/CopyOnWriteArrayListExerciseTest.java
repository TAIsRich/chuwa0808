package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Flora Zhong
 * @descrittion As the name indicates, CopyOnWriteArrayList creates a cloned copy of an underlying ArrayList.
 *              For every update operation at a certain point, both will be synchronized automatically, which is taken care of by JVM. Therefore, there is no effect for threads that are performing read operation (no update).
 *              It is costly to use because a cloned copy will be created for every update operation. Hence, CopyOnWriteArrayList is the best choice if the frequent operation is read operation (no update).
 * @date 8/14/22
 */

public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList();
     * List<Integer> list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList ();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(0, 7);
        System.out.println("the original copy on write array list: " + list);

        List<Integer> subList = new ArrayList<Integer> () {{add(8); add(9); add(10);}};
        list.addAll(subList);
        System.out.println("the current copy on write array list after addAll(subList): " + list);

        list.addIfAbsent(16);
        list.addIfAbsent(10);
        System.out.println("the current copy on write array list after addIfAbsent(16) and addIfAbsent(10): " + list);

        list.addAllAbsent(subList);
        list.addAllAbsent(new ArrayList<Integer> () {{add(29); add(30); add(31);}});
        System.out.println("the current copy on write array list after addAllAbsent(subList) and addAllAbsent(new " + "ArrayList<Integer> () {{add(29); add(30); add(31);}}): " + list);

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
        while (itr.hasNext()) {
            if (itr.next().equals("Banana")) {
                // remove is not supported by this iterator, always throws UnsupportedOperationException
                itr.remove();
            }
        }
        System.out.println(list);
    }
}
