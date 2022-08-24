package multithreading.praticalExercises;

/**
 * @author Flora Zhong
 * @date 8/19/22
 */
public class TwoThreads1 {
    private static int k = 1;
    private static final Object monitor = new Object();

    public static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (monitor) {
                while (k <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + k++);
                    monitor.notify();

                    try {
                        // 这里没有if (k <= 10)这个check, 最后monitor还会wait, 解不了锁
                        if (k <= 10) {
                            monitor.wait();
                        }
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new PrintRunnable();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
    }
}
