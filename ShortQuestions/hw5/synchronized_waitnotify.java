public class synchronized_waitnotify {
    private static final Object lock = new Object();
    private static int num = 1;

    public static void main(String[] args) {
        print print = new print();
        new Thread(print).start();
        new Thread(print).start();

    }

    static class print implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                while (num < 11) {
                    System.out.println(Thread.currentThread().getName() + ": " + num++);
                    lock.notify();

                    try {
                        if (num < 11) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
