package c01_creat;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "New thread using implementing Callable";
    }
}
