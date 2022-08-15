package com.chuwa.exercise.collection;

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
        List<Integer> testList = new ArrayList<>();

        //* add elements
        testList.add(1);
        testList.add(2);

        //* get element
        Integer testCur = testList.get(0);

        //* get Size
        int size = testList.size();

        //* list.addAll(anotherList)
        List<Integer> testList2 = Arrays.asList(3,4,5,6,7);
        testList2.addAll(testList);

        //alternatively
        //testList1.add(new ArrayList<>(3,4,5,6,7);

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

        List<Integer> testList1 = Arrays.asList(0,1,2);
        List<Integer> testList2 = Arrays.asList(3,4,5);
        //* remove(int index)
        testList2.remove(1);
        //* remove(Object o)
        testList2.remove(new Object());

        //* removeRange(int fromIndex, int toIndex)
        //note from reference: removeRange method is protected and can only be used when list extends ArrayList,
        //so this question has no answer
        //testList2.remove(0,2);

        //* removeAll(Collection<?> c)
        testList2.removeAll(new ArrayList<>());

        //* clear()
        testList1.clear();

        //* Update:
        //* set(int index, E e)
        testList2.set(0,8);

        //* replaceAll(UnaryOperator<E> operator)
        Collections.replaceAll(testList2, 3, 7);

        //* check:
        //* contains(Object o)
        boolean check = testList2.contains(new Object());
        //* indexOf(Object o)
        int cur = testList2.indexOf(new Object());
        //* lastIndexOf(Object o)
        int last = testList2.lastIndexOf(new Object());

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

        List<Integer> list = new ArrayList<>();
        //* iterator()
        list.iterator();

        //* hasNext()
        list.iterator().hasNext();

        //* next()
        list.iterator().next();

        //* remove()
        list.iterator().remove();

        //* forEachRemaining(Consumer<? super E> action) -- from Java8
        list.iterator().forEachRemaining(o1 -> System.out.println(o1));

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>();

        // * sort(List<T> list)
        list.sort(Comparator.naturalOrder());
        list.sort(Comparator.reverseOrder());

        //* Collections.sort(List<T> t)
        Collections.sort(list);

        //* Comparator.reverseOrder()
        Comparator.reverseOrder();

    }
}
