## HW23
### 1. Read those codes and type it one by one by yourself. the push the code to your branch. 
https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/mai
n/java/com/chuwa/tutorial/t06_java8

### 2. practice stream API at least 3 times 
a. https://blog.devgenius.io/15-practical-exercises-help-you-master-javastream-
api-3f9c86b1cf82

```
see attached
```
### 3. Write the Singleton design pattern include eager load and lazy load.
```
Eagle Load
public class SingleTon {
	private static Singleton instance = new Singleton();
	private Singleton() {
	}
	public static Singleton getInstance() {
		return instance;
	}
}

Lazy Load
public class Singleton {
	private static volatile Singleton instance;
	private Singleton() {
	}
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized(singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}			
			}
		}	
	}
	return instance;
}
```

### 4. What is Runtime Exception? could you give me some examples?
```
Runtime exception is unchecked exception.
The Runtime Exception is the parent class in all exceptions of the Java programming language that are expected to crash or break down the program or application when they occur.
The most common Runtime Exceptions are: NullPointerException, ArrayIndexOutOfBoundsException and the InvalidArgumentException. The Java Virtual Machine throws the first two Runtime Exceptions.
```

### 5. Could you give me one example of NullPointerException?
```
	•	Invoking a method from a null object.
	•	Accessing or modifying a null object’s field.
	•	Taking the length of null, as if it were an array.
	•	Accessing or modifying the slots of null object, as if it were an array.
```

### 6. What is the Optional class?
```
The Optional class in Java is a container that can hold, at max, one value and gracefully deals with null values. The class was introduced in the java.util package to remove the need for multiple null checks to protect against the dreaded NullPointerExceptions during run-time.
```

### 7. What is the @FunctionalInterface?
```
Has one single Abstract method
@FunctionalInterface - for sanity check
Can have default methos
Lambda is the implementation of the abstract method
```

### 8. what is lamda?
```
A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
```

### 9. What is Method Reference?
```
Method references are a special type of lambda expressions.
They're often used to create simple lambda expressions by referencing existing methods.
```

### 10. What is Java 8 new features?
```
Default method and static method in interface
Lambda & Functional Interface
Optional
Method Reference
Stream API
```

### 11. Lambda can use unchanged variable outside of lambda? what is the details?
```
Final variable
Non-final variable however never changed
Object variable (if we use new to reassign a new memory, then this variable is
changed, can not be used in lambda)
```
