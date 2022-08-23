package hw5.multithreading;

public class JoinTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Thread start");
            try {
                Thread.sleep(2000); // question, who sleep?
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread end");
        });

        System.out.println("Main start");
        t.start();
        try {
            System.out.println("Main thread is stopped and waiting for t thread end");
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main stop");
    }
}