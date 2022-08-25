### explain how the below annotaitons specify the table in database?
- The annotation below shows that the column's data type is varchar, and the length is 255 at most; the column's default value is "John Snow."
```
@Column(columnDefinition = "varchar(255) default
'John Snow'")
private String name;
```

- The name of the column is "STUDENT_NAME," and the column length is 50(only if a string-valued column is used); since it is only used in the generated DDL, therefore, the resulting column would be generated as a VARCHAR(50) and trying to insert a longer string would result in an SQL error, the value inserted into the column must be a non-nullable and unique(no duplicate).
```
@Column(name="STUDENT_NAME", length=50,
nullable=false, unique=false)
private String studentName;
```



### What is the default column names of the table in database for @Column?
- the default column name should be the name of the variable below @Cloumn. For instance, the first column below is first_name, second is operation_system.
```
@Column
private String firstName;
@Column
private String operatingSystem;
```
### What are the layers in springboot application? what is the role of each layer?
- Presentation Layer 每 Authentication & Json Translation
  - The presentation layer is the top layer of the spring boot architecture. It consists of Views. i.e., the front-end part of the application. It handles the HTTP requests and performs authentication. It is responsible for converting the JSON field＊s parameter to Java Objects and vice-versa. Once it performs the authentication of the request it passes it to the next layer. i.e., the business layer.

- Business Layer 每 Business Logic, Validation & Authorization
  - The business layer contains all the business logic. It consists of services classes. It is responsible for validation and authorization.

- Persistence Layer 每 Storage Logic
  - The persistence layer contains all the database storage logic. It is responsible for converting business objects to the database row and vice-versa.

- Database Layer 每 Actual Database
  - The database layer contains all the databases such as MySql, MongoDB, etc. This layer can contain multiple databases. It is responsible for performing the CRUD operations.
### Describe the flow in all of the layers if an API is called by Postman.
1. Validator classes, view classes, and utility classes have been defined.
2. Spring Boot employs the same modules as Spring-like Spring MVC, Spring Data, and so on, but it has a different architecture. Spring Boot is the same as Spring MVC, but the one difference is that no DAO and DAOImpl classes are required.
3. Temporarily blocks an operation in order to create a data access layer and perform CRUD operations.
4. The client handles the HTTP requests (PUT or GET).
5. The controller receives the request, and the controller maps the request. Then, it passes the request to the service logic if necessary.
6. All business logic is implemented in the service layer. It performs the logic on the data that is mapped to JPA using model classes.
7. An error is not reported to the user when a JSP page is returned to the application from the controller.
### What is the application.properties? do you know application.yml?
- A common practice in Spring Boot project is to externalize the configuration through a properties file, YAML file, environment variable, or command-line arguments.
- Properties file application.properties is widely used for external configuration, however YAML file application.yml is gaining popularity due to its simplicity and JSON like format.

-  application.properties file is used to write the application-related property into that file. This file contains the different configuration which is required to run the application in a different environment, and each environment will have a different property defined by it. Inside the application properties file, we define every type of property like changing the port, database connectivity, connection to the eureka server, and many more. 
```
//change port number
server.port=8989

//To define the name of our application
spring.application.name = userservice

// Connecting with the MySQL Database
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
spring.datasource.username=springuser
spring.datasource.password=ThePassword
spring.datasource.driver-class-name =com.mysql.jdbc.Driver


//Connecting with the MongoDB Database
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=BookStore
```


- YAML stands for Yet Another Markup Language or YAML ain＊t markup language (a recursive acronym), which emphasizes that YAML is for data, not documents. YAML is a data serialization language that is often used for writing configuration files. So YAML configuration file in Spring Boot provides a very convenient syntax for storing logging configurations in a hierarchical format. The application.properties file is not that readable. So most of the time developers choose application.yml file over application.properties file. YAML is a superset of JSON, and as such is a very convenient format for specifying hierarchical configuration data. YAML is more readable and it is good for the developers to read/write configuration files. 

```
//change port number
server:
  port:
    8082


//To define the name of our application
spring:
  application:
    name: userservice



// Connecting with the MySQL Database
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    username: springuser
    url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
    password: ThePassword
  jpa:
    hibernate:
      ddl-auto: update


//Connecting with the MongoDB Database
spring:
  data:
    mongodb:
      database: BookStore
      port: '27017'
      host: localhost
```

### Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;
a. https://www.mongodb.com/compatibility/spring-boot
### In your redbook application, write the code for RUD APIs.
a. https://github.com/TAIsRich/springboot-redbook.git
       i. Branch: 02_post_RUD
b. you need to call the new APIs in your postman.