package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class ArraysExerciseTest {

    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     *
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.print(numbers[0]);

        numbers[0] = 11;
        System.out.print(numbers[0]);

    }

    /**
     * binarySearch()
     * e.g.
     * Arrays.binarySearch(numbers, 4);
     *
     * sort(array)
     * sort(array, fromIndex, toIndex)
     * e.g.
     * Arrays.sort(numbers);
     *
     * Arrays.parallelSort(numbers);
     */
    @Test
    public void learn_search_and_sort() {

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Arrays.binarySearch(numbers, 5);
        Arrays.sort(numbers);
        Arrays.parallelSort(numbers); //need to review this method
        //reference link: https://www.geeksforgeeks.org/java-8-arrays-parallelsort-method-with-examples/
        //The main advantage of this sorting algorithm is that it uses the concept of multi-threading behind the scenes
        // and this makes it much faster as compared to the normal sorting.
        // From Java 8 onwards it is always recommended to use parallel sorting instead of normal sorting.

    }

    /**
     * copyOf()
     * e.g.
     * Arrays.copyOf(numbers, numbers.length);
     *
     * copyOfRange()
     * e.g.
     * Arrays.copyOfRange(numbers, 0, 5);
     */
    @Test
    public void learn_copy_of_array() {

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] newArray = Arrays.copyOf(numbers, numbers.length);
        int[] newArray2 =Arrays.copyOfRange(numbers, 0, 5);

    }

    /**
     * asList()
     * e.g.
     * List<Integer> list = Arrays.asList(numbers);
     *
     * equals()
     * e.g.
     * Arrays.equals(numbers1, numbers2);
     *
     * fill()
     * e.g.
     * Arrays.fill(numbers, 20);
     *
     */

    @Test
    public void learn_common_operations() {

        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        int[] numbers1 = numbers, numbers2 = new int[]{3,4,6,8}, numbers3 = numbers;

        Arrays.equals(numbers1, numbers2);//false
        Arrays.equals(numbers1, numbers3);//true, both pointing to the same object numbers1

        Arrays.fill(numbers, 20);


    }
}
