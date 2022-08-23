package hw5.multithreading;

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[] {
                new Thread(() -> {
                    while(true) {
                        Count.add(2);
                    }
                }),
                new Thread(() -> {
                    while(true) {
                        Count.dec(2);
                    }
                }),
        };
        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            t.join();
        }

        System.out.println("main end");
    }
}


class Count {
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
