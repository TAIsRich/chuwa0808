package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadTest1 {
    // static final Object LOCK_FOR_TEST1 = new Object();
    static int num1 = 1;
    static Lock lock = new ReentrantLock();
    static Condition con = lock.newCondition();

    public static void main(String[] args) {
        PrintRunnableTask t1 = new PrintRunnableTask();
        PrintRunnableTask t2 = new PrintRunnableTask();

        new Thread(t1).start();
        new Thread(t2).start();
    }

    static class PrintRunnableTask implements Runnable{

        public void run() {
            // TODO Auto-generated method stub
            lock.lock();

            while(num1 <= 10){
                System.out.println(Thread.currentThread().getName() + ": " + num1++);
                con.signal();

                try {
                    con.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        }

    }
}
