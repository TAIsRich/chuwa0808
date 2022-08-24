package multithreading.praticalExercises;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Flora Zhong
 * @date 8/19/22
 */
public class TwoThreads2 {
    private static int k = 1;

    public static class PrintRunnable implements Runnable {
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();

        @Override
        public void run() {
            lock.lock();

            try {
                while (k <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + k++);
                    condition.signal();

                    try {
                        // 这里没有if (k <= 10)这个check, 还会condition.await(), 解不了锁
                        if (k <= 10) {
                            condition.await();
                        }
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
}
