package Hw5_Multithreading_updated.q22_codePratice;

public class Counter { //for deadlock learn

    public static final Object LOCK_A = new Object();
    public static final Object LOCK_B = new Object();
    private static int value = 0;
    private static int another = 0;

    public static void add (int m) {

        synchronized (LOCK_A) {
            value += m;
            synchronized (LOCK_B) {
                another += m;
            }
        }

        System.out.println("value is: " + value + ", another is: " + another);
    }

    public static void dec(int m) {

        synchronized (LOCK_B) {
            another -= m;
            synchronized (LOCK_A) {
                value -= m;
            }
        }

        System.out.println("value is: " + value + ", another is: " + another);
    }
}
