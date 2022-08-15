import org.junit.Test;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */


public class ArrayListExerciseTest {
    ArrayList<Integer> list = new ArrayList<>();
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        list.addAll(Arrays.asList(1, 3, 4, 5, 2, 5, 2, 7, 3, 9));
        int a = list.get(0);
        int size = list.size();
        list.addAll(new ArrayList<Integer>(3));
        list.clear();
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        list.addAll(Arrays.asList(1, 3, 4, 5, 2, 5, 2, 7, 3, 9));
        list.remove(3);
        list.remove(new Integer(2));
        list.removeAll(Arrays.asList(1, 8));
        list.clear();
        list.set(2, 4);
       // list.replaceAll(new UnaryOperatorn<Integer>());
        list.contains(2);
        int index = list.indexOf(3);
        int index2 = list.lastIndexOf(2);
        list.clear();
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        list.addAll(Arrays.asList(1, 3, 4, 5, 2, 5, 2, 7, 3, 9));
        list.remove(new Integer(2));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        list.iterator().forEachRemaining(f -> System.out.println(f));
        list.clear();
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        list.addAll(Arrays.asList(1, 3, 4, 5, 2, 5, 2, 7, 3, 9));
        list.sort(Comparator.naturalOrder());
        list.sort(Comparator.reverseOrder());
        Collections.sort(list);
        list.clear();
    }
}
