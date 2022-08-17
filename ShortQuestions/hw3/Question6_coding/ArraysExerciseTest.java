package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
        System.out.println(numbers[2]);
        numbers[2] = 22;
        System.out.println(numbers[2]);
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
        System.out.println("binary search index: " + Arrays.binarySearch(numbers, 5));

        Arrays.sort(numbers);
        Arrays.sort(numbers,0,7);
        Arrays.parallelSort(numbers);

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
        int[] numbers2 = Arrays.copyOf(numbers, numbers.length);
        int[] numbers3 = Arrays.copyOfRange(numbers, 0,7);
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
        int[] numbers = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Integer[] numbers2 = new Integer[] { 10, 20, 30, 40 };
        int[] numbers3 = {1,2,3,4,5};

        List<Integer> list = Arrays.asList(numbers2);

        Arrays.equals(numbers, numbers3);
        Arrays.fill(numbers, 10);
    }
}
