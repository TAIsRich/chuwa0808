import java.util.Arrays;

public class ArrayExercise {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6};
        System.out.println(numbers[0]);
        numbers[0] = 3;
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.binarySearch(numbers, 4));
    }
}
