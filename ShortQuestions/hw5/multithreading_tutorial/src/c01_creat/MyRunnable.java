package c01_creat;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("New thread using implementing Runnable");
    }
}
