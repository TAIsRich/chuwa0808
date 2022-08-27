1.  List all of the new annotations to your annotaitons.md and explain its role.
2.  how do you do the debug?
Define where the program needs to be stopped. This is done using breakpoints. Breakpoints are special markers, which represent places and/or conditions when the debugger needs to step in and freeze the program state. A program, which has been frozen by the debugger is referred to as suspended.

The alternative to using breakpoints is manually suspending the program at an arbitrary moment, however this method imposes some limitations on the debugger functionality and doesn't allow for much precision as to when to suspend the program.

Run your program in debug mode.

Just like with regular running of the program, you can run multiple debugging sessions at the same time.

After the program has been suspended, use the debugger to get the information about the state of the program and how it changes during running.

The debugger provides you with the information about variable values, the current state of the threads, breakdown of objects that are currently in the heap, and so on. It also allows you to test your program in various conditions by throwing exceptions (for example, to check how they are handled) or running arbitrary code right in the middle of the program execution.

While these tools let you examine the program state at a particular instant, the stepping feature gives you the control over step-by-step execution of the program. By combining the tools you can deduce where the bug is coming from and test your program for robustness.

When you have determined what needs to be fixed, you can do it without terminating the session. For this purpose, IntelliJ IDEA provides a functionality allowing you to adjust and reload pieces of your code on the fly. This approach is covered in the Reload modified classes topic.
3.  What is DTO, VO, Payload, DO?

Data transfer object (DTO), formerly known as value objects or VO, is a design pattern used to transfer data between software application subsystems. DTOs are often used in conjunction with data access objects to retrieve data from a database.

Payload type that can be attached to a given constraint declaration. Payloads are typically used to carry on metadata information consumed by a validation client. Use of payloads is not considered portable.

4.  What is @JsonProperty("description_yyds")?
The @JsonProperty annotation is used to map property names with JSON keys during serialization and deserialization. By default, if you try to serialize a POJO, the generated JSON will have keys mapped to the fields of the POJO.

5.  do you know what is jackson?
Jackson is a very popular and efficient java based library to serialize or map java objects to JSON and vice versa.

6.  What is spring-boot-stater? 
Spring Boot Starters are dependency descriptors that can be added under the <dependencies> section in pom.xml. There are around 50+ Spring Boot Starters for different Spring and related technologies. These starters give all the dependencies under a single name. For example, if you want to use Spring Data JPA for database access, you can include spring-boot-starter-data-jpa dependency. 

The advantages of using Starters are as follows:

Increase productivity by decreasing the Configuration time for developers.
Managing the POM is easier since the number of dependencies to be added is decreased.
Tested, Production-ready, and supported dependency configurations.
No need to remember the name and version of the dependencies.

a. what dependecies in the below starter? do you know any starters?
spring-boot-web, spring-boot-starter-data-jpa, spring-boot-starter-test

7. do you know  @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
the annotation is used to map web requests to Spring Controller methods.
/users is url , RequestMethod.POST is post method 

@RequestMapping(value = "/users", method = RequestMethod.POST)
@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)

8.  What is ResponseEntity? why do we need it?
ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response. If we want to use it, we have to return it from the endpoint; Spring takes care of the rest. ResponseEntity is a generic type.

Furthermore, ResponseEntity provides two nested builder interfaces: HeadersBuilder and its subinterface, BodyBuilder. Therefore, we can access their capabilities through the static methods of ResponseEntity.

To set the body, status, and headers of an HTTP response.

9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
ResultSet interface represents the result set of a database query. A ResultSet object maintains a cursor that points to the current row in the result set. The term "result set" refers to the row and column data contained in a ResultSet object.

Steps For Connectivity Between Java Program and Database
Import the Packages
Load the drivers using the forName() method 
Register the drivers using DriverManager 
Establish a connection using the Connection class object
Create a statement
Execute the query
Close the connections

10. What is the ORM framework?
Object–relational mapping (ORM, O/RM, and O/R mapping tool) in computer science is a programming technique for converting data between type systems using object-oriented programming languages. This creates, in effect, a "virtual object database" that can be used from within the programming language

11. Learn how to use ObjectMapper by this example.
a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-cor
e/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java

12. What is the serialization and desrialization?
a. https://hazelcast.com/glossary/serialization/
Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory. This mechanism is used to persist the object.

13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
    int[] array = {20, 3, 78, 9, 6, 53, 73, 99, 24, 32};        
    double ans = Arrays.stream(array).average().orElse(Double.NaN);
    System.out.println(ans);

14. 抄写，https://github.com/TAIsRich/springboot-
redbook/tree/03_post_pageable，你也可以像我一样分branch添加新代码。

15. (Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comm
ent你也可以像我一样分branch添加新代码。

16. (Optional) Try to write the CRUD api for a new application Cassandra-Blog
a. spring 提供了相关dependency,(https://start.spring.io/)
i.  Spring Data for Apache Cassandra
b. Cassandra十分流行，且面试问的多。
FoodOutlet foodOutlet = 
objectMapper.readValue(resBody, FoodOutlet.class);
String s = 
objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree() // learn how to use it?
1
2