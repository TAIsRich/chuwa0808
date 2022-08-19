package Hw5_Multithreading_updated.q22_codePratice;

public class JoinTest {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + "Thread start");
            try {
                System.out.println(Thread.currentThread().getName() + ":" + "Thread before sleep()");
                Thread.sleep(2000); // question, who sleep? The t thread who calls this method
                System.out.println(Thread.currentThread().getName() + ":" + "Thread after sleep()");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread end");
        });

        System.out.println(Thread.currentThread().getName() + ":" + "Main start");
        t.start();
        try {
            System.out.println(Thread.currentThread().getName() + ":" + "Main thread is stopped and waiting for t thread end");
            t.join();   // main thread wait for t thread end. main thread's status is Timed Waiting.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main stop");
    }
}
