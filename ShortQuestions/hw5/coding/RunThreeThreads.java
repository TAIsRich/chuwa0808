package org.example.Threads;

public class RunThreeThreads {
    private static final Object lock = new Object();

    private static int count = 1;

    public static void main(String[] args){
        Thread t1 = new Thread(new threeThreads());
        Thread t2 = new Thread(new threeThreads());
        Thread t3 = new Thread(new threeThreads());

        t1.start();
        t2.start();
        t3.start();
    }

    static class threeThreads implements Runnable{
        @Override
        public void run() {
            int n = 0;
            while(n++ < 10){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + " " + count++);

                }
            }
        }
    }
}
