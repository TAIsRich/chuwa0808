package hw5.practice;

public class twoThreads {

    private static final Object lock1 = new Object();
    private static int v = 1;

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }



    static class PrintRunnable implements Runnable {
        @Override
        public void run() {
            synchronized (lock1){
                while(v <= 10){
                    System.out.println(Thread.currentThread().getName() + ": " + v);
                    v++;
                    lock1.notify();

                    try{
                        lock1.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
    }
}

}
