package java8.features.optional;

import org.junit.Test;
import java8.features.Employee;

import java.util.Optional;

public class OptionalTest {


    //of(T t) - 不可以为null
    //ofNullable(T t) - 可以为null
    //orElse(T t) - 如果当前的optional内部封装的t是非空的，则返回内部t, 如果内部的t是空的， 则返回orElse()方法中的t
    @Test
    public void testOptionalWithNotHandleException(){
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);
        employee = null;
        Optional<Employee> optional2 = Optional.of(employee);
    }

    @Test(expected = NullPointerException.class)
    public void test1(){
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);

        employee = null;
        Optional<Employee> optional2 = Optional.of(employee);
    }

    //可以为null，但会打出Optional.empty
    @Test
    public void testOfNullable(){
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);

    }


    //orElse,如果前面传进来的参数为空，泽执行orElse内部的
    @Test
    public void testOrElse(){
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);

        Employee optional3 = Optional.ofNullable(employee).orElse(new Employee(1, "JCole- the goat", 37, 6666));
        System.out.println(optional3);
    }


}
