### 1. Read those codes and type it one by one by yourself. the push the code to your branch.

### 2. practice stream API at least 3 times

### 3. Write the Singleton design pattern include eager load and lazy load.
- Eager load:
```
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public Singleton getInstance() {
        return instance;
    }

}
```

- Lazy load:
```
public class Singleton {
    private static volatile Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }

            }
        }
        return instance ;
    }
}
```
### 4. What is Runtime Exception? could you give me some examples?
- Runtime Exception, also as known as unchecked Exception, due to the Exception does not occur at compile time, which means the Exception occurs during run time. On the other hand, the Runtime Exception shows the programmer's error instead of the condition a program is expected to deal with.
- An example can be ArrayIndexOutOfBoundsException, one of the exceptions derived from the Runtime Exception. If the programmer tries to traverse an array with its index, and until the index is the length of the array, that will cause ArrayIndexOutOfBoundsException because the last index of the array is array length-1 since the array's index started by 0. 

### 5. Could you give me one example of NullPointerException?
- For instance, a String variable is not initialized or initialized as null, and the variable is called to compare or do an operation.
```
String st;
String str = null;
if(st.equals(str)){} // crash

int t;
int tmp = t + t; // crash program
```
### 6. What is the Optional class?
- The optional class is to help the program write the code without too many null checks since programmer used to use a lot of null checks to avoid NullPointerException
### 7. What is the @FunctionalInterface?
- The functional interface is brought by Java 8 as a new feature, which is an interface containing only an abstract method. The lambda expression can create an object of the functional interface. Usually, the functional interface is represented by an annotation called @FunctionalInterface.
### 8. what is lambda?
- Lambda expressions represent the instance of a functional interface, which can be understood as a brunch of code that can be passed. It can be created without belonging to any class. With use of Lamba expressions, the code could be cleaner and flexible.
### 9. What is Method Reference?
- The method reference can be considered the more profound representation of Lambda expressions. On the other hand, the method reference is Lambda expressions, which means it is an instance of a functional interface. It uses **::** for represent.
### 10. What is Java 8 new features?
1. Default method and static method in interface
2. Lambda expressions
3. Functional interface
4. Optional
5. Method reference
6. Stream API
### 11. Lambda can use unchanged variable outside of lambda? what is the details?
- Lambda expression can use the variable outside of the Lambda, but the variable must be final or effectively final. Also, an object variable used in Lambda shouldn't allocate new memory and then change the value.
- The reason is when Lambda catches external variable, it copies the variable; therefore, if the variable is changed inside the Lambda, it does not affect the external variable, so the external variable cannot be reassigned to avoid the programer mistaken for directly change external variable