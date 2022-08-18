### 3. Write the Singleton design pattern include eager load and lazy load.
```
public class SingletonE{
    private static SingletonE instance = new SingletonE();
    
    private SingletonE() {};
    
    public SingletonE getInstance(){
        return instance;
    }
}
```

```
public class SingletonL{
    private static volatile SingletonL instance;
    
    private SingletonL() {};
    
    public static SingletonL getInstance(){
        if (instance == null){
            synchronized (SingletonL.class){
                if (instance == null){
                    instance = new SingletonL();
                }
            }
        }
        return instance;
    }
}
```

### 4. What is Runtime Exception? could you give me some examples?
```
RuntimeException is the superclass of all classes that exceptions are thrown during the normal operation of the JVM. 
The RuntimeException and its subclasses are unchecked exceptions. 

The most common exceptions are 
- NullPointerException
- ArrayIndexOutOfBoundsException
- ClassCastException
- InvalidArgumentException
```

### 5. Could you give me one example of NullPointerException?
```
NullPointerException is thrown when program attempts to use an object reference that has the null value.

Student student;
student.getName();
```

### 6. What is the Optional class?
```
Optional is a container object which may or may not contain a non-null value. 
This class has various utility methods to facilitate code to handle values as 'available' or 'not available' instead of checking null values.
```

### 7. What is the @FunctionalInterface?
```
A Functional Interface
- is an interface that contains only one abstract method
- contains a lot of default method
- has a sanity check
- lambda expressions can be used 
```

### 8. what is lambda?
```
A lambda expression is a short block of code which takes in parameters and returns a value. 
Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
```

### 9. What is Method Reference?
```
A method reference is the shorthand syntax for a lambda expression that contains just one method call. 

There are four kinds of method references:
- Static methods
- Instance methods of particular objects
- Instance methods of an arbitrary object of a particular type
- Constructor
```

### 10. What is Java 8 new features?
```
Functional Interfaces
Lambda expressions
Method Reference
Optional class
Stream API
```

### 11. Lambda can use unchanged variable outside of lambda? what is the details?
```
Lambda can use unchanged variable outside of lambda：
- Final variable
- Non-final variable however never changed
- Object variable (if we use new to reassign a new memory, then this variable is changed, can not be used in lambda)
```
