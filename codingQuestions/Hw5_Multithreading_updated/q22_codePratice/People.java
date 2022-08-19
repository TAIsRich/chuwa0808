package Hw5_Multithreading_updated.q22_codePratice;

public class People implements Runnable{//for Daemon test

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ppl live");
        }

        System.out.println("People thread end");
    }
}
