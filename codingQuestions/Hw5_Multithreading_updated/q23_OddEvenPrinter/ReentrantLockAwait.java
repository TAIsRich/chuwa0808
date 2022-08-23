package Hw5_Multithreading_updated.q23_OddEvenPrinter;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockAwait {

    private static int value = 1;

    public static void main(String[] args){
        WaitNotify.PrintRunnable runnable = new WaitNotify.PrintRunnable();
        new Thread(runnable).start();//create new thread through runnable
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable{

        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();

        @Override
        public void run(){
            lock.lock();
            try{
                while(value <= 10){
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    condition.signal();
                    try{
                        condition.await();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            } finally{
                lock.unlock();
            }
        }
    }


}
