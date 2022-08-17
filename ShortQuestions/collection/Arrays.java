package collection;

public class Arrays {
    public static void main(String[] args) {
        int[] arr = { 5, -2, 23, 7, 87, -42, 509 };
        System.out.println("The original array is: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        Arrays.sort(arr);
        System.out.println("\nThe sorted array is: ");
        for (int num : arr) {
            System.out.print(num + " ");
    }

        int[] arr1 = new int [] {1, 2, 3, 4};
        int[] arr2 = new int [] {1, 2, 3, 4};
        int[] arr3 = new int [] {1, 2, 4, 3};

        System.out.println("is arr1 equals to arr2 : " +
                Arrays.equals(arr1, arr2));
        System.out.println("is arr1 equals to arr3 : " +
                Arrays.equals(arr1, arr3));
}

    private static String equals(int[] arr1, int[] arr2) {

        return null;
    }


    private static void sort(int[] arr) {

    }


}
