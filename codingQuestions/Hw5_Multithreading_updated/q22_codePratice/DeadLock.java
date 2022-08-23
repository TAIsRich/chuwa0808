package Hw5_Multithreading_updated.q22_codePratice;

public class DeadLock {

    public static void main(String[] args) throws InterruptedException {

        Thread[] ts = new Thread[] {
                new Thread(() -> {
                    while(true) {
                        Counter.add(2);
                    }
                }),
                new Thread(() -> {
                    while(true) {
                        Counter.dec(2);
                    }
                }),
        };

        for (Thread t : ts) {
            t.start();
        }

        for (Thread t : ts) {
            t.join();
        }

        System.out.println("main end");
    }
}
