package Hw5_Multithreading_updated.q22_codePratice;

public class God implements Runnable{ //for Daemon test

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("上帝守护你");
        }
    }
}
