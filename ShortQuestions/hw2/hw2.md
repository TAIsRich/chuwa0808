1. What is wrapper class in Java and Why we need wrapper class? 
	1. wrapper class creates a new class that wraps another class, hiding the info and functions on the class it wraps. Wrapper class can help with encapsulates and hiding the details about on a class.
2.  What is the difference between HashMap and HashTable?
	1. HashTable is synchronized and hashMap is not synchronized 
	2. HashTable does not allow null keys or values, HashMap allows null values
3.  What is String pool in Java and why we need String pool? 
	1. String pool is a place that stores the Strings that is not allocated
4.  What is Java garbage collection?
	1. Java garbage collection is an automated process in Java to keep track of memory and prevent memory leak.
	2. Java garbage collection checks data on heap, deletes when no pointer pointing to such data.
5.  What are access modifiers and their scopes in Java? 
	1. Access modifiers defines who can access the class variables and functions
	2. Default	- can be access by same class and sub class
	3. Private	- can only access by same class
	4. Protected - can access by same class, sub class
	5. Public	- can access by every class
6.  What is final key word? (Filed, Method, Class)
	1. Final key word defined that things can not be change.
	2. Final variable - variable that can not changed it's value
	3. Final method - can not be override
	4. Final class - can not be extend or inheritance
7.  What is static keyword? (Filed, Method, Class). When do we usually use it?
	1. static keyword shares it's memory to the class
	2. static variables share among the class
	3. static method can be call by any one without creating object
	4. static class can only be nested static class, no top-level static class can be created
8.  What is the differences between overriding and overloading?
	1. overriding - same method name with different paramerters
	2. overloading - same method signature in both super class and child class
9.  What is the differences between super and this?
	1. Super points to parent class
	2. This points to current class
10.  What is the Java load sequence?  
	1. ????????????
11.  What is Polymorphism? And how Java implements it?  
	1. Polymorphism is a class can be extends another class and become another form.  
	2. Derived classes can give their own specific implementations to inherited methods without modifying the parent class methods 
12.  What is Encapsulation? How Java implements it? And why we need encapsulation?  
	1. Encapsulation is hiding the internal structures and showing the external working features  
	2. Class use setter and getters to work with variables in a class, but can not modify the variable directly  
	3. We need encapsulations to protect the class so other class can not know how this class works  
13.  What is Interface and what is abstract class? What are the differences between them?  
	1. Interface only have abstruct method while abstract class can have abstruct and non-abstruct one  
	2. Abstract class doesn't support multiple inheritance, while Interface does.  
	3. Abstract class can provide the implementation of interface, while interface can't provide the implementation of abstract class.  
14.  design a parking lot (put the code to codingQuestions/coding1 folder, )  
	1.  If you have no ability to design it, please find the solution in internet, then understand it, then type it.(Do not just copy and paste)
15.  What are Queue interface implementations and what are the differences and when to use what?   
	1. Queue need a concrete class to implemented with since Queue is an interface  
	2. Options are:  
		1. PriorityQueue - when you want to perform FIFO
		2. LinkedList  - when you want to modify the size 
16.  What is Runtime/unchecked exception? what is Compile/Checked Exception?  
	1. Runtime exception occur after the code execute
	2. Compile exeception occur when you compile the code.
17.  what is the difference between throw and throws?  
	1. Thorw can throw one type of exception while throws can throw multiple type of exception
18.  Run the below three pieces codes, Noticed the printed exceptions. why do we put the Null/Runtime exception before Exception?  
	1. Null/Run time exception is a specific exception while Exceptions includes a lot more exceptions
  
	