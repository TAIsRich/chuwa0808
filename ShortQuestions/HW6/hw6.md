1.create a file to list all of the annotaitons you learned and known, and explain the 
usage and how do you understand it. you need to update it when you learn a new 
annotation. Please organize those annotations well, like annotations used by 
entity, annotations used by controller.
a. File name: annotations.md

b. you'd better also list a code example under the annotations.

2.  explain how the below annotaitons specify the table in database?
It means name colum's data tpye is varchar(225) and default value is 'john snow'
It means colum name is STUDENT_NAME , length limit is 50,  default can't be null and have to has value, this colum is unique and can't repeat

3.  What is the default column names of the table in database for  @Column?
first_name operating_system

4.  What are the layers in springboot application? what is the role of each layer?
(1) Presentation Layer(controller)

The presentation layer is the top layer of the spring boot architecture. It consists of Views. i.e., the front-end part of the application. It handles the HTTP requests and performs authentication. It is responsible for converting the JSON field’s parameter to Java Objects and vice-versa. Once it performs the authentication of the request it passes it to the next layer. i.e., the business layer.

(2) Business Layer(service)

The business layer contains all the business logic. It consists of services classes. It is responsible for validation and authorization.

(3) Persistence Layer(dao)

The persistence layer contains all the database storage logic. It is responsible for converting business objects to the database row and vice-versa.

(4) Database Layer(entity)

The database layer contains all the databases such as MySql, MongoDB, etc. This layer can contain multiple databases. It is responsible for performing the CRUD operations.


5.  Describe the flow in all of the layers if an API is called by Postman.

The Client makes an HTTP request(GET, PUT, POST, etc.)
The HTTP request is forwarded to the Controller. The controller maps the request. It processes the handles and calls the server logic.
The business logic is performed in the Service layer. The spring boot performs all the logic over the data of the database which is mapped to the spring boot model class through Java Persistence Library(JPA).
The JSP page is returned as Response from the controller.

6.  What is the application.properties? do you know application.yml?
Essentially, application.properties is a key-value repository resource that is widely used for configuration properties and runtime variables. Those are the most common uses of the application.properties file. 

File: YAML is a configuration language. Languages like Python, Ruby, Java heavily use it for configuring the various properties while developing the applications. If you have ever used Elastic Search instance and MongoDB database, both of these applications use YAML(. yml) as their default configuration format

7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, 
change database to MongoDB;
a. https://www.mongodb.com/compatibility/spring-boot
8.  In your redbook application, write the code for RUD APIs.
a. https://github.com/TAIsRich/springboot-redbook.git
