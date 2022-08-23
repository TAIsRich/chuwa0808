import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int n = 10;

        Callable<Integer> call = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // TODO Auto-generated method stub
                int x = 0;
                for (int i = 1; i <= n; i++) {
                    x += i;
                }
                return x;
            }
        };
        
        try {
            // have return value
            Integer num = call.call();
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<Integer> future = es.submit(call);
        Integer x = future.get();
        System.out.println(x);
        es.shutdown();

    }
}
