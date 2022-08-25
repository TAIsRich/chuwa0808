### 2. explain how the below annotaitons specify the table in database?
```java
@Column(columnDefinition = "varchar(255) default
'John Snow'")
private String name;
@Column(name="STUDENT_NAME", length=50,
nullable=false, unique=false)
private String studentName;
```
* `name`: the data type is varchar(255), the default value of `name` is 'John Snow'.
* `studentName`: the column's name is "STUDENT_NAME", the maximum length of the String is 50. Database will reject any values that are more than 50 characters long. The value can be null and duplicated.

### 3. What is the default column names of the table in database for @Column?
```java
@Column
private String firstName;

@Column
private String operatingSystem;
```
* `firstName`: first_name
* `operatingSystem`: operating_system

### 4. What are the layers in springboot application? what is the role of each layer?
1. Postman Client:
    * GET,POST,PUT,DELETE
2. Controller:
    * API Layer
3. Service
    * Business Logic
4. DAO
    * Persistence Logic
5. DB
    * Saving Data

### 6. What is the application.properties? do you know application.yml?
* application. properties is a key-value repository resource that is widely used for configuration properties and runtime variables. Those are the most common uses of the application. properties file.
* YAML stands for Yet Another Markup Language or YAML ain’t markup language (a recursive acronym), which emphasizes that YAML is for data, not documents. YAML is a data serialization language that is often used for writing configuration files. So YAML configuration file in Spring Boot provides a very convenient syntax for storing logging configurations in a hierarchical format. The application.properties file is not that readable. So most of the time developers choose application.yml file over application.properties file. YAML is a superset of JSON, and as such is a very convenient format for specifying hierarchical configuration data. YAML is more readable and it is good for the developers to read/write configuration files. 