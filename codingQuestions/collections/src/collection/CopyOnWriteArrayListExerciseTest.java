package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Zhiyu Li
 * @date 08/14/22 9:00 PM
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

    /**
     * - As the name indicates, CopyOnWriteArrayList creates a Cloned copy of underlying ArrayList, for every update operation at a certain point both will be synchronized automatically,
     * which is taken care of by JVM. Therefore, there is no effect for threads that are performing read operation.
     * - It is costly to use because for every update operation a cloned copy will be created. Hence, CopyOnWriteArrayList is the best choice if our frequent operation is read operation.
     *
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        list.add(0, 6);
        list.addAll(new ArrayList<>());

        list.addIfAbsent(5);
        list.addAllAbsent(new ArrayList<>());
        System.out.println(list);
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
        System.out.println(list);
        while (itr.hasNext()) {
            if (itr.next().equals("Orange")) {
                //when we tried to remove element after comparison while iterating using Iterator a program fails as compiler throws UnsupportedOperationException
                itr.remove();
            }
        }
        System.out.println(list.toString());
    }
}
