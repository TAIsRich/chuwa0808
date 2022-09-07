1.  What is the checked exception and unchecked exception in Java, could you give one example?
   - checked exception: checked at compiletime, can be deal with by catch or throw statements and should be handled or speciefied at compile time. 
         eg. IOException, InterruptedException, FileNotFoundException.
   - unchecked exception: runtime excption. In Java, exceptions under Error and RuntimeException classes are unchecked exceptions, everything else under throwable is checked. 
         eg. ArithmeticException, ClassCastException, IndexOutOfBoundsException, IllegalArgumentException, NullPointerException


2.  Can there be multiple finally blocks? 
   - no, for each try block there can be zero or more catch blocks, but only one finally block.


3.  When both catch and finally return values, what will be the final result?
   - see situation 5, it would return in the finally stage, never reach catch return:

   - situations:
    1. try{} catch(){}finally{} return : follows the sequence
    2. try{ return; }catch(){} finally{} return : try statement before return,  including calculation in return statement, then finally then try return
    3. try{ } catch(){return;} finally{} return : try, if exception catch before return statements, finally, catch return 
    4. try{ return; }catch(){} finally{return;} : try statement before return,  including calculation in return statement, then finally then finally return
    5. try{ return;}catch(){return;} finally{return;} : try before return, if exception catch before return(if no exception skip to finally), then finally and return 

4.  What is optional? why do you use it? write an optional example
   - it's a container to store values could be null. So that can represent null without check values. 
   - To avoid Null checks and runtime NullPointerException. And make s code more readable because the hidden facts are visible to developer.
   - eg,
   ```
   import java.util.Optional;

   public class Optional {
      public static void main(String[] args) {
         String[] words = new String[10];
         Optional<String> checkNull = Optional.ofNullable(words[5]);
         if (checkNull.isPresent()) {
            String word = words[5].toLowerCase();
            System.out.println(word);
         }
         else System.out.println("word is null");
      }
   }
   ```
   ```
   public int getMobilScreenWithOptional(Mobil, mobil) {
      return Optional.ofNullable(mobil).flatMap(Mobil::getDisplayFeaturesOptional)
                     .flatMap(DisplayFeatures::getResolutionOptional)
                     .mao(ScreenResolution::getWidth)
                     .orElse(0);
   }
   ```

5.  Why finally always be executed ?
   - We need to ensure finally block always excutes whether an unexpected exception occurs. 
   - Besides, it allows us to avoid having cleanup code accidentally bypassed by a return, continue or break. So putting cleanup code inside a finally block is a good practice even when no exceptions are anticipated.
   
   - ps. finally block is always get executed unless there is an abnormal program termination either resulting from a JVM crash or from a call to System.exit() or JVM runs out of memory when our java process is killed forcefully from task manager or console when our machine shuts down due to power failure and deadlock condition in our try block.


6.  Practice collection problems here: [collection tutorial](https://github.com/TAIsRich/chuwa-eij-tutorial/tree/main/02-java-core/src/main/java/com/chuwa/exercise/collection)


7.  What is Java 8 new features ?
   - Default method and static method in interface
   - lambda & functional interface
   - Optional
   - Method Reference : ContainingClass::staticMethodName
   - Stream API


8.  What are the types of design patterns in Java ?
   - creational dp
   - structural dp
   - behavioral dp


9.  What are the SOLID Principles ?
   - S : Single responsibility, one class one job
   - O : Open-closed principle, objects or entities should be open for extension close for modification
   - L : Liskov Substitution p, every subclass should be substitutable for parent class
   - I : Interface Segregation p, clients shouldn’t be forced to depend on methods they do not use.
   - D : Dependency Inversion p, entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions.


10.  How can you achieve thread-safe singleton patterns in Java ?
   - use  getInstance() method so that multiple threads can't access simutaneously.


11.  What do you understand by the Open-Closed Principle (OCP) ?
   - we should try to avoid modification on original code, keep it neat and pure. And trying to design class good enough so that we can meet new requirements by adding several classes instead of modify current classes. That means when design parent class, consider more abstract.


12.  Liskov’s substitution principle states that if class B is a subtype of class A, then object of type A may be substituted with any object of type B. What does this actually mean? (from OA ) choose your answer.
- [x] It mean that if the object of type A can do something, the object of type B could also be able to 
perform the same thing
- [ ] It means that all the objects of type A could execute all the methods present in its subtype B
- [ ] It means if a method is present in class A, it should also be present in class B so that the object of 
type B could substitute object of type A.
- [ ] It means that for the class B to inherit class A, objects of type B and objects of type A must be same.
