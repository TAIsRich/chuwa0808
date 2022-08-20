package hw5.practice;

public class threeThreads {
    private static int val = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> printNumber());
        Thread t2 = new Thread(() -> printNumber());
        Thread t3 = new Thread(() -> printNumber());

        t1.start();
        t2.start();
        t3.start();
    }

    private static synchronized void printNumber(){
        int count = 0;
        while(count < 10){
            System.out.println(Thread.currentThread().getName() + ": " + val++);
            count++;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        threeThreads.class.notifyAll();

    }




}
