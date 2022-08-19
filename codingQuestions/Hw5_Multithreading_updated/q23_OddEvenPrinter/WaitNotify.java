package Hw5_Multithreading_updated.q23_OddEvenPrinter;

public class WaitNotify {
    private static final Object monitor = new Object();
    private static int value = 1;

    public static void main(String[] args){
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();//create new thread through runnable
        new Thread(runnable).start();
    }

    static class PrintRunnable implements Runnable{

        @Override
        public void run(){
            synchronized (monitor){ //monitor as a lock
                while(value <= 10){
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    monitor.notify();
                    try{
                        if(value < 11){
                            monitor.wait();
                        }
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
