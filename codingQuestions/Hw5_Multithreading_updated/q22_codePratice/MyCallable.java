package Hw5_Multithreading_updated.q22_codePratice;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception{
        Thread.sleep(5000);
        return "start new thread using Callable";
    }

}
