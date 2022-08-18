import java.util.List;

import javax.annotation.processing.Processor;

public class LambdaLearn {

    public static void main(String[] args) {
        // overrideFoo();
        // lambdaFoo();
        // lambdaFoo2();
        // testOverload();
        // testFinal();
        testEffectivelyFinal();

    }

    // @Test
    public static void overrideFoo() {
        Foo f = new Foo(){
            @Override
            public String method(String str){
                return str+"foo";
            }
        };
        String str = f.method("hello ");
        System.out.println(str);
        f.defaultBaz();
    }

    public static void lambdaFoo() {
        Foo f = p -> p+" foo";
        String hello = f.method("hello");
        System.out.println(hello);
    }

    public static void lambdaFoo2() {
        Foo foo = parameter -> parameter.toUpperCase() + " from Foo";

        String hello = foo.method("hello");
        System.out.println(hello);
    }


    public static void testOverload() throws Exception {
        Processor processor = new ProcessorImpl();

    //    String result = processor.process(() -> "abc");
    //    String result = processor.process((Callable<String>) () -> "abc");
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

    public void testFinal2() {
        String localVariable = "Local";
        localVariable = "LOCAL"; // 新的内存地址

        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
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