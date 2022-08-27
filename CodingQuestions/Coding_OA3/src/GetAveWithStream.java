import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Flora Zhong
 * @description Use Stream API to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
 * @data 8/22/22
 */

public class GetAveWithStream {
    public static void getAve() {
        List<Integer> list = Arrays.asList(20, 3, 78, 9, 6, 53, 73, 99, 24, 32);

        double ave = list.stream()
                .mapToDouble(Integer :: intValue)
                .average()
                .getAsDouble();

        System.out.println("ave of array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]: " + ave);
    }

    public static double getAve1(int[] nums) {
        List<Integer> list = new ArrayList<> ();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        double ave = list.stream()
                .filter(n -> n % 2 == 1)
                .mapToDouble(Integer :: doubleValue)
                .average()
                .getAsDouble();

        return ave;
    }
    public static double getAve2(int[] nums) {
        Integer[] ints = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ints[i] = nums[i];
        }

        List<Integer> list = Arrays.asList(ints);
        double ave = list.stream()
                .filter(n -> n % 2 == 0)
                .mapToDouble(Integer :: doubleValue)
                .average()
                .getAsDouble();

        return ave;
    }

    public static void main(String[] args) {
        getAve();

        int[] nums = new int[] {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};
        System.out.println("ave of odds in array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]: " +  getAve1(nums));
        System.out.println("ave of evens in array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]: " +  getAve2(nums));
    }
}
