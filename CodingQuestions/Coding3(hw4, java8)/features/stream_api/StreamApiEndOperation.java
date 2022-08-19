import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiEndOperation {
    /**
     * 终止操作
     * 一， 匹配与查找
     * 1， allMatch(Predicate p) - 检查是否匹配所有的元素
     * 2， anyMatch(Predicate p) - 检查是否至少匹配一个元素
     * 3， noneMatch(Predicate p) - 检查是否没有匹配的元素
     * 4, findFirst - 返回第一个元素
     * 5， findAny - 返回当前流中的任意元素
     * 6, count - 返回流中元素的个数
     * 7, max(Comparator c) - 返回流中的最大值
     * 8, min(Comparator c) - 返回流中的最小值
     * 9, forEach(Consumer c) - 内部迭代
     *
     * 二，归约
     * 1, reduce(T identity, BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
     * 2, reduce(BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
     *
     * 三， 收集
     * 1, collect(Collector c)
     */
    // Employee e1 = new Employee(1001, "tom", 20, 2222);
    // Employee e2 = new Employee(1002, "Jerry", 18, 5000);
    // Employee e3 = new Employee(1003, "Tony", 20, 1000);
    // Employee e4 = new Employee(1004, "Liam", 18, 4000);

    private static final List<Employee> EMPLOYEES = new ArrayList<Employee>();
    

    public static void main(String[] args) {
        Employee e1 = new Employee(1001, "tom", 23, 2222);
        Employee e2 = new Employee(1002, "Jerry", 18, 5000);
        Employee e3 = new Employee(1003, "Tony", 20, 1000);
        Employee e4 = new Employee(1004, "Liam", 18, 4000);
        EMPLOYEES.add(e1);
        EMPLOYEES.add(e2);
        EMPLOYEES.add(e3);
        EMPLOYEES.add(e4);
        // System.out.println(Employee.test());
        // testMatch(EMPLOYEES);
        // testFind(EMPLOYEES);
        // testCountMaxMin(EMPLOYEES);
        // testIteration(EMPLOYEES);
        // testReduce(EMPLOYEES);
        // testCollect(EMPLOYEES);
        testChain(EMPLOYEES);
    }
    /**
     * 1， allMatch(Predicate p) - 检查是否匹配所有的元素
     * 2， anyMatch(Predicate p) - 检查是否至少匹配一个元素
     * 3， noneMatch(Predicate p) - 检查是否没有匹配的元素
     */

    public static void testMatch(List<Employee> EMPLOYEES) {
       boolean b = EMPLOYEES.stream().allMatch(e -> e.salary>=1000);
       System.out.println(b);

       boolean b1 = EMPLOYEES.stream().anyMatch(e -> e.salary >1000);
       System.out.println(b1);

       boolean b2 = EMPLOYEES.stream().noneMatch(e -> e.salary >1000);
       System.out.println(b2);


    }

    public static void testFind(List<Employee> EMPLOYEES) {
        Optional<Employee> op = EMPLOYEES.stream().findFirst();
        // System.out.println(op.get().age);

        Optional<Employee> op1 = EMPLOYEES.parallelStream().findAny();
        System.out.println(op1.get().id);

        Stream<Integer> is = Stream.of(1,2,3,4,5);
        Optional<Integer> ip = is.findAny();
        System.out.println(ip.get());

    }

    public static void testCountMaxMin(List<Employee> EMPLOYEES) {
        long num = EMPLOYEES.stream().filter(e -> e.salary >2000).count();

        //        7, max(Comparator c) - 返回流中的最大值
        Stream<Integer> s = EMPLOYEES.stream().map(e -> e.age);
        Optional<Integer> max = s.max(Integer::compare);
        System.out.println(max.get());

        Optional<Integer> min = EMPLOYEES.stream().map(e->e.age).min(Integer::compare);
        // Optional<Employee> min = EMPLOYEES.stream()
            // .min(Comparator.comparingInt(Employee::getId));
        System.out.println("min age is : " + min.get());
        // System.out.println(Comparator.comparingInt(Integer::compare));


    }

    public static void testIteration(List<Employee> EMPLOYEES) {
        //        9, forEach(Consumer c) - 内部迭代
                EMPLOYEES.stream().forEach(System.out::println);
        
                System.out.println("\n********************************\n");
                // 使用集合的迭代
                EMPLOYEES.forEach(System.out::println);
            }

    
   public static void testReduce(List<Employee> EMPLOYEES) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Integer i = list.stream().reduce(10,Integer::sum);
        System.out.println(i);

        Optional<Integer> ip = list.stream().reduce(Integer::sum);
        System.out.println(ip.get());

        Optional<Integer> ip2 = list.stream().reduce((e1,e2)->e1+e2);
        System.out.println(ip2.get());
   }

   public static void testCollect(List<Employee> EMPLOYEES) {
        List<Employee> list = EMPLOYEES.stream().filter(e->e.salary > 2000).collect(Collectors.toList());
        list.forEach(e -> System.out.println(e.salary));

        Set<Employee> s = EMPLOYEES.stream().filter(e->e.salary > 2000).collect(Collectors.toSet());
        s.forEach(e -> System.out.println(e.salary));
   }

   public static void testChain(List<Employee> EMPLOYEES){
    Optional<Integer> reduce = EMPLOYEES.stream()
                .filter(e -> e.age < 40)
                .map(e -> e.salary * 0.8)
                .map(e -> {
                    System.out.println(e);
                    return e.intValue();
                })
                .reduce(Integer::sum);
        System.out.println(reduce.get());
   }







}

// class Employee {
//     public int id;
//     public String name;
//     public int age;
//     public int salary;
//     public Employee(int id, String n, int a, int sa){
//         this.id = id;
//         this.name = n;
//         this.age = a;
//         this.salary = sa;
//     }
//     public int getID(){
//         return this.id;
//     }
//     public int salaryGetter(){
//         return this.salary;
//     }
//  }