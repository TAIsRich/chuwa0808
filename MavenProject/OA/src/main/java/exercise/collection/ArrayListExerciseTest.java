package exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.get(0);
        list.size();
        list.addAll(new ArrayList<>());

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
        ArrayList<Integer> list = new ArrayList<>();

        list.remove(0);
        list.remove(new Integer(0));
        //list.removeRange(0, 2);
        list.removeAll(new ArrayList<>());
        list.clear();

        list.set(0, 100);
        //list.replaceAll();

        list.contains(new Integer(100));
        list.indexOf(new Integer(100));
        list.lastIndexOf(new Integer(100));
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
        ArrayList<Integer> list = new ArrayList<>();

        for(Integer obj : list){
            System.out.println(obj);
        }

        list.iterator();
        list.iterator().hasNext();
        list.iterator().next();
        list.iterator().remove();
       // list.iterator().forEachRemaining();
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<Integer> list = new ArrayList<>();

        list.sort(Comparator.naturalOrder());
        Collections.sort(list);
        Comparator.reverseOrder();

    }
}
