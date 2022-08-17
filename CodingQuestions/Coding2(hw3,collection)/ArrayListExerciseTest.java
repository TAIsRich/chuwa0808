import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListExerciseTest {

    public static void main(String[] args) {
        // learn_Inserting_And_Retrieving();
        // learn_Remove_Replacing_Updating();
        // learn_Iterator();
        // learn_Sorting();
        learn_Inserting_And_Retrieving_CopyOnWriteArrayList();
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
    // @Test
    public static void learn_Inserting_And_Retrieving_CopyOnWriteArrayList() {
        List list = new CopyOnWriteArrayList();
        list.add(1);
        list.add(1,3);
        System.out.println(list);
        List list2 = new CopyOnWriteArrayList();
        list2.addAll(list);
        System.out.println(list2);
        
    }
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    // @Test
    public static void learn_Inserting_And_Retrieving() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(100);
        list1.add(200);
        list1.get(0);
        list1.size();
        List<Integer> list = new ArrayList<>();
        list.addAll(list1);
        System.out.println(list);
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
    // @Test
    public static void learn_Remove_Replacing_Updating() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(100);
        list1.add(200);
        list1.remove(0);
        list1.add(100);
        list1.remove(Integer.valueOf(100));
        System.out.println(list1);
        list1.add(100);
        // list1.removeRange(0,1);
        // System.out.println(list1);

        List<Integer> list = new ArrayList<>();
        list.addAll(list1);
        list1.removeAll(list);

        System.out.println(list);
        // list.clear();
        // System.out.println(list);

        list.set(0, 10000);
        System.out.println(list);

        list.replaceAll((e) -> e+1);
        System.out.println(list);

        boolean x1 = list.contains(Integer.valueOf(101));
        int x2 = list.indexOf(Integer.valueOf(101));
        int x3 = list.lastIndexOf(Integer.valueOf(101));
        System.out.println(x1+ "    "+x2+"   "+x3);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    // @Test
    public static void learn_Iterator() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(100);
        list1.add(200);

        list1.add(300);
        list1.add(400);

        Iterator<Integer> it = list1.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        //     it.remove();
        //     // System.out.println(list1);
        // }

        it.forEachRemaining((e) -> System.out.println(e));
        

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    // @Test
    public static void learn_Sorting() {
        
        List<Integer> list1 = new ArrayList<>();
        list1.add(400);
        list1.add(300);
        list1.add(200);
        list1.add(100);
        
        // list1.sort((a,b)->a-b);
        Collections.sort(list1);
        System.out.println(list1);

        Collections.reverse(list1);
        System.out.println(list1);

        list1.sort(Comparator.reverseOrder());
        System.out.println(list1);

    }
}