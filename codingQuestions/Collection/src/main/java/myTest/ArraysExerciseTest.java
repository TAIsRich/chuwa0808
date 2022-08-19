package myTest;

import java.util.*;

public class ArraysExerciseTest {
    public static void main(String[] args) {
        learn_Inserting_And_Retrieving();
        learn_search_and_sort();
        learn_copy_of_array();
    }
    /**
     * e.g.
     * int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
     * numbers[?]
     *
     * numbers[?] = #
     */

    //@Test
    public static void learn_Inserting_And_Retrieving() {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        numbers[0] = 0;
        System.out.println(numbers[0]);
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
    //@Test
    public static void learn_search_and_sort() {
        int[] numbers = { 1, 2, 3, 5, 4, 6, 7, 8, 9, 10 };
        System.out.println(Arrays.binarySearch(numbers, 1));
        Arrays.sort(numbers);
        for(int n : numbers) System.out.println(n);
        Arrays.parallelSort(numbers);
        for(int n : numbers) System.out.println(n);

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
    //@Test
    public static void learn_copy_of_array() {
        int[] numbers = { 1, 2, 3, 5, 4, 6, 7, 8, 9, 10 };
        int[] test = Arrays.copyOf(numbers, numbers.length);
        for(int n : test) System.out.println(n);
        test = Arrays.copyOfRange(numbers, 0, 5);
        for(int n : test) System.out.println(n);
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

    //@Test
    public static void learn_common_operations() {
        Integer[] numbers = new Integer []{ 1, 2, 3, 5, 4, 6, 7, 8, 9, 10 };
        List<Integer> list = Arrays.asList(numbers);
        System.out.println(list);
        Integer[] numbers2 = new Integer []{ 1, 2, 3, 5, 4, 6, 7, 8, 9, 10 };
        System.out.println(Arrays.equals(numbers, numbers2));
        Arrays.fill(numbers, 20);
        for(int i:numbers) System.out.print(i);
    }
}
