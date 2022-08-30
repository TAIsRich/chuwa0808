public class PrintNumber {
    private static int n = 1;
    public static void main(String[] args) {
        Thread t1 = new Thread(PrintNumber::printNumber);
        t1.setName("Thread-1");
        Thread t2 = new Thread(PrintNumber::printNumber);
        t2.setName("Thread-2");
        Thread t3 = new Thread(PrintNumber::printNumber);
        t3.setName("Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }

    private static synchronized void printNumber() {
        int count = 10;
        while (count-- > 0) {
            System.out.println(Thread.currentThread().getName() + ": " + n++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //PrintNumber.class.notifyAll();
    }
}
