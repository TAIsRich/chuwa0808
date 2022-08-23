package org.example.Threads;

public class ThreadPrintOddEven {

    private static final Object lock = new Object();
    private static int n = 1;

    public static void main(String[] args){
        Thread thread = new Thread(new printThread());
        Thread thread2 = new Thread(new printThread());
        thread.start();
        thread2.start();
    }

    private static class printThread implements Runnable{
        @Override
        public void run() {
            synchronized (lock){
                while(n <= 10){
                    System.out.println(Thread.currentThread().getName() + "  n is " + n++);
                    lock.notify();
                    try{
                        lock.wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
