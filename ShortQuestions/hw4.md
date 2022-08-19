1. Read those codes and type it one by one by yourself. the push the code to your branch.
https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8

2. practice stream API at least 3 times
a. https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82

3. Write the Singleton design pattern include eager load and lazy load.
   1. eager load
 ```
 public class Singlton(){
    private static Singlton instance = new Singlton();

    private Singlton(){}

    public static getInstance(){
        return instance;
    }

 }

 public class Singleton(){
    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


 }


 ```
4. What is Runtime Exception? could you give me some examples?
   1. Runtime exception will be triggered during runtime instead of compile time and it will make program crash. for example, nullpointer, outofbounds.
5. Could you give me one example of NullPointerException?
   1. if you wanna use a subject like employee.getName(),but the object is null, it will trigger.
6. What is the Optional class?
   1. optional class can help check if the object is null or not, and using optional will not trigger nullpointerexception, you can use ispresent() and get()
7. What is the @FunctionalInterface?
   1. FunctionalInterface have only one abstract function
   2. the abstract function can be implemented by lambda function
   3. 
8. what is lamda?
   1. lamda function provide a more conventinet way to write funciton without writing function name, parameter type. the typical symble is a arrow.
   2. we can use lamda to replace an anonymous class.
9.  What is Method Reference?
    1.  we can use a double colon to represent the function of the class. it provide a reference of the method
10. What is Java 8 new features?
    1.  lamda, stream, optional, default mehond inside the interface, method reference.
11. Lambda can use unchanged variable outside of lambda? what is the details?
    1.  yes, lambda can use unchanged variable like final variable, variables never changed, and object without reassigning new memory.