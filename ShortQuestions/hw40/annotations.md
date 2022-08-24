### Annotations:

__@Autowired:__ Spring provides annotation-based auto-wiring by providing @Autowired annotation. It is used to autowire spring bean on setter methods, instance variable, and constructor. When we use @Autowired annotation, the spring container auto-wires the bean by matching data type.
```{java}
class Car { 
    Engine engine; 
    @Autowired 
    Car(Engine engine) { 
  this.engine = engine; 
    } 
}
```
**@Controller:** The @Controller is a class-level annotation. It is a specialization of @Component. It marks a class as a web request handler. It is often used to serve web pages. By default, it returns a string that indicates which route to redirect. It is mostly used with @RequestMapping annotation.
@RequestMapping: It is used to map the web requests. It has many optional elements like consumes, header, method, name, params, path, produces, and value. We use it with the class as well as the method.
@Controller 
class VehicleController { 
@RequestMapping(value = "/vehicles/home", method = RequestMethod.GET) String home() { 
  return "home"; 
    } 
}

**@Service:** This is an alternative to @Component that specifies you intend to use the class as part of your service layer. It is also used at class level. It tells the Spring that class contains the business logic.

**@Repository:** It is a class-level annotation. This annotation marks a class as part of your data layer, for handling storage, retrieval, and search. The repository is a DAOs (Data Access Object) that access the database directly. The repository does all the operations related to the database.

**@SpringBootApplication:** it replaced three annotations @EnableAutoConfiguration, @ComponentScan, and @Configuration since version 1.2. It enables Java configuration and lets you use Spring Beans in the class. It enables component scanning and means controller classes and components you create can be discovered by the framework. It also enables Spring Boot’s autoconfiguration. 
@SpringBootApplication
class VehicleApplication {
```
    public static void main(String[] args) {
        SpringApplication.run(VehicleApplication.class, args);
    }
}
```
**@PostMapping:** It maps the HTTP POST requests on the specific handler method. It is used to create a web service endpoint that creates It is used. 
@PostMapping("/create") 
void createVehicle(@RequestBody Vehicle vehicle) { 
// ... 
}
**@RequestBody:** It is used to bind HTTP request with an object in a method parameter. Internally it uses HTTP MessageConverters to convert the body of the request. When we annotate a method parameter with @RequestBody, the Spring framework binds the incoming HTTP request body to that parameter.
**@ResponseBody:** It binds the method return value to the response body. It tells the Spring Boot Framework to serialize a return an object into JSON and XML format.
```
@ResponseBody 
@RequestMapping("/hello") 
String hello() { 
    return "Hello World!"; 
}
```
**@RestController:** It can be considered as a combination of @Controller and @ResponseBody annotations. It eliminates the need for annotating each method with @ResponseBody.
```
@RestController
class VehicleRestController {
    // ...
}
```
**@Entity Annotation:** This annotation specifies that the class is an entity: The entity name defaults to the name of the class. We can change its name using the name element.
```
@Entity(name="student")
public class Student {    
    // fields, getters and setters    
}
```
**@Table:** This annotation specifies the table in the database with which this entity is mapped. Schema name helps to distinguish one set of tables from another. If we do not use the @Table annotation, the name of the entity will be considered the name of the table.
**@Id:** This annotation specifies the primary key of the entity. 
**@GeneratedValue:** This annotation specifies the generation strategies for the values of primary keys. We can choose from four id generation strategies with the strategy element. The value can be AUTO, TABLE, SEQUENCE, or IDENTITY.
**@Column:** is used to specify the mapping between a basic entity attribute and the database table column. The @Column annotation has many elements such as name, length, nullable, and unique.
```
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", length=50, nullable=false, unique=false)
    private String firstName;

    // getters and setters
}
```
### 2. Explain how the below annotations specify the table in database?
```
The @Column annotation is used to specify the mapping between a basic entity attribute and the database table column. the default value will be present in the SQL table definition by using @columnDefinition. The name of the column is “STUDENT_NAME” and the length is 50 and the value in the column is not null and is not unique. 
```
### 3. What is the default column names of the table in database for @Column?

The default column name is the field name: firstname and operatingSystem.

### 4. What are the layers in springboot application? what is the role of each layer?

The four layers in Spring Boot are Presentation Layer, Business Layer, Persistence Layer, Database Layer. 
Presentation Layer: It interprets JSON and handles authentication and HTTP requests. After authentication, it enters the business layer for further processing.
Business Layer: As part of business logic, it manages all of the business decisions and performs the business validation and consent. For example, only admins may modify the customer’s account.
Persistence Layer: The persistence layer contains all the database storage logic. It is responsible for converting business objects to the database row and vice-versa.
Database Layer: The database layer contains all the databases such as mySQL, MongoDB, etc. This layer can contain multiple databases. It is responsible for performing the CRUD operations.

### 5. Describe the flow in all of the layers if an API is called by Postman.

The Client makes an HTTP request (GET, PUT, POST, etc.). The HTTP request is forwarded to the Controller. The controller maps the request. It processes the handles and calls the server logic. The business logic is performed in the Service layer. The spring boot performs all the logic over the data of the database which is mapped to the spring boot model class through Java Persistence Library (JPA). The JSP page is returned as Response from the controller.

### 6. What is the application.properties? do you know application.yml?
Spring Boot can access configurations set in an application.properties file, which uses a key-value format. Each line is a single configuration, so we need to express hierarchical data by using the same prefixes for our keys.
 ```
logging.file.name=myapplication.log 
bael.property=defaultValue 
#--- 
spring.config.activate.on-profile=dev 
spring.datasource.password=password 
spring.datasource.url=jdbc:h2:dev 
spring.datasource.username=SA 
bael.property=devValue
```
As well as Java properties files, we can also use YAML-based configuration files in our Spring Boot application. YAML is a convenient format for specifying hierarchical configuration data. We use three dashes to indicate the start of a new document:
```
logging: 
  file: 
name: myapplication.log 
--- 
spring: 
  config: 
activate: 
  on-profile: staging 
datasource: 
  password: 'password' 
  url: jdbc:h2:staging 
  username: SA 
bael: 
  property: 
    stagingValue
```

