package hw.hw4.lambda;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Processorlmpl implements Processor{
    @Override
    public String process(Callable<String> c) throws Exception {
        return "Callable";
    }

    @Override
    public String process(Supplier<String> s) {
        return "Supplier";
    }
}
