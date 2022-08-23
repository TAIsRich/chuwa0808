package hw5.multithreading;

import java.util.concurrent.Callable;

public class CallableTest {
    public static void main(String[] args) {
        final int n = 10;

        Callable<Integer> task1 = () -> {
           int sum = 0;
           for(int i = 0; i < n; i++){
               ++sum;
           }

           return sum;
        };




        try{
            Integer call = task1.call();
            System.out.println(call);
        }catch(Exception e){
            e.printStackTrace();
        }




    }
}
