1. Read those codes and type it one by one by yourself. the push the code to your branch.

   Plz check ./t06_java8

2.  practice stream API at least 3 times

3. Write the Singleton design pattern include eager load and lazy load.

   Plz check ./Singleton

4. What is Runtime Exception? could you give me some examples?

   The Runtime Exception is the parent class in all exceptions of the Java programming language that are expected to crash or break down the program or application when they occur. Unlike exceptions that are not considered as Runtime Exceptions, Runtime Exceptions are never checked.

   **The 10 most common examples of RuntimeExceptions in Java are:**

   - ArithmeticException.
   - NullPointerException.
   - ClassCastException.
   - DateTimeException.
   - ArrayIndexOutOfBoundsException.
   - NegativeArraySizeException.
   - ArrayStoreException.
   - UnsupportedOperationException.

5. Could you give me one example of NullPointerException?

   ```
   // To use randomUUID function.
   import java.util.UUID;
   import java.io.*;
   
   class Singleton
   {
   	// Initializing values of single and ID to null.
   	private static Singleton single = null;
   	private String ID = null;
   
   	private Singleton()
   	{
   		/* Make it private, in order to prevent the
   		creation of new instances of the Singleton
   		class. */
   
   		// Create a random ID
   		ID = UUID.randomUUID().toString();
   	}
   
   	public static Singleton getInstance()
   	{
   		if (single == null)
   			single = new Singleton();
   		return single;
   	}
   
   	public String getID()
   	{
   		return this.ID;
   	}
   }
   
   // Driver Code
   public class TestSingleton
   {
   	public static void main(String[] args)
   	{
   		Singleton s = Singleton.getInstance();
   		System.out.println(s.getID());
   	}
   }
   ```

   

6. What is the Optional class

   The Optional class in Java is **a container that can hold, at max, one value and gracefully deals with null values**. The class was introduced in the java. util package to remove the need for multiple null checks to protect against the dreaded NullPointerExceptions during run-time.

7. What is the @FunctionalInterface?

   @FunctionalInterface annotation is **used to ensure that the functional interface can't have more than one abstract method**. A Java functional interface can be implemented by a Java Lambda Expression.

8. what is lambda?

   A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

9. What is Method Reference?

   One of the most welcome changes in Java 8 was the introduction of lambda expressions, as these allow us to forego anonymous classes, greatly reducing boilerplate code and improving readability.

   Method references are a special type of lambda expressions. They're often used to create simple lambda expressions by referencing existing methods.

10. What is Java 8 new features?

    - Lambda & Functional interface
    - Optional
    - Method reference
    - Stream API
    - Default  and static methods in interface

11. Lambda can use unchanged variable outside of lambda? what is the details?

    Yes. It can use the follow types of variables

    - Final variable
    - Non-final variable however never changed
    - Object variable (if we use new to reassign a new memory, then this variable is changed, can not be used in lambda)

​		