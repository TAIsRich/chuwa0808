package multithreading.praticalExercises;

/**
 * @author Flora Zhong
 * @date 8/19/22
 */
public class ThreeThreads {
    private static int k = 1;

    private static synchronized void printNumber() {
        int count = 10;
        while (count-- > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + k++);

            try {
                // 这里不需if (count > 0)这个check, 最后ThreeThreads.class.notifyAll()后会结束这个method、解锁
                // if (count > 0) {
                    Thread.sleep(1000);
                // }
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        ThreeThreads.class.notifyAll();
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printNumber());
        Thread t2 = new Thread(() -> printNumber());
        Thread t3 = new Thread(() -> printNumber());
        t1.start();
        t2.start();
        t3.start();
    }
}
