package com.xiazhao.newfeature.lambda;

import java.io.FileNotFoundException;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class ProcessImpl implements Processor {
    @Override
    public String process(Callable<String> c) throws Exception {
        return "callable";
    }


    @Override
    public String process(Supplier<String> s) {
        return "supplier";
    }

    public static void main(String[] args) throws Exception {
        ProcessImpl processor = new ProcessImpl();
        Callable<String> callable = () -> "hello";
        String processFromCallable = processor.process(callable);
        Supplier<String> supplier = () -> "hello";
        String processFromSupplier = processor.process(supplier);
    }
}
