package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThreads {
    static int val = 1;
    static Lock l = new ReentrantLock();
    static Condition con = l.newCondition();

    public static void main(String[] args) {
        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();
        MyRunnable r3 = new MyRunnable();

        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();
    }

   static class MyRunnable implements Runnable{

        public void run() {
            // TODO Auto-generated method stub
            l.lock();
            while(val <= 30){
                
                for(int i = 0;i < 10;i++){
                    System.out.println(Thread.currentThread().getName() + ": " + val++); 
                }
                con.signal();
                try {
                    con.await();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            // l.unlock();
        }
        
    }


}
