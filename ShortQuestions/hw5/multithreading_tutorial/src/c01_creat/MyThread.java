package c01_creat;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("New tread using extending Thread");
    }
}
