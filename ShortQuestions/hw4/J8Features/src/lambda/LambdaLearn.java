package lambda;

import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class LambdaLearn {

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

    public void lambdaFoo(){
        Foo foo = parameter -> parameter + "from Foo";

        String hello = foo.method("hello");
        System.out.println(hello);
    }

    public void lambdaFoo2(){
        Foo foo = parameter -> parameter.toUpperCase() + "from Foo";

        String hello = foo.method("hello");
        System.out.println(hello);
    }


    public void testOverload() throws Exception{
        Processor processor = new ProcessorImpl();
    }

    public void testFinal(){
        final String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.method("hello"));
    }

    public void testEffectivelyFinal(){
        String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.method("hello"));
    }

    public void testFinal2(){
        String localVariable = "Local";
        localVariable = "LOCAL";

        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        System.out.println(foo.method("hello"));
    }

    public void testFinals(){
        List<Employee> employees = EmployeeData.getEmployees();

        Employee employee = employees.get(0);
        employee.setAge(55);

        Foo foo = parameter -> {
            return parameter + " " + employee;
        };

        System.out.println(foo.method("hello"));
    }
}
