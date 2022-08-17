package collection;

import org.junit.Test;

import java.util.*;

/**
 * @author Zhiyu Li
 * @date 08/14/22 9:00 PM
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
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        int index = 0;
        int element = arr.get(index);
        int size = arr.size();
        List<Integer> arr2 = new ArrayList<>();
        arr2.addAll(arr);


        System.out.format("the origin arraylist is " + arr + "\nthe new arraylist is " + arr2  + "\nthe index is %d and its element is %d, the size is %d", index,element,size);

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
        ArrayList<Integer> arr = createList();

        int index = 0;
        Integer indexForRemove = 1;
        System.out.println("the current arraylist: " + arr);
        arr.remove(index);
        arr.remove(indexForRemove);

        //Since feature removeRange needs to be inherited the ArrayList, which is not available in this case, so
        // I use subList and clear for substitute.
        arr.subList(1,2).clear();

        System.out.println("the current arraylist after removed: " + arr);

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(5);

        arr.removeAll(arr2);
        System.out.println("the current arraylist after removeAll: " + arr);

        arr.set(0, 5);
        System.out.println("the current arraylist after set: " + arr);
        arr.removeAll(arr2);

        System.out.println("the current arraylist: " + arr);

        Integer i = 6;
        Integer j = 4;
        if(arr.contains(4)){
            System.out.format("The index of %d is %d, and the last index of  %d is %d",i, arr.indexOf(i), j, arr.lastIndexOf(j));
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
        ArrayList<Integer> arr = createList();
        Iterator<Integer> iterator = arr.iterator();
        System.out.println(arr);
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
            int tmp = iterator.next();

            iterator.remove();

        }

        arr.iterator().forEachRemaining(num -> System.out.println(num + " "));


    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {

        ArrayList<Integer> arr = createList();
        System.out.println(arr);
        arr.sort((a, b) -> (b - a));
        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
        arr.sort(Comparator.reverseOrder());
        System.out.println(arr);
    }

    protected static ArrayList<Integer> createList(){
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(4);
        return arr;
    }
}
