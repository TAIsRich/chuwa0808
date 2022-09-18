# Homework 16



1. List all of the new learned annotations to your annotations.md

2. what is selenium(YouTube)?

   - Selenium is **an open-source tool that automates web browsers**. It provides a single interface that lets you write test scripts in programming languages like Ruby, Java, NodeJS, PHP, Perl, Python, and C#, among others.

3. what is cucumber(youtueb)?

   - **Cucumber** is a testing tool that supports Behavior Driven Development (BDD). It offers a way to write tests that anybody can understand, regardless of their technical knowledge. 

4. what is JMeter(youtube)?

   - The Apache JMeter is an open-source, purely Java-based software. The software is used **to perform performance testing, functional testing, and load testing of web applications**. It is used to test load testing functional behavior and measuring performance.

5. what is unit-test?

   - **Unit Testing** is a type of software testing where individual units or components of a software are tested. The purpose is to validate that each unit of the software code performs as expected. Unit Testing is done during the development (coding phase) of an application by the developers. Unit Tests isolate a section of code and verify its correctness. A unit may be an individual function, method, procedure, module, or object.

6. What is the lifecircle of Junit?

   - The complete lifecycle of a test case can be seen in **three phases** with the help of annotations.
     1. **Setup**: This phase puts the the test infrastructure in place. JUnit provides *class level setup* (*[@BeforeAll](https://howtodoinjava.com/junit5/before-all-annotation-example/)*) and *method level setup* (*[@BeforeEach](https://howtodoinjava.com/junit5/before-each-annotation-example/)*). Generally, heavy objects like databse comnections are created in class level setup while lightweight objects like test objects are reset in the method level setup.
     2. **Test Execution**: In this phase, the *test execution and assertion* happen. The execution result will signify a success or failure.
     3. **Cleanup**: This phase is used to cleanup the test infrastructure setup in the first phase. Just like setup, teardown also happen at *class level ([@AfterAll](https://howtodoinjava.com/junit5/after-all-annotation-example/))* and *method level ([@AfterEach](https://howtodoinjava.com/junit5/after-each-annotation-example/))*.

7. Is @BeforeAll method should be Class level(static)?

   - @BeforeAll and @AfterAll annotations – clear by their name – should be called only once in the entire tests execution cycle. So they must be declared `static`.
   - https://howtodoinjava.com/junit5/junit-5-test-lifecycle/

8. What is Mockito? and what is its limitations?

   - Mockito is **a java based mocking framework, used in conjunction with other testing frameworks such as JUnit and TestNG**. It internally uses Java Reflection API and allows to create objects of a service. A mock object returns a dummy data and avoids external dependencies.
   - **Some limitations of the mockito are,**
     - It cannot mock constructors or static methods.
     - It requires Java version 6 plus to run.
     - It also cannot mock equals(), hashCode() methods.
     - VM mocking is only possible on VMs that are supported by Objenesis.

9. What is @Mock and what is @InjectMocks?

   - **@InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock annotations into this instance**. @Mock is used to create mocks that are needed to support the testing of the class to be tested. @InjectMocks is used to create class instances that need to be tested in the test class.

10. What is the stubbing?

    - A stub is **a small piece of code that takes the place of another component during testing**. The benefit of using a stub is that it returns consistent results, making the test easier to write. And you can run tests even if the other components are not working yet.

11. what is Mockito ArgumentMatchers

    - Argument matchers are **mainly used for performing flexible verification and stubbing in Mockito**. It extends ArgumentMatchers class to access all the matcher functions. Mockito uses equal() as a legacy method for verification and matching of argument values.

12. what is Hamcrest Matchers

    - Hamcrest is **a framework that assists writing software tests in the Java programming language**. It supports creating customized assertion matchers ('Hamcrest' is an anagram of 'matchers'), allowing match rules to be defined declaratively. These matchers have uses in unit testing frameworks such as JUnit and jMock.

13. do you know @spy? what is difference between @spy and @Mock?

    - In Mockito, spy() method is used for **creating spy objects**. It allows us to call the normal methods of the real object.

    - Both can be used to mock methods or fields. The difference is that in mock, you are creating a complete mock or fake object while in spy, there is the real object and you just spying or stubbing specific methods of it.
    - When using **mock objects**, the default behavior of the method when not stub is **do nothing**. Simple means, if its a void method, then it will do nothing when you call the method or if its a method with a return then it may return null, empty or the default value.
    - While in spy objects, of course, since it is a real method, when you are not stubbing the method, then it will call the real method behavior. If you want to change and mock the method, then you need to stub it.

14. briefly reading this articles
    a. https://www.javatpoint.com/examples-of-mockito-and-junit-in-eclipse-ide
    b. https://www.javatpoint.com/junit-tutorial
    c.  https://www.javatpoint.com/testng-tutorial
    d.  https://www.javatpoint.com/jmeter-tutorial