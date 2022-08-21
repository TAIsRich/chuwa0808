package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Flora Zhong
 * @date 8/14/22
 */

public class ArraysExerciseTest {

    /**
     * e.g.
     * int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
     * numbers[?]
     *
     * numbers[?] = #
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int length = numbers.length;
        int num = numbers[6];
        numbers[6] = 97;
        System.out.println("numbers' length: " + length + "\nthe original number at index 6: " + num + "\nthe current number at index 6: " + numbers[6]);
    }

    /**
     * sort(array)
     * sort(array, fromIndex, toIndex)
     * e.g.
     * Arrays.sort(numbers);
     *
     * Arrays.parallelSort(numbers);
     *
     * binarySearch()
     * e.g.
     * Arrays.binarySearch(numbers, 4);
     */
    @Test
    public void learn_search_and_sort() {
        int[] numbers = new int[] {1, 22, 3, 64, 65, 66, 66, 17, 8, 29, 10, 66};
        System.out.println("the original array: " + Arrays.toString(numbers));

        //sorting algorithm used in this method: Dual-Pivot Quicksort
        Arrays.sort(numbers, 3, 9);
        System.out.println("the current array after sorting from index 3 to 8: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("the current array after sorting: " + Arrays.toString(numbers));

        // use parallel merge sorts
        // better performance for the datasets in large size, slower for the datasets in small size
        numbers = new int[] {1, 22, 3, 64, 65, 66, 66, 17, 8, 29, 10};
        Arrays.parallelSort(numbers);
        System.out.println(Arrays.toString(numbers));

        // the original array must be sorted by Arrays.sort() prior to calling Arrays.binarySearch()
        // if the array contains the multiple elements with the specified value, there is no guarantee which one will be found
        int index1 = Arrays.binarySearch(numbers, 66);
        int index2 = Arrays.binarySearch(numbers, 16);
        int index3 = Arrays.binarySearch(numbers, 2);
        System.out.format("66 locates at %d, 10 locates at %d, 2 locates at %d", index1, index2, index3);
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
        int[] numbers = new int[] {1, 22, 3, 64, 65, 66, 66, 17, 8, 29, 10};
        System.out.println("the original array: " + Arrays.toString(numbers));

        int[] copy = Arrays.copyOf(numbers, 7);
        System.out.println("the copy of the original array from index 0 to index 6: " + Arrays.toString(copy));

        copy[0] = 100;
        copy[1] = 101;
        System.out.println("change the copy at index 0 and index 1: " + Arrays.toString(copy));
        System.out.println("does not affect the original array: " + Arrays.toString(numbers));

        numbers[0] = 11;
        numbers[1] = 222;
        System.out.println("change the original array at index 0 and index 1: " + Arrays.toString(numbers));
        System.out.println("does not affect the copy: " + Arrays.toString(copy));

        int[] copyRange = Arrays.copyOfRange(numbers,3,10);
        System.out.println("the copy of the original array from index 3 to index 10: " + Arrays.toString(copyRange));
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
     */
    @Test
    public void learn_common_operations() {
        // int[] numbers = {1, 22, 3, 64, 65, 66, 66, 17, 8, 29, 10}; does not work since the type is int[] but not Integer[]
        // Integer[] numbers = {1, 22, 3, 64, 65, 66, 66, 17, 8, 29, 10};
        Integer[] numbers = new Integer[] {1, 22, 3, 64, 65, 66, 66, 17, 8, 29, 10};

        List<Integer> list = Arrays.asList(numbers);
        System.out.println(list);

        int[] numbers1 = {1, 5, 2, 8, 3, 4, 6, 7, 9, 10};
        int[] numbers2 = new int[] {1, 5, 2, 8, 3, 4, 6, 7, 9, 10};
        System.out.println("numbers1 is same with numbers2? " + Arrays.equals(numbers1, numbers2));

        int[] numbers3 = new int[6];
        Arrays.fill(numbers3, 1);
        System.out.println("fill numbers3 with 1: " + Arrays.toString(numbers3));
    }
}
