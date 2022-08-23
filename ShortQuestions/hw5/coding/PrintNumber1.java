package org.example.Threads;

public class PrintNumber1 {
    private static int n = 1;

    public static void main(String[] args){
        Thread t1 = new Thread(() -> printNumber());
        Thread t2 = new Thread(() -> printNumber());
        Thread t3 = new Thread(() -> printNumber());

        t1.start();
        t2.start();
        t3.start();
    }

    private static synchronized void printNumber(){
        int count = 10;
        while(count-- > 0){
            System.out.println(Thread.currentThread().getName() + ": " + n++);
            try{
                //Thread.sleep(1000);
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        PrintNumber1.class.notifyAll();
    }
}
