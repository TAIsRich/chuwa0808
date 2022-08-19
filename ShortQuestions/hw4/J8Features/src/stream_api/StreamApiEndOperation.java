package stream_api;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiEndOperation {

    public void testMathch() {
        boolean allMatch = Employees.stream().allMatch(e -> e.getName().length() >2);
        System.out.println(allMatch);

        System.out.println("***************************");

        boolean anyMatch = Employees.stream().anyMatch(e -> e.getName().length() >3);
        System.out.println(anyMatch);

        System.out.println("***************************");

        boolean noneMatch = Employees.stream().noneMatch(e -> e.getName().startsWith("Yun"));
        System.out.println(noneMatch);
    }

    public void testFind() {
        Optional<Employee> employee = EMPLOYEES.stream().findFirst();
        System.out.println(employee);

        Optional<Employee> any = EMPLOYEES.parallelStream().findAny();
        System.out.println(any);
    }

    public void testCountMaxMin() {
        long count = Employees.stream().filter(e -> e.getAge() > 40).count();
        System.out.println("num of employees(age > 40): " + count);

        Stream<Integer> stream = Employees.stream().map(Employee :: getAge);
        Optional<Integer> max = stream.max(Integer :: compare);
        System.out.println("max age is: " + max);

        Optional<Employee> min = Employees.stream().min(Comparator.comparingInt(Employee :: getID));
        System.out.println("min age is : " + min);

        Employees.stream()
                .filter(e -> e.getAge() > 40)
                .map (e -> e.getName() + " : OLD PPL")
                .forEach(System.out :: println);

        List<String> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40)
                .map(e -> e.getName() + " ： OLD PPL")
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    public void testIteration() {
        Employees.stream().forEach(System.out :: println);
        System.out.println("\n********************************\n");
        EMPLOYEES.forEach(System.out::println);
    }

    public void testReduce() {
/       List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

/       Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce1 = stream.reduce(Integer::sum);
        System.out.println(reduce1);

        Stream<Integer> stream2 = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce2 = stream2.reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce2.get());
    }

    public void testCollect() {
        List<Employee> collect = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toList());
        collect.forEach(System.out::println);

        Set<Employee> collect2 = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toSet());
        collect2.forEach(System.out::println);
    }

    public void testChain() {
        List<Double> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .map(e -> e.getSalary() * 0.8)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("********************");

        Optional<Integer> reduce = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .map(e -> e.getSalary() * 0.8)
                .map(e -> {
                    System.out.println(e);
                    return e.intValue();
                })
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }
}
