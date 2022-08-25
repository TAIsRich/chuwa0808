package ThreadHW;

public class Q24 {
    private static int value = 0;
    private static final Object monitor = new Object();

    public static void main(String[] args) {
        PrintRunnable runnable = new PrintRunnable();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }
    static class PrintRunnable implements Runnable {

        @Override
        public void run() {
            synchronized (monitor) {
                int i = 1;
                while (i <= 10) {
                    System.out.println(Thread.currentThread().getName() + ": " + (value + i++));
                }
                value += --i;
                monitor.notifyAll();
            }

        }
    }
}
