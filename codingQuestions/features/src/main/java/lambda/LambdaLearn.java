package lambda;

import java.util.*;
import java.util.concurrent.Callable;

public class LambdaLearn {
    public static void main(String[] args) {
        lambdaFoo();
    }

    public static void overrideFoo() {
        Foo fooByIC = new Foo() {
            @Override
            public String method(String string) {
                return string + " from Foo";
            }
        };
        String hello = fooByIC.method("hello");
        System.out.println(hello);
        fooByIC.defaultBaz();
    }

    public static void lambdaFoo() {
        Foo foo = parameter -> parameter + " from Foo";
        String hello = foo.method("hello");
        System.out.println(hello);
    }

    public static void lambdaFoo2() {
        Foo foo = parameter -> parameter.toUpperCase() + " from Foo";
        String hello = foo.method("hello");
        System.out.println(hello);
    }

    public static void testOverload() throws Exception {
        Processor processor = new ProcessorImpl();
        //String result = processor.process(() -> "abc");
        String result = processor.process((Callable<String>) () -> "abc");
    }

    public static void testFinal() {
        final String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.method("hello"));
    }

    public static void testEffectivelyFinal() {
        String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.method("hello"));
    }

    public static void testFinal2() {
        String localVariable = "Local";
        localVariable = "LOCAL";
        Foo foo = parameter -> {
            return parameter;
        };
        System.out.println(foo.method("hello"));
    }

    public static void testFinal3() {
        List<Employee> employees = EmployeeData.getEmployees();
        Employee employee = employees.get(0);
        employee.setAge(55);
        Foo foo = parameter -> {
            return parameter + " " + employee;
        };
        System.out.println(foo.method("hello"));
    }
}
