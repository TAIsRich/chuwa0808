public class tripleThread {
    private static int n = 1;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> print());
        Thread t2 = new Thread(() -> print());
        Thread t3 = new Thread(() -> print());

        t1.start();
        t2.start();
        t3.start();
    }

    private static synchronized void print() {
        int count = 10;
        while (count-- > 0){
            System.out.println(Thread.currentThread().getName() + ": " + n++);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        tripleThread.class.notifyAll();
    }
}
