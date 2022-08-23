package c01_creat;

import java.util.concurrent.Callable;

public class CallableTest {
    public static void main(String[] args) {
        final int n = 10;

        Callable<Integer> sumTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i <= n; i++){
                    sum += 1;
                }
                return sum;
            }

        };

        try{
            Integer call = sumTask.call();
            System.out.println(call);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("done");
    }
}
