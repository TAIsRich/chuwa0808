package collection;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Flora Zhong
 * @date 8/14/22
 */

// extends ArrayList<Integer> here is for using removeRange(int fromIndex, int toIndex), which is a protected method of ArrayList<Integer>
public class ArrayListExerciseTest extends ArrayList<Integer> {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        // create and initialize a list with ArrayList
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);

        List<Integer> list2 = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};

        List<Integer> list3 = new ArrayList<>();
        list3.addAll(list1);

        List<Integer> list4 = new ArrayList<>(Arrays.asList(1, 2, 3));


        int idx = 5;
        int ele = list1.get(idx);


        int size = list1.size();

        System.out.format("the original array list is " + list1 + "\nthe new array list is " + list3 + "\nthe index is " + "%d, its element is %d, the size is %d", idx, ele, size);

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
        List<Integer> list = new ArrayList<> (Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println("the original array list: " + list);

        int idx = 2;
        list.remove(2);
        System.out.println("the current array list after remove(idx): " + list);

        Integer ele = 2;
        list.remove(ele);
        System.out.println("the current array list after remove(ele): " + list);

        ArrayListExerciseTest listExerciseTest = new ArrayListExerciseTest();
        listExerciseTest.add(12);
        listExerciseTest.add(13);
        listExerciseTest.add(14);
        listExerciseTest.add(15);
        listExerciseTest.add(16);
        listExerciseTest.add(17);
        System.out.println("the original list exercise test: " + listExerciseTest);

        listExerciseTest.removeRange(1,3);
        System.out.println("the current list exercise test after removeRange(1,3): " + listExerciseTest);

        List<Integer> subList = new ArrayList<Integer> () {{add(1); add(4); add(5); add(6);}};
        list.removeAll(subList);
        System.out.println("the current array list after removeAll(subList): " + list);

        subList.clear();
        System.out.println("the current sublist after clear(): " + subList);

        for (int i = 0; i < 7; i++) {
            list.add(i + 20);
        }
        System.out.println("the original array list: " + list);

        list.set(4, 6);
        System.out.println("the current array list after set(4, 6): " + list);

        list.removeAll(Arrays.asList(22, 23));
        System.out.println("the current array list after removeAll(Arrays.asList(22, 23)): " + list);

        Integer i = 6;
        Integer j = 26;
        if (list.contains(i)) {
            System.out.format("The index of %d is %d, and the last index of %d is %d", i, list.indexOf(i), j, list.lastIndexOf(j));
        }
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
        List<Integer> list = new ArrayList<> (Arrays.asList(1, 2, 3, 4, 5, 6));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            System.out.print(num + " ");

            if (num == 4) {
                // delete current element
                iterator.remove();
            }
        }

        System.out.println();
        list.iterator().forEachRemaining(num -> System.out.println(num));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list1 = new ArrayList<> (Arrays.asList(21, 2, 333, 334, 15, 16, 16));
        System.out.println("the original array list: " + list1);

        list1.sort((a, b) -> a - b);
        System.out.println("after sorting in ascending order with sort((a, b) -> a - b): " + list1);
        list1.sort((a, b) -> b - a);
        System.out.println("after sorting in descending order with sort((a, b) -> b - a): " + list1);

        List<Integer> list2 = new ArrayList<> (Arrays.asList(21, 2, 333, 334, 15, 16, 16));
        System.out.println("the original array list: " + list2);

        Collections.sort(list2);
        System.out.println("after sorting in ascending order with Collections.sort(list): " + list2);
        Collections.sort(list2, (a, b) -> b - a);
        System.out.println("after sorting in descending order with Collections.sort(list, (a, b) -> b - a): " + list2);

        List<Integer> list3 = new ArrayList<> (Arrays.asList(21, 2, 333, 334, 15, 16, 16));
        System.out.println("the original array list: " + list3);

        list3.sort(Comparator.reverseOrder());
        System.out.println("after sorting in descending order with sort(Comparator.reverseOrder()): " + list3);

        List<Integer> list4 = new ArrayList<> (Arrays.asList(21, 2, 333, 334, 15, 16, 16));
        System.out.println("the original array list: " + list4);

        Collections.sort(list4, Comparator.reverseOrder());
        System.out.println("after sorting in descending order with Collections.sort(list4, Comparator.reverseOrder())" + ": " + list4);
    }
}




