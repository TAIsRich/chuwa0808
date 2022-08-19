package java8.features.lambda;

import java8.features.Employee;
import java8.features.EmployeeData;
import org.junit.Test;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class LambdaLearn {

    @Test
    public void overrideFoo(){
        Foo fooByIC = new Foo() {
            @Override
            public String method(String string) {
                return string + " from Foo";
            }
        };

        String hello = fooByIC.method("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo(){
        Foo foo = parameter -> parameter + " from Foo";

        String hello = foo.method("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo2(){
        Foo foo = parameter -> parameter.toUpperCase() + " from Foo";
        String hello = foo.method("hello");
        System.out.println(hello);
    }


    /**
     * To solve this problem, we have two options. The first option is to use methods with different names:
     * String processWithCallable(Callable<String> c) throws Exception;

     * String processWithSupplier(Supplier<String> s);
     * @throws Exception
     */

    @Test
    public void testOverload() throws Exception{

        Processor processor = new ProcessorImpl();
        String res = processor.process((Callable<String>) () -> "abc");
        String result = processor.process((Supplier<String>) () -> "abc");
        System.out.println(res + "  " + result);

    }


    //local final variable outside the lambda expression
    @Test
    public void testFinal(){
        final String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.method("hello"));
    }

    //effectively final variable, which means the variable basically won't change, the variable is not declared as final though
    @Test
    public void testEffectivelyFinal(){
        String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };
        System.out.println(foo.method("hello"));
    }

    @Test
    public void testFinal2(){
        String localVariable = "Local";
        localVariable = "LOCAL";
        Foo foo = parameter -> {

            //with a changed variable value from outside that will occur problem
            return parameter; //+ " " + localVariable;
        };
        System.out.println(foo.method("hello"));
    }


    //这边改object的set方法不会报错
    @Test
    public void testFinal3(){
        List<Employee> employees = EmployeeData.getEmployees();
        Employee employee = employees.get(0);
        employee.setAge(55);
        Foo foo = parameter -> parameter + " " + employee;
        System.out.println(foo.method("hello"));

    }

}
