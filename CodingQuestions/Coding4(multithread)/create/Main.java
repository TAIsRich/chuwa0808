import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException  {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Mythread();
        Thread t2 = new Thread(mr);
        t1.start();
        t2.start();

        Thread t3 = new Thread(()-> System.out.println("thread 3 runnable"));

        t3.start();

        ExecutorService es = Executors.newFixedThreadPool(3);
        List<Future<String>> listOfFuture = new ArrayList<>();
        Future<String> future1 = es.submit(new MyCallable());
        listOfFuture.add(future1);
        if(future1.isDone()){
            System.out.println(future1.get()); 
        } else{
            System.out.println("future1 is not done");
        }

        es.submit(new MyRunnable());

        es.shutdown();


    }
}
