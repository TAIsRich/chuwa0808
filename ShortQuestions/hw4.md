3. Write Singleton design patterns, including Eager load and lazy load.

    public class SingletonEager {
    private SingletonEager(){
        System.out.println("SingletonEager Constructor Called");
    }
    private static final SingletonEager instance = new SingletonEager();
    public static SingletonEager getInstance(){
        return instance;
    }
    }

    public class SingletonLazy {
    private SingletonLazy(){
        System.out.println("SingletonLazy Constructor Called");
    }
    private static volatile SingletonLazy instance;
    public static SingletonLazy getInstance(){
        if(instance == null){
            synchronized (SingletonLazy.class){
                if(instance == null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
    }

4. What is a runtime exception? Can you give me some examples? 
    Runtime Exception is also called unchecked exception.An unchecked exception is an exception that occurs at the time of execution. Like NullPointerException.

5. Can you give me an example of NullPointerException?
    Object object = null;
    object.method();

6. What is the Optional class?
    Optional is a container object which may or may not contain a non-null value. The purpose of the class is to provide a type-level solution for representing optional values instead of null references.

7. What is @FunctionalInterface?
    A functional interface in Java is an interface that contains only a single abstract (unimplemented) method. 

8. What is lamda?
    Lambda Expressions were added in Java 8. A lambda 
    expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

9. What is a method reference?
    Method references are a special type of lambda expressions.

10. What's new in Java 8?
    1. Default method and static method in interface
    2. Lambda & Functional InterfaceFinal variable
    3. Optional
    4. Method Reference
    5. Stream API

11. Can lambdas use immutable variables outside of lambdas? What are the details?
    Yes, lambdas can use immutable variables outside of lambdas as long as:
    1. Final variable
    2. Non-final variable however never changed
    3. Object variable (if we use new to reassign a new memory, then this variable is changed, can not be used in lambda)
