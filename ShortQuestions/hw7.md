1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
    a. File name: annotations.md
    b. you'd better also list a code example under the annotations.

2. explain how the below annotaitons specify the table in database?
   1. @Column means this variable is mapped into a column in mysql database
   2. name inside the Column is the column name in database
   3. nullable = false means null is not allowed
   4. unique = false means don't need to be unique
   ```
     @Column(columnDefinition = "varchar(255) default 'John Snow'")
     private String name;
    
     @Column(name="STUDENT_NAME", length=50,nullable=false, unique=false)
     private String studentName;
   ```
3. What is the default column names of the table in database for @Column?
   1. should be the variable name if there is upper latter, transfer it to _
   2. in this example, it would be: first_name and operating_system
4. What are the layers in springboot application? what is the role of each layer?
   1. Presentation Layer – Authentication & Json Translation
   2. Business Layer – Business Logic, Validation & Authorization
   3. Persistence Layer – Storage Logic 
   4. Database Layer – Actual Database
   5. 
5. Describe the flow in all of the layers if an API is called by Postman.
   1. first, the presentation layer will handle authentication and json translation, they usually in a controller folder
   2. then, business layer will handle some business logic inside some service implementation class
   3. Persistence layer will provide a mapping between java object with database data
   4. Database layer will store or change the data in the actual database
6. What is the application.properties? do you know application.yml?
   1. application.properties is a configuration file which use key-value format to provide some basic information applicaiton will use, for example, the datasource configuration, the url, account and password.
   2. the functionality of application.yml is similar with application.properties, 
7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB; 
    a. https://www.mongodb.com/compatibility/spring-boot
8. In your redbook application, write the code for RUD APIs.
    a. https://github.com/TAIsRich/springboot-redbook.git
    i. Branch: 02_post_RUD
    b. you need to call the new APIs in your postman.
