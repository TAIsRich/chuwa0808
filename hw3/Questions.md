1. What is the checked exception and unchecked exception in Java, could you give one example? 

   **A checked exception is caught at compile time whereas a runtime or unchecked exception is, as it states, at runtime**. A checked exception must be handled either by re-throwing or with a try catch block, whereas an unchecked isn't required to be handled.

   ```java
   public class CheckedException { 
       public void readFile() {
           String fileName = "file does not exist"; 
           File file = new File(fileName);
           try {
               FileInputStream stream = new FileInputStream(file); 
           } catch (FileNotFoundException e) {
               e.printStackTrace();
           }
       }
   }
   ```

   The most common Java unchecked exception is the good old `NullPointerException` which is when you are trying to access a variable or object that doesn’t exist.

2. Can there be multiple finally blocks? 

   You can only have one finally clause per try/catch/finally statement, but **you can have multiple such statements, either in the same method or in multiple methods**

3. When both catch and finally return values, what will be the final result? 

   results in the finally clause. 

4. What is optional? why do you use it? write an optional example 

   A container object which may or may not contain a non-null value. Optional is **primarily intended for use as a method return type where there is a clear need to represent 'no result,' and where using null is likely to cause errors**. This makes our code more robust.

   ```java
   @Test
   public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
       String name = "baeldung";
       Optional<String> opt = Optional.of(name);
       assertTrue(opt.isPresent());
   }
   ```

5. Why finally always be executed ?

   it allows the programmer to avoid having cleanup code accidentally bypassed by a return, continue, or break. Putting cleanup code in a finally block is always a good practice, even when no exceptions are anticipated.

6. Practice collection problems.

   check ./CollectionExercise

7. What is Java 8 new features ?

   - Default method and static method in interface
   - Lambda & Functional Interface
   - Optional
   - Method Reference
   - Stream API

8. What are the types of design patterns in Java ?

   **Creational Design Pattern**

   1. Factory Pattern
   2. Abstract Factory Pattern
   3. Singleton Pattern
   4. Prototype Pattern
   5. Builder Pattern.

   **Structural Design Pattern**

   1. Adapter Pattern
   2. Bridge Pattern
   3. Composite Pattern
   4. Decorator Pattern
   5. Facade Pattern
   6. Flyweight Pattern
   7. Proxy Pattern

   **Behavioral Design Pattern**

   1. Chain Of Responsibility Pattern
   2. Command Pattern
   3. Interpreter Pattern
   4. Iterator Pattern
   5. Mediator Pattern
   6. Memento Pattern
   7. Observer Pattern
   8. State Pattern
   9. Strategy Pattern
   10. Template Pattern
   11. Visitor Pattern

9. What are the SOLID Principles ?

   - The **s**ingle-responsibility principle: "There should never be more than one reason for a class to change." In other words, every class should have only one responsibility.
   - The **o**pen–closed principle: "Software entities should be open for extension, but closed for modification."
   - The **L**iskov substitution principle: "Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it."
   - The **i**nterface segregation principle: "Clients should not be forced to depend upon interfaces that they do not use."
   - The **d**ependency inversion principle: "Depend upon abstractions, not concretions.

10. How can you achieve thread-safe singleton patterns in Java ?

    ```java
    public class Singleton {
        // 1, static volatile variable
        private static volatile Singleton instance;
    // 2, make constructor be private
        // 保证不能new， ⼀旦可以new, 就可以建造很多instance， 则就不再是singleton。
        private Singleton() {
        }
        // 3. static synchronized getInstance method
        // static保证在没有instance的情况下，可以调该⽅法。
        public static Singleton getInstance() {
    // 4, make sure thread safe, improve performance
            if (instance == null) { // 可能是多个线程
                synchronized (Singleton.class) { // 保证正能进⼊⼀个线程
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
    ```

    

11. What do you understand by the Open-Closed Principle (OCP) ?

    Open-closed Principle (OCP) states: **Objects or entities should be open for extension but closed for modification**. This means that a class should be extendable without modifying the class itself. 

12. Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.

    3

13. Watch the design pattern video, and type the code, submit it to MavenProject folder