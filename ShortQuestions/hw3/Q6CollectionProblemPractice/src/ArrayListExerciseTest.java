import org.junit.Test;

import java.util.*;

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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.get(0); // 1
        list.get(1); // 2
        list.size(); // 3

        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
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
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.remove(0);
        list.remove("2");
        // list.removeRange(0,1);
        // removeRange(int fromIndex, int toIndex) method is protected method in ArrayList.
        // A protected method is accessed in class, subclasses and in a package, but not public.
        // Therefore we need to extend the class to arraylist to use this method
        list.removeAll(list);
        list.clear();

        list.set(0, "1");
        Collections.replaceAll(list,"1", "2"); // replace all "1" to "2"

        list.contains("1");
        list.indexOf("1");
        list.lastIndexOf("1");
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
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        Iterator<String> iter = list.iterator();

        //below two expressions are the same
        while (iter.hasNext())  System.out.println(iter.next());
        iter.forEachRemaining(each_element ->  System.out.println(each_element));

        iter.remove(); //remove the current element
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        list.sort(Comparator.naturalOrder());
        list.sort(Comparator.reverseOrder());
        Collections.sort(list); //natural order
    }
}
