package ThreadHW;

import java.util.concurrent.locks.*;

public class Q23b {
    private static int value = 1;
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
    static class PrintRunnable implements Runnable {

        @Override
        public void run() {
            try {
                lock.lock();
                while (value <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + value++);
                    condition.signal();
                    try {
                            condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }

        }
    }
}
