##HW 7
### 1. create a file to list all of the annotaitons you learned and known, and explain the
usage and how do you understand it. you need to update it when you learn a new
annotation. Please organize those annotations well, like annotations used by
entity, annotations used by controller.
a. File name: annotations.md
b. you'd better also list a code example under the annotations.

### 2. explain how the below annotaitons specify the table in database?
@Column(columnDefinition = "varchar(255) default
'John Snow'")
private String name;

@Column(name="STUDENT_NAME", length=50,
nullable=false, unique=false)
private String studentName;

```
first one is the column type is varchar(255), the default name is John Snow
second one is the column name is STUDENT_NAME, and the length is 50, it can be null, it can have same name
```

### 3. What is the default column names of the table in database for @Column?
```
It is the field name defined in entity class, it will change the capital character to “_” in column name
```

### 4. What are the layers in springboot application? what is the role of each layer?
```
The spring boot consists of the following four layers:
1.	Presentation Layer – Authentication & Json Translation
2.	Business Layer – Business Logic, Validation & Authorization
3.	Persistence Layer – Storage Logic
4.	Database Layer – Actual Database

1. Presentation Layer
The presentation layer is the top layer of the spring boot architecture. It consists of Views. i.e., the front-end part of the application. It handles the HTTP requests and performs authentication. It is responsible for converting the JSON field’s parameter to Java Objects and vice-versa. Once it performs the authentication of the request it passes it to the next layer. i.e., the business layer.
2. Business Layer
The business layer contains all the business logic. It consists of services classes. It is responsible for validation and authorization.
3. Persistence Layer
The persistence layer contains all the database storage logic. It is responsible for converting business objects to the database row and vice-versa.
4. Database Layer
The database layer contains all the databases such as MySql, MongoDB, etc. This layer can contain multiple databases. It is responsible for performing the CRUD operations.
```

### 5. Describe the flow in all of the layers if an API is called by Postman.
```
 

```

### 6. What is the application.properties? do you know application.yml?
```
So in a spring boot application, application.properties file is used to write the application-related property into that file. This file contains the different configuration which is required to run the application in a different environment, and each environment will have a different property defined by it. Inside the application properties file, we define every type of property like changing the port, database connectivity, connection to the eureka server, and many more. Now let’s see some examples for better understanding.

Spring Boot supports YAML based properties configurations to run the application. Instead of application.properties, we can use application.yml file. This YAML file also should be kept inside the classpath. The sample application.yml file is given below −
spring:
   application:
      name: demoservice
   server:
port: 9090

```

### 7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog,
change database to MongoDB;
a. https://www.mongodb.com/compatibility/spring-boot

### 8. In your redbook application, write the code for RUD APIs.
a. https://github.com/TAIsRich/springboot-redbook.git
i. Branch: 02_post_RUD
b. you need to call the new APIs in your postman.
@Column(columnDefinition = "varchar(255) default
'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50,
nullable=false, unique=false)
private String studentName;
1
2
3
4
5
@Column
private String firstName;
@Column
private String operatingSystem;
1
2
3
4
c. You need to type it line by line and try your best to understand it. DO
NOT COPY PASTE
