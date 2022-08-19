package exercise.multiethreading.create;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("start new thread using extends thread");
    }
}
