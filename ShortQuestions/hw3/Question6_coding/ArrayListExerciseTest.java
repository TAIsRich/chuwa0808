package org.example;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        System.out.println("learn_Inserting_And_Retrieving");
        ArrayList<Integer> list1 = new ArrayList<Integer>();    //create new arraylist
        ArrayList<Integer> list2 = new ArrayList<Integer>();    //create another arraylist
        list1.add(333);     // add elements
        list1.add(666);
        list1.add(999);
        System.out.println(list1.get(0));   //get item base on index
        System.out.println(list1.get(1));   //get item base on index
        System.out.println(list1.get(2));   //get item base on index

        System.out.println(list1.size());   //get size
        list2.addAll(list1);

        Assertions.assertEquals(list1.get(2),list2.get(2));
        //System.out.println("compare two list is the same");
    }

    /**
     * remove(int index)    //
     * remove(Object o)     //
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
        System.out.println("learn_Remove_Replacing_Updating");
        ArrayList<String> list1 = new ArrayList<String>();    //create new arraylist
        ArrayList<String> list2 = new ArrayList<String>();    //create another arraylist
        list1.add("hello");
        list1.add("world");
        list1.add("there");
        list1.add("is");
        list1.add("a");
        list1.add("beautiful");
        list1.add("butterfly");

        list1.remove(1);        //remove world
        System.out.println(list1.toString());
        list1.remove("hello");      //remove hello
        System.out.println(list1.toString());


        list2.add("there");
        list2.add("is");
        list1.removeAll(list2);
        System.out.println(list1.toString());   //remove there is

        list1.clear();
        System.out.println(list1.toString());   //remove everything

        list2.set(0, "here");
        System.out.println(list2.toString());   //set element at index

        list2.replaceAll(e -> e.toUpperCase());
        System.out.println(list2.toString());   //relaceAll with UnaryOperator

        System.out.println("contain: " + list2.contains("IS"));   //contain
        System.out.println("indexOf: " + list2.indexOf("IS"));    //indexOf
        System.out.println("lastIndexOf: " + list2.lastIndexOf("IS"));    //lastIndexOf

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
        System.out.println("learn_Iterator");
        ArrayList<String> list1 = new ArrayList<String>();    //create new arraylist
        ArrayList<String> list2 = new ArrayList<String>();    //create another arraylist
        list1.add("hello");
        list1.add("world");

        Iterator<String> iter1 =  list1.iterator();
        if(iter1.hasNext()){ iter1.next(); }
        iter1.remove();

        iter1.forEachRemaining(e -> System.out.println(e));     //since world remove, hello will print

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        System.out.println("learn_Sorting");
        ArrayList<Integer> list1 = new ArrayList<Integer>();    //create new arraylist
        ArrayList<Integer> list2 = new ArrayList<Integer>();    //create another arraylist

        list1.add(2);
        list1.add(6);
        list1.add(5);
        list1.add(9);
        list1.add(1);

        list1.sort(Comparator.naturalOrder());

        Collections.sort(list1);
        System.out.println("sorted " + list1.toString());

        list1.sort(Comparator.naturalOrder());
        Comparator c = Collections.reverseOrder();
        Collections.sort(list1,c);
        System.out.println("reverse order " + list1.toString());

    }
}
