## hw3

### 1. What is the checked exception and unchecked exception in Java, could you give one example?

```
Exception is an unwanted or unexpected event, which occurs during the execution of a program, i.e. at run time, that disrupts the normal flow of the program’s instructions. In Java, there are two types of exceptions:

Checked Exception: 
- something has gone wrong in your code and is recoverable
- are checked and handled during the compile-time
- handle either by re-throwing (别人的method declare with keyword "throws", 你的method需要调用别人的method, 那么你的method signiture那里也declare with keyword "throws") or a try-catch block (catch后决定怎么处理，也可以就单纯的打印出来这个exception)
- directly inherit Throwable class except RuntimeException and Error, and extend Exception class

include:
- SQLException
- IOException
- ClassNotFoundException
- InvocationTargetException
- FileNotfound Exception

Unchecked Exception: 
- something has gone wrong with the program logic and is unrecoverable
- are checked during the runtime and occurs during the execution of a program
- the cause of unchecked exceptions is mostly due to programming errors like attempting to access an element with an invalid index, and calling the method with illegal arguments, etc.
- unlike the checked exceptions, the compiler generally ignores the unchecked exceptions during compilation, and the compiler does not check whether the user program contains the code to handle them or not
- directly inherit RuntimeException, and extend Exception class

include:
- ArithmeticException
- NullPointerException
- ArrayIndexOutOfBoundsException
- NumberFormatException
- InputMismatchException
- IllegalArgumentException
- IllegalStateException
- ClassCastException
- Missing Resource Exception
- No Such Element Exception
- Undeclared Throwable Exception
- Empty Stack Exception

note: 
keyword "throw": 
- produce a exception
- can be used in checked/unchecked exception

try-catch balock: 
- handle a exception: produce, print or solve
- can be used in checked/unchecked exception
```
[Exception](./exception.png)

### 2. Can there be multiple finally blocks?

```
finally: 
- can be used in association with a try-catch block
- the finally block will be executed after the try-catch block (could be one try following multiple catches), but before the control transfers back to its origin
- guarantee that a section of code will be executed, even if an exception is thrown
- there is only one finally clause following a try-catch statement, but you can have a nested combination formed by many try-catch-finally blocks, ie. the try blocks are as many as the finally blocks as below:
```
```
try {
    try {

    } 
    catch() { // could be more than one

    } 
    finally {

    }
} 
catch() { // could be more than one

} 
finally {

}
```

### 3. When both catch and finally return values, what will be the final result?

```
- eventually be the value returned by finally block
- no matter catch the exception and run the return a value by the catch block or not, the control will be transferred to the finally block, which means the value returned in finally block will write the content over
```

### 4. Why does finally always be executed ?

```


```

### 5. What is optional? Why do you use it? Write an optional example.

```
public final class Optional<T> extends Object: 
- a container object which may or may not contain a non-null value
- If a value is present, isPresent() will return true and get() will return the value

why to use it:
- it is very hard to avoid NullPointerException without using too many null checks
- to overcome it, Java 8 has introduced a new class Optional in java.util package
- it can help to write a neat code without using too many null checks to avoid NullPointerException 
- we can specify alternate values to return or alternate code to run for null, which makes the code more readable because the facts which were hidden are now visible to the developer

example:
public class OptionalDemo {
    public static void main(String[] args)
    {
        String[] words = new String[10];
        Optional<String> checkNull
            = Optional.ofNullable(words[5]);
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.print(word);
        }
        else
            System.out.println("word is null");
    }
}

```

### 6. Practice collection problems here: https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection

[CODE](https://github.com/TAIsRich/chuwa0808/tree/Flora_Zhong/hw3/CodingQuestions/Coding_Exercise1/src/collection)

### 7. What are Java 8 new features?

```
1. forEach() method in Iterable interface
2. default and static methods in interfaces
3. Functional Interfaces and Lambda Expressions
4. method references
5. Optional<T>
6. Java Stream API for bulk data operations on Collections
7. Java Time API
```

### 8. What are the types of design patterns in Java?

```

```

### 9. What are the SOLID Principles?

```

```

### 10. How can you achieve the thread-safe singleton patterns in Java?

```

```

### 11. What do you understand by the Open-Closed Principle (OCP)?

```

```

### 12. Liskov's Substitution Principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (OA problem) 

```
answer: 1

1. It means that if the object of type A can do something, the object of type B could also be able to perform the same thing.
2. It means that all the objects of type A could execute all the methods present in its subtype B.
3. It means if a method is present in class A, it should also be present in class B so that the object of type B could substitute object of type A. (not must be present explicitly, can inherit implicitly)
4. It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
```

### 13. Watch the design pattern video, type the code, and submit it to the MavenProject folder.
#### singleton: https://www.bilibili.com/video/BV1Np4y1z7BU?p=22
#### Factory: https://www.bilibili.com/video/BV1Np4y1z7BU?p=35&vd_source=310561eab1216a27f7accf859bf7f6d9
#### Builder: https://www.bilibili.com/video/BV1Np4y1z7BU?p=50&vd_source=310561eab1216a27f7accf859bf7f6d9
#### Publisher_Subscriber: https://www.bilibili.com/video/BV1Np4y1z7BU?p=114&vd_source=310561eab1216a27f7accf859bf7f6d9

[CODE](https://github.com/TAIsRich/chuwa0808/tree/Flora_Zhong/hw3/MavenProject/Design_Pattern/src/designPattern)