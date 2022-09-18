# Homework 15



1. List all of the annotations you learned from class and homework to annotaitons.md
   - See annotations.md
2. Briefly reading: https://www.techgeeknext.com/spring-boot/spring-aop-interview-questions
3. What is the Aspect Oriented Programming?
   - One of the key components of Spring Framework is the **Aspect oriented programming (AOP)** framework. Aspect-Oriented Programming entails breaking down program logic into distinct parts called so-called concerns. The functions that span multiple points of an application are called **cross-cutting concerns** and these cross-cutting concerns are conceptually separate from the application's business logic. There are various common good examples of aspects like logging, auditing, declarative transactions, security, caching, etc
   - https://www.tutorialspoint.com/spring/aop_with_spring.htm
4. What are the advantages and disadvantages of Spring AOP?
   - Disadvantages
     - A little difficult to debug the AOP based application code.
       - Since the business classes are advised behind the scene with aspects.
     - Since it uses proxy based AOP, only method level advising is supported, doesn’t support field level interception
       - So your join-point can be at method level not at field level in a class.
     - Only methods with public visibility will be advised
       - Methods with protected, private or default visibility will not be advised.
     - A little runtime overhead, but its negligible
       - The overhead is in nanoseconds.
     - Aspects cannot advise other Aspects - Not possible to have aspects to be the target of advice from other aspects.
       - Because once you mark one class as an aspect (either using XML or annotation), spring excludes it from being auto-proxied.
     - Local or internal method calls within an advised class doesn’t get intercepted by proxy, so advise method of the aspect does not get fired/invoked
       - For example, say you have a service class with two public methods saveUser() and savRole(), both are advised by a logging aspect (aspect for cross cutting concern - logging). If a client (Controller) invokes these methods individually, then the advice method of the loggingAspect gets invoked. But if you call saveRole() method from saveUser() method (a method call within the same class) then the advice method will not get invoked, though saveRole() method is captured by the AOP point-cut.
     - Is not for advising fine-grained objects (domain objects like pojo), it is best suitable for coarse grained objects (Service ...) due to performance.
       - This depends on your requirement. Say your application is not so big, and then you can very well use Spring AOP, because the performance impact due to Spring AOP will be negligible as the number of methods involved to serve a request will not be very high.
   - Advantage
     - It is non-invasive – not touching our code or business logic. plug and play like
       - Your service/domain classes get advised by the aspects (cross cutting concerns) without adding any Spring AOP related classes or interfaces into the service/domain classes.
       - Allows the developer to concentrate on the business code, instead the cross cutting concerns.
     - Its implemented in pure Java
       - No need for a special compilation unit, or a special class loader
     - It uses Spring’s IOC for dependency injection
       - Aspects can be configured as normal spring beans.
     - As any other AOP framework, it weaves cross cutting concerns into the classes, without making a call to the cross cutting concerns from those classes.
     - Centralize or modularize the cross cutting concerns (read meaning of cross cutting concerns above)
       - Easy to maintain and make changes to the aspects
       - Changes need to be made in one place.
       - In one of your classes you don’t want to have logging, it can easily be achieved by modifying the point cut in the respective aspect (logging aspect). So you need to make changes in only one place.
     - Provision to create aspects using schema based (XML configuration) or @AspectJ annotation based style.
     - Easy to configure
5. What is Aspect in Spring AOP?
   - Aspect: An aspect is **a class that implements enterprise application concerns that cut across multiple classes, such as transaction management**. 
6. What is Pointcut in Spring AOP?
   - Pointcut is **a set of one or more JoinPoint where an advice should be executed**. You can specify Pointcuts using expressions or patterns.
7. What is the Join point in Spring AOP?
   - Join Point: A join point is **a specific point in the application such as method execution, exception handling, changing object variable values, etc**. In Spring AOP a join point is always the execution of a method. Advice: Advices are actions taken for a particular join point.
8. What does it mean by Advice and its types in Spring AOP?
   - Advice: Advices are **actions taken for a particular join point**.
   - Based on the execution strategy of advice, they are of the following types.
     1. **Before Advice**: These advices runs before the execution of join point methods. We can use `@Before` annotation to mark an advice type as Before advice.
     2. **After (finally) Advice**: An advice that gets executed after the join point method finishes executing, whether normally or by throwing an exception. We can create after advice using `@After` annotation.
     3. **After Returning Advice**: Sometimes we want advice methods to execute only if the join point method executes normally. We can use `@AfterReturning` annotation to mark a method as after returning advice.
     4. **After Throwing Advice**: This advice gets executed only when join point method throws exception, we can use it to rollback the transaction declaratively. We use `@AfterThrowing` annotation for this type of advice.
     5. **Around Advice**: This is the most important and powerful advice. This advice surrounds the join point method and we can also choose whether to execute the join point method or not. We can write advice code that gets executed before and after the execution of the join point method. It is the responsibility of around advice to invoke the join point method and return values if the method is returning something. We use `@Around` annotation to create around advice methods.
9. What is Spring AOP Proxy?
   - AOP proxy: **an object created by the AOP framework in order to implement the aspect contracts** (advise method executions and so on). 
10. Briefly Reading: https://www.javainuse.com/spring/sprbatch_interview
11. When to use Spring Batch?
    - Spring Batch can be used in both simple use cases (such as **reading a file into a database or running a stored procedure**) as well as complex, high volume use cases (such as moving high volumes of data between databases, transforming it, and so on).
12. How Spring Batch works?
    - https://spring.io/guides/gs/batch-processing/
13. How can we schedule a Spring Batch Job?
    - You can configure Spring Batch Jobs in two different ways: **Using the @EnableScheduling annotation**. Creating a method annotated with @Scheduled and providing recurrence details with the job. Then add the job execution logic inside this method.