package com.xiazhao.newfeature.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class LambdaLearn {
    @Test
    public void overrideFoo() {
        Foo fooByIc = new Foo() {
            @Override
            public String method(String string) {
                return string + " from Foo";
            }
        };

        String hello = fooByIc.method("hello");
        System.out.println(hello);
        fooByIc.defaultBaz();
    }

    @Test
    public void lambdaFoo() {
        Foo foo = s -> s + " from Foo";

        String s = foo.method("hello");
        System.out.println(s);
    }

    @Test
    public void lambdaFoo2() {
        Foo foo = String::toUpperCase;

        String s = foo.method("hello");
        System.out.println(s);
    }

    @Test
    public void testOverload() throws Exception {
        Processor processor = new ProcessImpl();
        //String s = processor.process(() -> "abc");
        String result = processor.process((Callable<String>) () -> "abc");
        String s2 = "xxxx";
        String s = processor.process((Supplier<String>) s2::toUpperCase);
    }

    @Test
    public void testFinal() {
        final String localVariable = "local";
        Foo foo = s -> s + " " + localVariable;
        System.out.println(foo.method("hello"));
    }

    @Test
    public void testEffectivelyFinal() {
        String s = "local";
        String finalS = s;
        Foo foo = p -> p + " " + finalS;
        s = "xxxx";
    }

    @Test
    public void testFinal2() {
        String s = "apple";
        s = "banana";

        Foo foo = p -> p;
    }

    @Test
    public void testFinal3() {
        List<Integer> list = new ArrayList<>();

        list.set(3, 4);
        list.set(3, 5);
        Foo foo = p -> p + list.get(3).toString();
        list.set(3, 7);
    }
}
