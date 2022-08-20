package multithread;

public class MultiThreadTest {
    static final Object LOCK_FOR_TEST = new Object();
    static int num = 1;
    public static void main(String[] args) {
        PrintRunnableTask t1 = new PrintRunnableTask();
        PrintRunnableTask t2 = new PrintRunnableTask();

        new Thread(t1).start();
        new Thread(t2).start();
    }

    static class PrintRunnableTask implements Runnable{

        public void run() {
            // TODO Auto-generated method stub
            synchronized(LOCK_FOR_TEST){
                
                while(num <= 10){
                    System.out.println(Thread.currentThread().getName()+": " + num++);
                    LOCK_FOR_TEST.notify();

                    if(num < 11){
                        try {
                            LOCK_FOR_TEST.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
            
        }

    }
}
