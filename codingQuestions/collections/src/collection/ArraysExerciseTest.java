package collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Zhiyu Li
 * @date 08/14/22 9:00 PM
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
        int len = numbers.length;
        System.out.println(numbers[5]);
        numbers[1] = 5;

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
        int[] numbers = { 1, 5, 2, 8, 3, 4, 6, 7, 9, 10 };
        System.out.println(Arrays.toString(numbers));
        int index = Arrays.binarySearch(numbers, 4);

        //The sorting algorithm used in this method is Dual-Pivot Quicksort.
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers, 3, 5);

        //it uses a parallel sort-merge sorting algorithm
        //better performance for large size datasets but Slower for smaller size arrays
        Arrays.parallelSort(numbers);
        System.out.println(Arrays.toString(numbers));

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

        int[] numbers = { 1, 5, 2, 8, 3, 4, 6, 7, 9, 10 };
        System.out.println(Arrays.toString(numbers));
        int[] copy  = Arrays.copyOf(numbers, 12);
        copy[10] = 11;
        copy[11] = 12;
        System.out.println(Arrays.toString(copy));

        int[] copyRan = Arrays.copyOfRange(numbers, 0, 5);
        System.out.println(Arrays.toString(copyRan));

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

        Integer[] numbers = { 1, 5, 2, 8, 3, 4, 6, 7, 9, 10 };
        List<Integer> list = Arrays.asList(numbers);
        System.out.println(list);

        int [] numbers1 = { 1, 5, 2, 8, 3, 4, 6, 7, 9, 10 };
        int[] numbers2 = { 1, 5, 2, 8, 3, 4, 6, 7, 9, 10 };

        if(Arrays.equals(numbers2, numbers1)){
            System.out.println("True");
        }

        int[] arr = new int[5];
        Arrays.fill(arr, 1);
        System.out.println(Arrays.toString(arr));




    }
}
