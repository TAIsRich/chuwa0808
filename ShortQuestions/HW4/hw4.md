## hw4

### 1. Read those codes and type it one by one yourself, then push the code to your branch.
#### https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/tutorial/t06_java8

[CODE](https://github.com/TAIsRich/chuwa0808/tree/Flora_Zhong/notes/CodingQuestions/Coding_Exercise/src/java8/features)

### 2. Practice stream API at least 3 times.
#### https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82

[CODE](https://github.com/TAIsRich/chuwa0808/tree/Flora_Zhong/notes/CodingQuestions/Coding_Exercise/src/java8/features/streamAPI.praticalExercises)

### 3. Write the Singleton design pattern including the eager load and lazy load.

[CODE](https://github.com/TAIsRich/chuwa0808/tree/Flora_Zhong/notes/MavenProject/Design_Pattern/src/main/java/creationalDesignPattern/singleton)

### 4. What is Runtime Exception? could you give me some examples?

[Exception](./exception.png)
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

```
Example:
- ArrayIndexOutOfBoundsException: If the programmer tries to traverse an array with its index until the index is the length of the array, which will cause ArrayIndexOutOfBoundsException because the last index of the array is length - 1 since the array's index starts from 0. 
```

### 5. Could you give me one example of NullPointerException?

```
public static void main (String[] args) {
    // initialize a String variable with null value
    String str = null;

    // checking if str is null or works fine
    try {
        // this line of code throws NullPointerException because str is null
        if (str.equals("sde"))
            System.out.print("Same");
        else
            System.out.print("Not Same");
    }
    catch(NullPointerException e) {
        System.out.print("NullPointerException is caught");
    }
}
```

### 6. What is the Optional class?

```
public final class Optional<T> extends Object: 
- a container object which may or may not contain a non-null value
- if a value is present, isPresent() will return true and get() will return the value

why to use it:
- it is very hard to avoid NullPointerException without using too many null checks
- to overcome it, Java 8 has introduced a new class Optional in java.util package, it can help to write a neat code without using too many null checks to avoid NullPointerException 
- we can specify alternate values to return or alternate code to run for null, which makes the code more readable because the facts which were hidden are now visible to the developer
```

```
example:

public class OptionalDemo {
    public static void main(String[] args) {
        String[] words = new String[10];
        // public static Optional<T> ofNullable(T value) {}: Optional.ofNullable() is used to get an instance of the Optional class with the specified value of the specified type
        // if the specified value is null, then this method returns an empty instance of Optional class
        Optional<String> checkNull = Optional.ofNullable(words[5]);
            
        if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.print(word);
        }
        else {
            System.out.println("word is null");
        } 
    }
}
```

### 7. What is the @FunctionalInterface?

```
Functional Interface:
- An Interface that contains exactly one abstract method, which is known as Single Abstract Method Interfaces or SAM Interfaces.
- It can have any number of default, static methods but can contain only one abstract method. 
- Java provides predefined functional interfaces to deal with functional programming by using lambda and method references.
- You can also define your own custom functional interface. 
```

```
It can also declare methods of object class:

@FunctionalInterface  
interface sayable{  
    // abstract method  
    void say(String msg); 
     
    // contain any number of Object class methods  
    int hashCode();  
    String toString();  
    boolean equals(Object obj);  
}  
```
```
A functional interface can extends another interface only when it does not have any abstract method:

interface sayable{  
    // abstract method
    void say(String msg);     
}  

@FunctionalInterface  
interface Doable extends sayable{  
    // invalid "@FunctionalInterface" annotation, Doable is not a functional interface  
    void doIt();  
}  


interface Doable{  
    default void doIt(){  
        System.out.println("Do it now");  
    }  
}  

@FunctionalInterface  
interface Sayable extends Doable{  
    // abstract method
    // valid '@FunctionalInterface' annotation, Doable is a functional interface  
    void say(String msg);   
}  
```

### 8. what is Lambda?

```
Lambda expression is a new and important feature introduced by Java 8:
- It provides a clear and concise way to implement an abstract method of functional interface using an expression, and we do not need to define the method again for providing the implementation (@Override).
- It is very useful in collection library. It helps to iterate, filter and extract data from collection.
- Java Lambda expression is treated as a function, so compiler does not create .class file.
```
[Lambda Expression Evolution](./Lambda_expression.png)

```
Foo is an interface.
'new Foo(){}' completes the operations: 
- create a concrete anonymous class
- this anonymous class implements Foo by overriding the abstract method of Foo
- create an object of this anonymous class
Assign this object belonging to anonymous class type to fooByIC belonging Foo type

Foo fooByIC = new Foo() { 
    @Override
    public String method(String string) { 
        return string + " from Foo";
    } };
    
String hello = fooByIC.method("hello");
```
```
Format is parameter -> method body:

Foo foo = parameter -> parameter + " from Foo";
String hello = foo.method("hello");
```

### 9. Can Lambda use an unchanged variable outside itself? what are the details?

```
- Lambda expression can use the variable outside itself or an anonymous class, but the variable must be final or effectively final (a non-final local variable whose value never changes after initialization is called 'effectively final').

- The only difference between a normal variable and final variable is that we can re-assign the value to a normal variable but we cannot change the value of a final variable once assigned. We want to remain the constants throughout the execution of the Lambda.

- Also, an outside object variable used in Lambda should not be allocated a new memory to result the value of the outside object variable being changed.
```
[Example Code 1](./example_code1.png)

[Example Code 2](./example_code2.png)

[Example Code 3](./example_code3.png)

### 10. What is Method Reference?

```
Java provides a new feature called method reference in Java 8:
- It is the compact and easy form of a lambda expression. Each time when you are using a lambda expression to just referring a method, you can replace your lambda expression with the method reference. 

Types of method references:
- reference to a static method
- reference to an instance method
- reference to a constructor
```

```
类名::方法名

Arrays.sort(stringsArray,(s1,s2)->s1.compareToIgnoreCase(s2)); 
Arrays.sort(stringsArray, String::compareToIgnoreCase);
```

### 11. What are Java 8 new features?

1. **Default method in interface**: allow an interface has the concrete default methods
   
2. **Static method in interface**: allow an interface has the concrete static methods, which cannot be **overridden** int the implementation classes
   
3. **Functional interface**:
- has exactly one abstract method
- can have default methods
- '@FunctionalInterface' for a sanity check
- the abstract method can be implemented by Lambda and method references 
    
4. **Lambda**:
- replace an anonymous inner class
- work with a functional interface
- Lambda can use unchanged variable outside itself
    
5. **Optional**: avoid NullPointerExceptions which belongs to the runtime exception without null-checks 

6. **Method reference**
  
7. **Stream API**

