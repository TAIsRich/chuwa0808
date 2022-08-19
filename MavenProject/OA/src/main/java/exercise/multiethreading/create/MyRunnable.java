package exercise.multiethreading.create;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Start new thread using Runnable");
    }
}
