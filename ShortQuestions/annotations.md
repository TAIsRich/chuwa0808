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
**@NamedQuery:** Specifies a static, named query in the Java Persistence query language. Query names are scoped to the persistence unit. The NamedQuery annotation can be applied to an entity or mapped superclass.
   * The following is an example of the definition of a named query in the Java Persistence query language:
   ```
    @NamedQuery(
            name="findAllCustomersWithName",
            query="SELECT c FROM Customer c WHERE c.name LIKE :custName"
    )
    ```
  * The following is an example of the use of a named query:
  ```
    @PersistenceContext
    public EntityManager em;
    ...
    customers = em.createNamedQuery("findAllCustomersWithName")
            .setParameter("custName", "Smith")
            .getResultList();
    ```
**@NameQueries:** annotation is used to define the multiple named queries.
    ```
    @NamedQueries(
    {
      @NamedQuery(name="findAllCustomer",query="SELECT c FROM Customer"),
      @NamedQuery(name="findCoustomerWithId",query="SELECT c FROM Customer c WHERE c.id=?1")
      @NamedQuery(name="findCustomerWithName",query="SELECT c FROM Customer c WHERE c.name = :name"
  }
  )
  ```
**@Query:** annotation can only be used to annotate repository interface methods. The call of the annotated methods will trigger the execution of the statement found in it. The @Query annotation is applied at the method-level in JpaRepository interfaces, and pertain to a single method. When we prefer to write our own queries. This is doable via the @Query annotation.

**@Transactional:** annotation which provides broad support for transaction management and allows developers to concentrate on business logic rather than worrying about data integrity in the event of system failures.
**@PersistenceContext**
