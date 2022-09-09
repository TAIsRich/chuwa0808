1. List all of the annotations you learned from class and homework to annotaitons.md

2. What is MVC pattern?

   MVC Pattern stands for Model-View-Controller Pattern. This pattern is used to separate application's concerns.

   - Model - Model represents an object or JAVA POJO carrying data. It can also have logic to update controller if its data changes.
   - View - View represents the visualization of the data that model contains.
   - Controller - Controller acts on both model and view. It controls the data flow into model object and updates the view whenever data changes. It keeps view and model separate.

3. What is Front-Controller?

   Front Controller is DispatcherServlet. DispatcherServlet abstracts away the following tedious and boilerplate tasks and focus on useful business logic:

   - Mapping an HTTP request to a certain processing method
   - Parsing of HTTP request data and headers into data transfer objects (DTOs)or
     domain objects
   - Model-view-controller interaction
   - Generation of responses from DTOs, domain objects, etc.

4. What is DispatcherServlet? please decribe how it works.

   1. Tomcat 收到Http Request，将request交给DispatcherServlet来处理
   2. DispatcherServlet 拿着该req去call HandlerMapper,
   3. HanlerMapper将会找到对应的Controller以及对应的method，并返回给
   dispactherServlet
   4. dispatcherServlet将call该Controller对应的method，此时会触发call service,
   repository and database.
   5. 然后结果(ModelAndView)再通过Controller返回。⼀般是返回view name, ⼀个字
   符串，⽐如list-customers. ⽽数据是要set到Model 中。
   6. dispatcerServlet拿着view name去call view Resolver,
   7. View Resolver会帮助我们找到view template, ⽐如list-customers.jsp
   8. 此时我们有了view template, 也有了数据model，则可以call View engine去帮助我
   们把数据放到view templatel⾥，然后转换成纯粹的HTML
   9. 该HTML就是前端显⽰的内容，最终返回给browser。

5. What is JSP and What is ModelAndView？(please google to have a basic knowlege).

   JSP is to create dynamic web pages. It is a mix of html and JavaScript codes. JavaScripts inside the file can help generate html files based on data from models.

   ModelAndView is a holder for both Model and View in the web MVC framework. These two classes are distinct; ModelAndView merely holds both to make it possible for a controller to return both model and view in a single return value.

6. Could you please google any other servlets

   ? can't find answers.

7. How many web server do you know? (Tomcat, Jetty, Jboss)

   Tomcat is the most commonly used and well known http servers. Jetty is good for chatting apps. Jboss is another one.

8. clone this repo, and run it in you local.