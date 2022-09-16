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

**@PreAuthorize("hasRole('ADMIN')"):** @PreAuthorize is the most useful annotation that decides whether a method can actually be invoked or not based on user’s role. hasRole() method returns true if the current principal has the specified role. @PreAuthorize annotation checks the given expression before entering the method, whereas the @PostAuthorize annotation verifies it after the execution of the method and could alter the result.

**@Value** This annotation can be used for injecting values into fields in Spring-managed beans, and it can be applied at the field or constructor/method parameter level. Using the @PropertySource annotation allows us to work with values from properties files with the @Value annotation. In the following example, we get Value got from the file assigned to the field:
```
@Value("${value.from.file}")
private String valueFromFile;
```

**@Configuration:** indicates that the class has @Bean definition methods. So Spring container can process the class and generate Spring Beans to be used in the application. This annotation is part of the spring core framework. 
```
package BeanAnnotation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollegeConfig {

    // Using Bean annotation to create
    // College class Bean
    @Bean
    // Here the method name is the
    // bean id/bean name
    public College collegeBean() {
    
        // Return the College object
        return new College();
    }
}
```
**@EnableWebSecurity:** The Spring Security @EnableWebSecurity annotation is annotated at class level with @Configuration annotation to enable web securities in our application defined by WebSecurityConfigurer implementations. The WebSecurityConfigurerAdapter is the implementation class of WebSecurityConfigurer interface. The @EnableWebSecurity enables the web securities defined by WebSecurityConfigurerAdapter automatically. To override web securities defined by WebSecurityConfigurerAdapter in our Java configuration class, we need to extend this class and override its methods.
```
package com.concretepage.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
           .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
           .antMatchers("/user/**").access("hasRole('ROLE_USER')")
           .and().formLogin();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("ram").password("{noop}ram123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("ravan").password("{noop}ravan123").roles("USER");
    }
} 
```
**@EnableGlobalMethodSecurity(prePostEnabled = true):** EnableGlobalMethodSecurity provides AOP security on methods. Some of the annotations that it provides are PreAuthorize, PostAuthorize. EnableWebSecurity will provide configuration via HttpSecurity. It's the configuration you could find with <http></http> tag in xml configuration, it allows you to configure your access based on urls patterns, the authentication endpoints, handlers etc...

**@Before:** Run before the method execution
**@After:** Run after the method returned a result
**@AfterReturning:** Run after the method returned a result, intercept the returned result as well.
**@AfterThrowing:** Run after the method throws an exception
**@Around:** Run around the method execution, combine all three advices above. @Aspect - indicate this is a aop class
**@Component:** This annotation mark the beans as Spring’s managed components

**@Api:** Marks a class as a Swagger resource.
**@ApiImplicitParam:** Represents a single parameter in an API Operation.
**ApiImplicitParams:** A wrapper to allow a list of multiple ApiImplicitParam objects. 
**@ApiModel:** Provides additional information about Swagger models.
**@ApiModelProperty:** Adds and manipulates data of a model property.
**@ApiOperation:** Describes an operation or typically a HTTP method against a specific path.
**@ApiParam:** Adds additional meta-data for operation parameters.
**@ApiResponse:** Describes a possible response of an operation.
**@ApiResponses:** A wrapper to allow a list of multiple ApiResponse objects.
**@AuthorizationScope:** Describes an OAuth2 authorization scope.
**@Extension:** An optionally named list of extension properties.
**@ExtensionProperty:** A name/value property within a Swagger extension.
**@ExternalDocs:** Represents an external documentation description.

**@Scheduled:** is a method-level annotation applied at runtime to mark the method to be scheduled. It takes one attribute from cron, fixedDelay, or fixedRate for specifying the schedule of execution in different formats.




