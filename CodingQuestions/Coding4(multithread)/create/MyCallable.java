import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public String call() throws Exception {
        // TODO Auto-generated method stub
        Thread.sleep(5000);
        return "call from callable";
    }
}
