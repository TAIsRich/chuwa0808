public class OddEventPrinter {
    private static final Object LOCK = new Object();
    private static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        MyRunnable mr = new MyRunnable();
        new Thread(mr).start();
        new Thread(mr).start();

    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            synchronized(LOCK){
                while(num <= 10){
                    System.out.println(Thread.currentThread().getName() + ": " + num++);
                    LOCK.notify();
                    try {
                        if(num < 11){
                            LOCK.wait();
                        }
                    } catch (Exception e) {
                        //TODO: handle exception
                        e.printStackTrace();
                    }
                    
                }
            }
        }
    }
}

