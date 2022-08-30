package creat;
import org.junit.Test;

import java.util.Iterator;
import java.util.concurrent.Callable;

public class CallableTest {
    static final int n = 10;
    public static void main(String[] args) {
        Callable<Integer> sumTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= n; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        try{
            Integer call = sumTask.call();
            System.out.println(call);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("done");
    }
}
