# Homework 13



1. List all of the annotations you learned from class and homework to annotaitons.md
   - See annotaions.md
2. What is MVC pattern?
   - The Spring Web MVC framework provides Model-View-Controller (MVC) architecture and ready components that can be used to develop flexible and loosely coupled web applications. The MVC pattern results in separating the different aspects of the application (input logic, business logic, and UI logic), while providing a loose coupling between these elements.
     - The **Model** encapsulates the application data and in general they will consist of POJO.
     - The **View** is responsible for rendering the model data and in general it generates HTML output that the client's browser can interpret.
     - The **Controller** is responsible for processing user requests and building an appropriate model and passes it to the view for rendering.
3. What is Front-Controller? 
   - A front controller is defined as **a controller that handles all requests for a Web Application**. DispatcherServlet servlet is the front controller in Spring MVC that intercepts every request and then dispatches requests to an appropriate controller.
4. What is DispatcherServlet? please decribe how it works.
   - DispatcherServlet abstracts away the following tedious and boilerplate tasks and focus on 
     useful business logic:
     - Mapping an HTTP request to a certain processing method
     - Parsing of HTTP request data and headers into data transfer objects (DTOs)or 
       domain objects
     - Model-view-controller interaction
     - Generation of responses from DTOs, domain objects, etc.
   - 1. Tomcat 收到Http Request，将request交给DispatcherServlet来处理
     2. DispatcherServlet 拿着该req去call HandlerMapper, 
     3. HanlerMapper将会找到对应的Controller以及对应的method，并返回给
        dispactherServlet
     4. dispatcherServlet将call该Controller对应的method，此时会触发call service, 
        repository and database. 
     5. 然后结果(ModelAndView)再通过Controller返回。一般是返回view name, 一个字
        符串，比如list-customers. 而数据是要set到Model 中。
     6. dispatcerServlet拿着view name去call view Resolver, 
     7. View Resolver会帮助我们找到view template, 比如list-customers.jsp
     8. 此时我们有了view template, 也有了数据model，则可以call View engine去帮助我
        们把数据放到view templatel里，然后转换成纯粹的HTML
     9. 该HTML就是前端显示的内容，最终返回给browser。
5. What is JSP and What is ModelAndView？(please google to have a basic 
   knowlege)
   - JSP
     - It stands for **Java Server Pages**.
     - It is a server side technology.
     - It is used for creating web application.
     - It is used to create dynamic web content.
     - In this JSP tags are used to insert JAVA code into HTML pages.
     - It is an advanced version of Servlet Technology.
     - It is a Web based technology helps us to create dynamic and platform independent web pages.
     - In this, Java code can be inserted in HTML/ XML pages or both.
     - JSP is first converted into servlet by JSP container before processing the client’s request.
   - ModelAndView
     - ModelAndView is **a holder for both Model and View in the web MVC framework**. These two classes are distinct; ModelAndView merely holds both to make it possible for a controller to return both model and view in a single return value. The view is resolved by a ViewResolver object; the model is data stored in a Map .
6. Could you please google any other servlets(理解多少是多少，不要花太多时间，
   知道servlet的名字就行。)
   - **Facelets** JSF
7. How many web server do you know? (Tomcat, Jetty, Jboss)
   - Apache web server
   - IIS web server
   - Nginx web server
   - LiteSpeed web server
8. clone this repo, and run it in you local.
   	- a. https://github.com/TAIsRich/springmvc5-demo
    - b. Notice that you need to configure the Tomcat by yourself. tutorial in 
      the slides.
    - c.  find out the APIs in controlelr and call some APIs, In slides, I also list 
      some API.
   	- d.  remeber to create a database for this project
   	- e.  all details in the slides.