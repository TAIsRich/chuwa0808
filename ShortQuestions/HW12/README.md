# Homework 12

1. List all of the annotations you learned from class and homework to 
   annotaitons.md

   - See annotations.md

2. What is Spring and Springboot? What is the benfits of using Srpingboot?

   - Spring is an open-source lightweight framework that allows Java EE 7 developers to build simple, reliable, and scalable enterprise applications. This framework mainly focuses on providing various ways to help you manage your business objects. It made the development of Web applications much easier than compared to classic Java frameworks and Application Programming Interfaces (APIs), such as Java database connectivity (JDBC), JavaServer Pages(JSP), and Java Servlet. This framework uses various new techniques such as Aspect-Oriented Programming (AOP), Plain Old Java Object (POJO), and dependency injection (DI), to develop enterprise applications.

     The **Spring framework** can be considered as a collection of sub-frameworks, also called layers, such as Spring AOP. Spring Object-Relational Mapping (Spring ORM). Spring Web Flow, and Spring Web MVC. You can use any of these modules separately while constructing a Web application. The modules may also be grouped together to provide better functionalities in a Web application.

   - Spring Boot is built on top of the conventional spring framework. So, it provides all the features of spring and is yet easier to use than spring. Spring Boot is a microservice-based framework and making a production-ready application in very less time. In Spring Boot everything is auto-configured. We just need to use proper configuration for utilizing a particular functionality. Spring Boot is very useful if we want to develop REST API.

   - https://www.geeksforgeeks.org/difference-between-spring-and-spring-boot/#:~:text=Spring%20is%20an%20open%2Dsource%20lightweight%20framework%20widely%20used%20to,Spring%20Framework%20is%20dependency%20injection.

3. What is IOC and What is DI?

   - **Inversion of Control** (IoC) is the mechanism to achieve loose-coupling between Object dependencies. To achieve loose coupling and dynamic binding of the objects at runtime, the objects define their dependencies that are being injected by other assembler objects. Spring IoC container is the program that injects dependencies into an object and makes it ready for our use.

   - Dependency Injection design pattern allows us to remove the hard-coded dependencies and make our application loosely coupled, extendable and maintainable. We can implement the dependency injection pattern to move the dependency resolution from compile-time to runtime.

     Some of the benefits of using Dependency Injection are Separation of Concerns, Boilerplate Code reduction, Configurable components, and easy unit testing.

   - https://www.digitalocean.com/community/tutorials/spring-interview-questions-and-answers

4. What is @CompnonentScan?

   -  **@ComponentScan which is used along with the @Configuration annotation to specify the packages that we want to be scanned.** @ComponentScan without arguments tells Spring to scan the current package and all of its sub-packages.  So let’s understand @ComponentScan Annotation with an example project.

5. How to define which package spring need to scan in xml and annotaiton? 

   - Spring framework has the functionality to auto-detect or auto scan the bean’s classes for injection using `@Component` annotation. `@Component` is a generic stereotype for any Spring-managed component. In the most of the previous example, we use the *XML* to specify the configuration metadata that produces each BeanDefinition within the Spring container manually.

     For auto scanning of beans, we need to add the context namespace schema to the root beans tag and scan the package. 

   - https://websparrow.org/spring/spring5-auto-scanning-using-component-annotation-and-xml-configuration

6. What is @SpringbootApplication?

   - @SpringBootApplication annotation indicates a configuration class that declares one or more [@Bean ](http://www.javaguides.net/2018/09/spring-bean-annotation-with-example.html)methods and also triggers auto-configuration and component scanning. This is a convenience annotation that is equivalent to declaring *[@Configuration](http://www.javaguides.net/2018/09/spring-configuration-annotation-with-example.html), [@EnableAutoConfiguration](http://www.javaguides.net/2018/09/spring-boot-enableautoconfiguration-annotation-with-example.html), and @ComponentScan*

7. How many ways wo can define a bean?

   - There are **three different ways** in which you can define a Spring bean:
     - annotating your class with the stereotype *@Component* annotation (or its derivatives)
     - writing a bean factory method annotated with the *@Bean* annotation in a custom Java configuration class
     - declaring a bean definition in an XML configuration file
     - http://dolszewski.com/spring/spring-bean/#:~:text=There%20are%20three%20different%20ways,in%20an%20XML%20configuration%20file

8. What is default bean name for @Component and @Bean?

   - @Bean, The name of this bean. Default bean name is method name.
   - @Component, the default bean name is the class name after converting the first character to lower case.
   - https://www.concretepage.com/spring-5/spring-bean-annotation#:~:text=%40Bean%20within%20%40Configuration%20Classes,-We%20can%20create&text=Find%20the%20code%20to%20use,create%20bean%20of%20these%20classes.&text=The%20default%20bean%20name%20will,second%20bean%20name%20is%20getBeanB%20.

9. What is the difference between @component and @service,@repository?

   - @Component is a generic stereotype for any Spring-managed component. **@Service annotates classes at the service layer.** **@Repository annotates classes at the persistence layer, which will act as a database repository**.

10. How many annotaitons we can use to inject the bean?

    - @Autowired
    - @Resource
    - @Inject

11. Tell me the three types to do dependency injection(How can we inject the beans 
    in Spring)? Which way is better and why?

    - Constructor Injection
      Setter Injection
      Field Injection
    - **Constructor injection** should be the main way that you do dependency injection. It's simple: A class needs something and thus asks for it before it can even be constructed.

12. If we have multiple beans for one type, how to set one is primary? and how to let 
    the spring to pick one bean to inject if no primay.

    - @Primary
    - @Qualifier

13. What is the difference between BeanFactory and ApplicationContext in Spring?

    - he Spring Framework comes with two IOC containers – *[BeanFactory](https://www.baeldung.com/spring-beanfactory)* and *[ApplicationContext](https://www.baeldung.com/spring-classpathxmlapplicationcontext)*. The *BeanFactory* is the most basic version of IOC containers, and the *ApplicationContext* extends the features of *BeanFactory*.
    - ***BeanFactory\* loads beans on-demand, while \*ApplicationContext\* loads all beans at startup**. Thus, *BeanFactory* is lightweight as compared to *ApplicationContext*.
    - Lazy loading with BeanFactory.
    - Eager loading with ApplicationContext.
    - https://www.baeldung.com/spring-beanfactory-vs-applicationcontext

14. What is the Scope of a Bean? and list the examples for each scope.

    - Bean scope decides which type of bean instance should be returned to the caller from the Spring container. Scopes are defined using @Scope annotation.

    - The latest version of the Spring framework defines 6 types of scopes:

      - singleton
      - prototype
      - request
      - session
      - application
      - websocket

    - Singleton scope

      - ```java
        @Bean
        @Scope("singleton")
        public Person personSingleton() {
            return new Person();
        }
        ```

    - Prototype Scope

      - ```java
        @Bean
        @Scope("prototype")
        public Person personPrototype() {
            return new Person();
        }
        ```

    - Request scope

      - ```java
        @Bean
        @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
        public HelloMessageGenerator requestScopedBean() {
            return new HelloMessageGenerator();
        }
        ```
        
      - ```java
        @Bean
        @SessionScope
        public HelloMessageGenerator sessionScopedBean() {
            return new HelloMessageGenerator();
        }
        ```
      
    - session scope

      - ```java
        @Bean
        @SessionScope
        public HelloMessageGenerator sessionScopedBean() {
            return new HelloMessageGenerator();
        }
        ```
      
      - ```java
        @Bean
        @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
        public HelloMessageGenerator sessionScopedBean() {
            return new HelloMessageGenerator();
        }
        ```
      
    - Application scope

      - ```java
        @Bean
        @ApplicationScope
        public HelloMessageGenerator applicationScopedBean() {
            return new HelloMessageGenerator();
        }
        ```
      
    - Websocket scope

      - ```java
        @Bean
        @Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
        public HelloMessageGenerator websocketScopedBean() {
            return new HelloMessageGenerator();
        }
        ```

15. Configure a bean using xml. If bean has parameters/dependencies, how can we 
    configure the bean? (you can google the tutorial how to configure beans in xml, 
    and feel free to ask me any quesitons if you don't understand. it is a little bit old, 
    I am not sure if I need to exaplain it in class)

    - ```java
      <beans .....>
          <import resource="common/Spring-Common.xml"/>
          <import resource="connection/Spring-Connection.xml"/>
          <import resource="module/Spring-Module.xml"/>
        	<bean id="user" class="cn.tedu.spring.User">
              <property name="name" value="Mike"/>
              <property name="from" value="Beijing"/>
              <property name="age" value="26"/>
              <property name="regTime" ref="now"/>
          </bean>
      </beans>
      ```