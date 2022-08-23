package hw5.multithreading;

public class Daemon {
    public static void main(String[] args) {

        Thread tPpl = new Thread(new People());
        Thread tGod = new Thread(new God());
        Thread tGod2 = new Thread(new God());

        tGod.setDaemon(true);
        tGod.start();
        tPpl.start();
        tGod2.setDaemon(true);
        tGod2.start();
        System.out.println("Main end");
    }
}

class People implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("people live");
        }

        System.out.println("People thread end");
    }
}

class God implements Runnable {
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("God bless you");
        }
    }
}
