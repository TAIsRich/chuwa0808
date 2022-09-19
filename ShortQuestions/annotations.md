### @Entity
- it is a enity, will be used to map with database

### @Table
-  will be used to locate the database table name
-  the JPA annotation is used for adding the table name in the particular MySQL database.

### @UniqueConstraint
- Annotation type UniqueConstraint specifies that a unique constraint is to be included in the generated DDL (Data Definition Language) for a table.
- Let's consider our Person entity. A Person shouldn't have any duplicate record for the active status. In other words, there won't be any duplicate values for the key comprising personNumber and isActive. Here, we need to add unique constraints that span across multiple columns.
- Multiple Unique Constraints on a Single Entity, A table can have multiple unique constraints.
-
```
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "personNumber", "isActive" }) })

[main] DEBUG org.hibernate.SQL -
    alter table Person add constraint UK5e0bv5arhh7jjhsls27bmqp4a unique (personNumber, isActive)
```

- One point to note here is that if we don't specify a name, it's a provider-generated value. Since JPA 2.0, we can provide a name for our unique constraint
```
@Table(uniqueConstraints = { @UniqueConstraint(name = "UniqueNumberAndStatus", columnNames = { "personNumber", "isActive" }) })
[main] DEBUG org.hibernate.SQL -
    alter table Person add constraint UniqueNumberAndStatus unique (personNumber, isActive)
```
### @Id
- this column is a primary key

### @GeneratedValue
- 主键⾃增的策略
- The @GeneratedValueannotation is to configure the way of increment of the specified column(field). For example when using Mysql, you may specify auto_incrementin the definition of table to make it self-incremental, and then use
```
@GeneratedValue(strategy = GenerationType.IDENTITY)
```
- ***GenerationType.AUTO***
  - The GenerationType.AUTO is the default generation type and lets the persistence provider choose the generation strategy.
  - If you use Hibernate as your persistence provider, it selects a generation strategy based on the database specific dialect. For most popular databases, it selects

- ***GenerationType.IDENTITY***
  - The GenerationType.IDENTITY is the easiest to use but not the best one from a performance point of view. It relies on an auto-incremented database column and lets the database generate a new value with each insert operation. From a database point of view, this is very efficient because the auto-increment columns are highly optimized, and it doesn’t require any additional statements.
  - This approach has a significant drawback if you use Hibernate. Hibernate requires a primary key value for each managed entity and therefore has to perform the insert statement immediately. This prevents it from using different optimization techniques like JDBC batching.

- ***GenerationType.SEQUENCE***
  - The GenerationType.SEQUENCE uses a database sequence to generate unique values. It requires additional select statements to get the next value from a database sequence. But this has no performance impact for most applications.
  - If you don’t provide any additional information, Hibernate will request the next value from its default sequence. You can change that by referencing the name of a @SequenceGenerator in the generator attribute of the @GeneratedValue annotation. The @SequenceGenerator annotation lets you define the name of the generator, the name, and schema of the database sequence and the allocation size of the sequence.
 ```
 @Id
@GeneratedValue(strategy=GenerationType.AUTO)
@SequenceGenerator(name="car_generator", sequenceName = "car_seq", allocationSize=50)
private Long id;
 ```


### @Column
- specify the informaiton for this column, like name in database, can be null or not in database
```
@Column(name = "title", nullable = false)
```

- Whenever the unique constraint is based only on one field, we can use @Column(unique=true) on that column.
```
@Column(unique=true)
private Long personNumber;

[main] DEBUG org.hibernate.SQL -
    alter table Person add constraint UK_d44q5lfa9xx370jv2k7tsgsqt unique (personNumber)
```

### @CreationTimestamp
- When a new entity gets persisted, Hibernate gets the current timestamp from the VM and sets it as the value of the attribute annotated with @CreationTimestamp. After that, Hibernate will not change the value of this attribute.

- @CreationTimestamp mapping example
```
@Entity(name = "Event")
public static class Event {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "`timestamp`")
	@CreationTimestamp
	private Date timestamp;

	//Constructors, getters, and setters are omitted for brevity
}
```

### @UpdateTimestamp
- The value of the attribute annotated with @UpdateTimestamp gets changed in a similar way with every SQL Update statement. Hibernate gets the current timestamp from the VM and sets it as the update timestamp on the SQL Update statement

```
@Entity(name = "Bid")
public static class Bid {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "updated_on")
	@UpdateTimestamp
	private Date updatedOn;

	@Column(name = "updated_by")
	private String updatedBy;

	private Long cents;

	//Getters and setters are omitted for brevity

}
```


### @Repository
- @Repository Annotation is a specialization of @Component annotation which is used to indicate that the class provides the mechanism for storage, retrieval, update, delete and search operation on objects. Though it is a specialization of @Component annotation, so Spring Repository classes are autodetected by spring framework through classpath scanning. This annotation is a general-purpose stereotype annotation which very close to the DAO pattern where DAO classes are responsible for providing CRUD operations on database tables.
```
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
```

### @RestController
- @RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody annotations, and as a result, simplifies the controller implementation
```
@RestController
@RequestMapping("books-rest")
public class SimpleBookRestController {
    
    @GetMapping("/{id}", produces = "application/json")
    public Book getBook(@PathVariable int id) {
        return findBookById(id);
    }

    private Book findBookById(int id) {
        // ...
    }
}
```


### @RequestMapping
- Simply put, the annotation is used to map web requests to Spring Controller methods.
- The HTTP *method* parameter has **no default.** So, if we don't specify a value, it's going to map to any HTTP request.
```
@RequestMapping(value = "/ex/foos", method = POST)
@ResponseBody
public String postFoos() {
    return "Post some Foos";
}
```

### @GetMapping
- The @GetMapping annotation is a specialized version of @RequestMapping annotation that acts as a shortcut for
- The @GetMapping annotated methods in the @Controller annotated classes handle the HTTP GET requests matched with given URI expression.
```
@GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }
```

### @PostMapping
- The @PostMapping is specialized version of @RequestMapping annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST).
- The @PostMapping annotated methods in the @Controller annotated classes handle the HTTP POST requests matched with given URI expression.
```
@PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto postResponse = postService.createPost(postDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }
```
### @PutMapping
- @PutMapping annotation in your RESTful Web Services application to be able to accept HTTP Put request containing a Request Body with JSON or XML payload, so that you can perform let’s say an update user details operation.
```
@PutMapping("/{id}")
    public  ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name = "id") long id){
        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }
```

### @DeleteMapping
- @DeleteMapping annotation maps HTTP DELETE requests onto specific handler methods. It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.DELETE).
```
@DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id")long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }
```

### @RequestBody
- Simply put, the @RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object.
```
@PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto postResponse = postService.createPost(postDto);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }
```
### @Autowired
- The @Autowired annotation marks a Constructor, Setter method, Properties and Config() method as to be autowired that is ‘injecting beans'(Objects) at runtime by Spring Dependency Injection mechanism

- @Autowired annotation is optional for constructor based injection. Here, the person object from the container is passed to the constructor while creating the Customer object.
```
@Component
public class Customer {

    private int type;
    private Person person;

    public Customer() {
    }

    @Autowired
    public Customer(Person person) {
        this.person = person;
    }
}
```

- Property-based Autowiring: The person object will be injected into the property person at run time using @Autowired annotation
```
@Component
public class Customer {

    private int type;

    @Autowired
    private Person person;
}
```

- Setter based Autowiring: The setter method will be called with the Person object at runtime by the container.
```
@Autowired
public void setPerson(Person person) {
    this.person = person;
}
```
### @Max
- @Max annotation is used to limit the value of a field. In the above code, the id field can have the maximum value of 10.
```
 @Max(value=10)
 private int id;
```
### @Min
- @Min annotation is used to limit the value of a field to a minimum value.
```
 @Size(min=3)
 private String institute;
```
### @RequestParam
- A Simple Mapping
  - used @RequestParam to extract the id query parameter.
```
@GetMapping("/api/foos")
@ResponseBody
public String getFoos(@RequestParam String id) {
    return "ID: " + id;
}
```
- Specifying the Request Parameter Name
  - Sometimes we want these to be different, though. Or, if we aren't using Spring Boot, we may need to do special compile-time configuration or the parameter names won't actually be in the bytecode.
  - Fortunately, we can configure the @RequestParam name using the name attribute
  - We can also do @RequestParam(value = “id”) or just @RequestParam(“id”).
```
@PostMapping("/api/foos")
@ResponseBody
public String addFoo(@RequestParam(name = "id") String fooId, @RequestParam String name) { 
    return "ID: " + fooId + " Name: " + name;
}
```
- Optional Request Parameters
```
GET /api/foos HTTP/1.1
-----
400 Bad Request
Required String parameter 'id' is not present
```
- We can configure our @RequestParam to be optional, though, with the required attribute:
```
@GetMapping("/api/foos")
@ResponseBody
public String getFoos(@RequestParam(required = false) String id) { 
    return "ID: " + id;
}


--------
http://localhost:8080/spring-mvc-basics/api/foos?id=abc
----
ID: abc
```
- A Default Value for the Request Parameter
  - We can also set a default value to the @RequestParam by using the defaultValue attribute:
```
@GetMapping("/api/foos")
@ResponseBody
public String getFoos(@RequestParam(defaultValue = "test") String id) {
    return "ID: " + id;
}


-------
http://localhost:8080/spring-mvc-basics/api/foos
----
ID: test
```


### @ManyToOne
- @ManyToOne
  - Based on the example above, We can also add a reference to Cart in each Item using @ManyToOne, making this a bidirectional relationship. Bidirectional means that we are able to access items from carts, and also carts from items.
  - the @ManyToOne annotation is associated with the Cart class variable. @JoinColumn annotation references the mapped column.
  - As we have seen in section 2, we can specify a many-to-one relationship by using the @ManyToOne annotation. A many-to-one mapping means that many instances of this entity are mapped to one instance of another entity – many items in one cart.
  - The @ManyToOne annotation lets us create bidirectional relationships too.
```
@Entity
@Table(name="ITEMS")
public class Item {
    
    //...
    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;

    public Item() {}
    
    // getters and setters
}
```
### @ManyToMany
- @ManyToMany
  - A relationship is a connection between two types of entities. In the case of a many-to-many relationship, both sides can relate to multiple instances of the other side.
  - A student can like many courses, and many students can like the same course
  - s we know, in RDBMSs we can create relationships with foreign keys. Since both sides should be able to reference the other, we need to create a separate table to hold the foreign keys, Such a table is called a join table. In a join table, the combination of the foreign keys will be its composite primary key.
  - We should include a Collection in both classes, which contains the elements of the others. After that, we need to mark the class with @Entity and the primary key with @Id to make them proper JPA entities. Also, we should configure the relationship type. So, we mark the collections with @ManyToMany annotations:
```
@Entity
class Student {

    @Id
    Long id;

    @ManyToMany
    Set<Course> likedCourses;

    // additional properties
    // standard constructors, getters, and setters
}

@Entity
class Course {

    @Id
    Long id;

    @ManyToMany
    Set<Student> likes;

    // additional properties
    // standard constructors, getters, and setters
}
```
- We can do this with the @JoinTable annotation in the Student class. We provide the name of the join table (course_like) as well as the foreign keys with the @JoinColumn annotations. The joinColumn attribute will connect to the owner side of the relationship, and the inverseJoinColumn to the other side:
```
@ManyToMany
@JoinTable(
  name = "course_like", 
  joinColumns = @JoinColumn(name = "student_id"), 
  inverseJoinColumns = @JoinColumn(name = "course_id"))
Set<Course> likedCourses;
```
- Note that using @JoinTable or even @JoinColumn isn't required. JPA will generate the table and column names for us. However, the strategy JPA uses won't always match the naming conventions we use. So, we need the possibility to configure table and column names. On the target side, we only have to provide the name of the field, which maps the relationship. Therefore, we set the mappedBy attribute of the @ManyToMany annotation in the Course class:
```
@ManyToMany(mappedBy = "likedCourses")
Set<Student> likes;
```
### @OneToMany
- @OneToMany:
  - one-to-many mapping means that one row in a table is mapped to multiple rows in another table
  - For this example, we'll implement a cart system where we have a table for each cart and another table for each item. One cart can have many items, so here we have a one-to-many mapping.
  - The way we do it in code is with @OneToMany.
  - the @OneToMany annotation is used to define the property in Item class that will be used to map the mappedBy variable.
```
public class Cart {

    //...     
 
    @OneToMany(mappedBy="cart")
    private Set<Item> items;
	
    //...
}
```
- For example, if one department can employ for several employees then, department to employee is a one to many relationship (1 department employs many employees), while employee to department relationship is many to one (many employees work in one department).
### cascade = CascadeType.ALL, orphanRemoval = true and the other CascadeType and their features
- let's look at how this cascade type attribute is defined in our code for more clear understanding. Take a scenario where an employee can have multiple accounts, but one account must be associated with only one employee.
- Look at the bold line in the above source code for EmployeeEntity. It defines cascade=CascadeType.ALL, and it essentially means that any change happened on EmployeeEntity must cascade to AccountEntity as well.
- If we save an employee, then all associated accounts will also be saved into the database. If you delete an Employee then all accounts associated with that Employee also be deleted. Simple enough !!
```
@Entity
@Table(name = "Employee")
public class EmployeeEntity implements Serializable
{
	private static final long serialVersionUID = -1798070786993154676L;
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private Integer           employeeId;
	@Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
	private String            firstName;
	@Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
	private String            lastName;

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE_ID")
	private Set<AccountEntity> accounts;

	//Getters and Setters Hidden
}

@Entity
@Table(name = "Account")
public class AccountEntity implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer           accountId;
	@Column(name = "ACC_NO", unique = false, nullable = false, length = 100)
	private String            accountNumber;

	@ManyToOne (mappedBy="accounts",  fetch = FetchType.LAZY)
	private EmployeeEntity employee;

}
```
- The orphanRemoval option was introduced in JPA 2.0. This provides a way to delete orphaned entities from the database.
- Whenever we delete an employee, all his accounts will get deleted if we use the CascadeType.REMOVE. But if want that whenever we remove the relationship between an account and an employee, hibernate will check for the accounts in other references. If none is found, hibernate will delete the account since it's an orphan.
```
@OneToMany(orphanRemoval = true, mappedBy = "...")
```


- CascadeType.PERSIST : cascade type presist means that save() or persist() operations cascade to related entities.
- CascadeType.MERGE : cascade type merge means that related entities are merged when the owning entity is merged.
- CascadeType.REFRESH : cascade type refresh does the same thing for the refresh() operation.
- CascadeType.REMOVE : cascade type remove removes all related entities association with this setting when the owning entity is deleted.
- CascadeType.DETACH : cascade type detach detaches all related entities if a manual detach occurs.
- CascadeType.ALL : cascade type all is shorthand for all of the above cascade operations.

### What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?
- Sometimes you have two entities and there's a relationship between them. For example, you might have an entity called University and another entity called Student and a University might have many Students:
- The University entity might have some basic properties such as id, name, address, etc. as well as a collection property called students that returns the list of students for a given university:
```
public class University {
   private String id;
   private String name;
   private String address;
   private List<Student> students;

   // setters and getters
}
```
- Now when you load a University from the database, JPA loads its id, name, and address fields for you. But you have two options for how students should be loaded:

  1. To load it together with the rest of the fields (i.e. eagerly), or
  2. To load it on-demand (i.e. lazily) when you call the university's getStudents() method.
- When a university has many students it is not efficient to load all of its students together with it, especially when they are not needed and in suchlike cases you can declare that you want students to be loaded when they are actually needed. This is called lazy loading.
- Here's an example, where students is explicitly marked to be loaded eagerly:
```
@Entity
public class University {

    @Id
    private String id;

    private String name;

    private String address;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Student> students;

    // etc.    
}
```

- And here's an example where students is explicitly marked to be loaded lazily:
```
@Entity
public class University {

    @Id
    private String id;

    private String name;

    private String address;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Student> students;

    // etc.
}
```

- In order for lazy loading to work, the JDBC session must still be open when the target entities want to be loaded into the memory by invoking the getter method (e.g. getStudents()), but sometimes this is not possible, because by the time this method is called, the session is already closed and the entity detached. Similarly, sometimes we have a client/server architecture (e.g. Swing client/JEE server) and the entities/DTOs are transferred over the wire to the client and again most often in these scenarios lazy loading won't work due to the way the entities are serialized over the wire.

### @Validated and @Valid
- In many cases, however, Spring does the validation for us. We don’t even need to create a validator object ourselves. Instead, we can let Spring know that we want to have a certain object validated. This works by using the the @Validated and @Valid annotations.
- The @Validated annotation is a class-level annotation that we can use to tell Spring to validate parameters that are passed into a method of the annotated class.
- We can put the @Valid annotation on method parameters and fields to tell Spring that we want a method parameter or field to be validated.

1. To validate the request body of an incoming HTTP request, we annotate the request body with the @Valid annotation in a REST controller:
   - We simply have added the @Valid annotation to the Input parameter, which is also annotated with @RequestBody to mark that it should be read from the request body. By doing this, we’re telling Spring to pass the object to a Validator before doing anything else.
   - When Spring Boot finds an argument annotated with @Valid, it automatically bootstraps the default JSR 380 implementation — Hibernate Validator — and validates the argument. When the target argument fails to pass the validation, Spring Boot throws a MethodArgumentNotValidException exception.

    ```
    class Input {
    
      @Min(1)
      @Max(10)
      private int numberBetweenOneAndTen;
    
      @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
      private String ipAddress;
      
      // ...
    }
    
    -------------------------------------------------------------------------------
    
    @RestController
    class ValidateRequestBodyController {
    
      @PostMapping("/validateBody")
      ResponseEntity<String> validateBody(@Valid @RequestBody Input input) {
        return ResponseEntity.ok("valid");
      }
    
    }
    ```
2. Validating Path Variables and Request Parameters: Validating path variables and request parameters works a little differently. We’re not validating complex Java objects in this case, since path variables and request parameters are primitive types like int or their counterpart objects like Integer or String. Instead of annotating a class field like above, we’re adding a constraint annotation (in this case @Min) directly to the method parameter in the Spring controller:
- Note that we have to add Spring’s @Validated annotation to the controller at class level to tell Spring to evaluate the constraint annotations on method parameters.
- The @Validated annotation is only evaluated on class level in this case, even though it’s allowed to be used on methods (we’ll learn why it’s allowed on method level when discussing validation groups later).
- In contrast to request body validation a failed validation will trigger a ConstraintViolationException instead of a MethodArgumentNotValidException. Spring does not register a default exception handler for this exception, so it will by default cause a response with HTTP status 500 (Internal Server Error).
  ```
  @RestController
  @Validated
  class ValidateParametersController {
  
    @GetMapping("/validatePathVariable/{id}")
    ResponseEntity<String> validatePathVariable(
        @PathVariable("id") @Min(5) int id) {
      return ResponseEntity.ok("valid");
    }
    
    @GetMapping("/validateRequestParameter")
    ResponseEntity<String> validateRequestParameter(
        @RequestParam("param") @Min(5) int param) { 
      return ResponseEntity.ok("valid");
    }
  }
  ``` 


### Common Validation Annotations:
- @NotNull: to say that a field must not be null.
- @NotEmpty: to say that a list field must not empty.
- @NotBlank: to say that a string field must not be the empty string (i.e. it must have at least one character).
- @Min and @Max: to say that a numerical field is only valid when it’s value is above or below a certain value.
- @Pattern: to say that a string field is only valid when it matches a certain regular expression.
- @Email: to say that a string field must be a valid email address.

### @Transactional
- Spring provides Declarative Transaction Management via @Transactional annotation. When a method is applied with @Transactional, then it will execute inside a database transaction. @Transactional annotation can be applied at the class level also, in that case, all methods of that class will be executed inside a database transaction.

- How @Transactional works: When @Transactional annotation is detected by Spring, then it creates a proxy[^1] object around the actual bean object. So, whenever the method annotated with @Transactional is called, the request first comes to the proxy object and this proxy object invokes the same method on the target bean. These proxy objects can be supplied with interceptors. Spring creates a TransactionInterceptor and passes it to the generated proxy object. So, when the @Transactional annotated method is called, it gets called on the proxy object first, which in turn invokes the TransactionInterceptor that begins a transaction. Then the proxy object calls the actual method of the target bean. When the method finishes, the TransactionInterceptor commits/rollbacks the transaction.


- One thing to remember here is that the Spring wraps the bean in the proxy, the bean has no knowledge of it. So, only the external calls go through the proxy. As for the internal calls (@Transactional method calling the same bean method), they are called using ‘this’. Using @Transactional annotation, the transaction’s propagation and isolation can be set directly
```  
@Transactional
public void createCourseDeclarativeWithRuntimeException(Course course) {
    courseDao.create(course);
    throw new DataIntegrityViolationException("Throwing exception for demoing Rollback!!!");
}
```
- Next we'll use the declarative approach to rollback a transaction for the listed checked exceptions. The rollback in our example is on SQLException:
```
@Transactional(rollbackFor = { SQLException.class })
public void createCourseDeclarativeWithCheckedException(Course course) throws SQLException {
    courseDao.create(course);
    throw new SQLException("Throwing exception for demoing rollback");
}
```
- Let's see a simple use of attribute noRollbackFor in the declarative approach to prevent rollback of the transaction for the listed exception:
```
@Transactional(noRollbackFor = { SQLException.class })
public void createCourseDeclarativeWithNoRollBack(Course course) throws SQLException {
    courseDao.create(course);
    throw new SQLException("Throwing exception for demoing rollback");
}
```

- In the programmatic approach, we rollback the transactions using TransactionAspectSupport:
```
public void createCourseDefaultRatingProgramatic(Course course) {
    try {
       courseDao.create(course);
    } catch (Exception e) {
       TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }
}
```
- The declarative rollback strategy should be favored over the programmatic rollback strategy.
### @SpringbootApplication?
- The @SpringBootApplication annotation is a convenience annotation that combines the @EnableAutoConfiguration, @Configuration and the @ComponentScan annotations in a Spring Boot application.
```
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
          SpringApplication.run(Main.class, args);
      }
}
```
### @Configuration
- which declares a class as the source for bean definitions
- Designates the class as a configuration class for Java configuration. In addition to beans configured via component scanning, an application may desire to configure some additional beans via the @Bean annotation as demonstrated here. Thus, the return value of methods having the @Bean annotation in this class are registered as beans.
### @EnableAutoConfiguration
- which allows the application to add beans using classpath definitions
- This enables Spring Boot’s autoconfiguration mechanism. Auto-configuration refers to creating beans automatically by scanning the classpath.
### @ComponentScan
- which directs Spring to search for components in the path specified
- Typically, in a Spring application, annotations like @Component, @Configuration, @Service, @Repository are specified on classes to mark them as Spring beans. The @ComponentScan annotation basically tells Spring Boot to scan the current package and its sub-packages in order to identify annotated classes and configure them as Spring beans. Thus, it designates the current package as the root package for component scanning.
- Spring can automatically scan a package for beans if component scanning is enabled.
- With Spring, we use the @ComponentScan annotation along with the @Configuration annotation to specify the packages that we want to be scanned. @ComponentScan without arguments tells Spring to scan the current package and all of its sub-packages. Let’s have look at following example, component classes available in reptiles base package and in crocodles, snakes sub-packages, they are annotated with @Component.
- @ComponentScan configures which packages to scan for classes with annotation configuration. We can specify the base package names directly with one of the basePackages or value arguments (value is an alias for basePackages)
```
@Configuration
@ComponentScan(basePackages = "com.baeldung.annotations")
class VehicleFactoryConfig {}


// we can also refer to classes
@Configuration
@ComponentScan(basePackageClasses = VehicleFactoryConfig.class)
class VehicleFactoryConfig {}
```

### @Component
- @Component: it is a general purpose stereotype annotation which indicates that the class annotated with it, is a spring managed component.
- @Controller, @Service and @Repository are special types of @Component

### @Service
- the service layer classes that contain the business logic should be annotated with @Service. Apart from the fact that it is used to indicate that the class contains business logic, there is no special meaning to this annotation, however it is possible that Spring may add some additional feature to @Service in future, so it is always good idea to follow the convention.
### @Value
- use the @Value annotation and access the property in whichever Spring bean we are using
```
@Value("${userBucket.path}")
private String userBucketPath;
```

### @Aspect
- a modularization of a concern that cuts across multiple classes. Transaction management is a good example of a crosscutting concern in J2EE applications. In Spring AOP, aspects are implemented using regular classes (the schema-based approach) or regular classes annotated with the @Aspect annotation (the @AspectJ style).
- The class which implements the JEE application cross-cutting concerns(transaction, logger etc) is known as the aspect. It can be normal class configured through XML configuration or through regular classes annotated with @Aspect.
- class to define all aop self methos
```
package org.xyz;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class NotVeryUsefulAspect {

}
```
### @Pointcut
- expression to find all main application methods to insert AOP
- Since it is not feasible to apply advice at every point of the code, therefore, the selected join points where advice is finally applied are known as the Pointcut. Often you specify these pointcuts using explicit class and method names or through regular expressions that define a matching class and method name patterns. It helps in reduction of repeating code by writing once and use at multiple points.
- a predicate that matches join points. Advice is associated with a pointcut expression and runs at any join point matched by the pointcut (for example, the execution of a method with a certain name). The concept of join points as matched by pointcut expressions is central to AOP, and Spring uses the AspectJ pointcut expression language by default.
- Recall that pointcuts determine join points of interest, and thus enable us to control when advice executes. Spring AOP only supports method execution join points for Spring beans, so you can think of a pointcut as matching the execution of methods on Spring beans. A pointcut declaration has two parts: a signature comprising a name and any parameters, and a pointcut expression that determines exactly which method executions we are interested in. In the @AspectJ annotation-style of AOP, a pointcut signature is provided by a regular method definition, and the pointcut expression is indicated using the @Pointcut annotation (the method serving as the pointcut signature must have a void return type).
- Advice 是和特定的 point cut 关联的, 并且在 point cut 相匹配的 join point 中执行. 在 Spring 中, 所有的方法都可以认为是 joinpoint, 但是我们并不希望在所有的方法上都添加 Advice, 而 pointcut 的作用就是提供一组规则(使用 AspectJ pointcut expression language 来描述) 来匹配joinpoint, 给满足规则的 joinpoint 添加 Advice.
```
@Aspect
class Logging {
  
    // pointcut() is a dummy method
    // required to hold @Pointcut annotation
    // pointcut() can be used instead of writing line 1
    // whenever required, as done in line 4.
    // This prevents a repetition of code.
  
    @Pointcut("execution(public void com.aspect.ImplementAspect.aspectCall())") // line 1
    public void pointCut()
    {
    }
  
    // pointcut() is used to avoid repetition of code
    @Before("pointcut()")
    public void loggingAdvice1()
    {
        System.out.println("Before advice is executed");
    }
}
```
### @JsonProperty
### @JoinColumn
### @Service
### @NamedQuery
- Basically @NameQueries annotation is used to define the multiple named queries, adn the @NameQuery annotation is used to define the single named query
```
@NamedQueries(  
    {  
        @NamedQuery(  
        name = "findEmployeeByName",  
        query = "from Employee e where e.name = :name"  
        )  
    }  
)  
```

- The following @NamedQuery annotation defines a query whose name is "Country.findAll" that retrieves all the Country objects in the database:
```
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c") 
```
- The @NamedQuery annotation contains four elements - two of which are required and two are optional. The two required elements, name and query define the name of the query and the query string itself and are demonstrated above. The two optional elements, lockMode and hints, provide static replacement for the setLockMode and setHint methods.
- Every @NamedQuery annotation is attached to exactly one entity class or mapped superclass - usually to the most relevant entity class. But since the scope of named queries is the entire persistence unit, names should be selected carefully to avoid collision (e.g. by using the unique entity name as a prefix).
- Attaching multiple named queries to the same entity class requires wrapping them in a @NamedQueries annotation, as follows:
```
@Entity

@NamedQueries({
    @NamedQuery(name="Country.findAll",
                query="SELECT c FROM Country c"),
    @NamedQuery(name="Country.findByName",
                query="SELECT c FROM Country c WHERE c.name = :name"),
}) 
public class Country {
  ...
}
```
### @Transactional
- The @Transactional annotation tells Spring that a transaction is required to execute this method. When you inject the AuthorService somewhere, Spring generates a proxy object that wraps the AuthorService object and provides the required code to manage the transaction.
```

@Service
public class AuthorService {     
    private AuthorRepository authorRepository;     
     
    public AuthorService(AuthorRepository authorRepository) {               
        this.authorRepository = authorRepository;     
    }     
     
    @Transactional    
    public void updateAuthorNameTransaction() {         
        Author author = authorRepository.findById(1L).get(); 
        author.setName("new name");     
    } 
}
```
### @PersistenceContext
### @Query
- The @Query annotation takes precedence over named queries, which are annotated with @NamedQuery or defined in an orm.xml file.
- It's a good approach to place a query definition just above the method inside the repository rather than inside our domain model as named queries. The repository is responsible for persistence, so it's a better place to store these definitions.
- By default, the query definition uses JPQL.
  - Let's look at a simple repository method that returns active User entities from the database:
  ```
  @Query("SELECT u FROM User u WHERE u.status = 1")
  Collection<User> findAllActiveUsers();
  ```
- We can use also native SQL to define our query. All we have to do is set the value of the nativeQuery attribute to true and define the native SQL query in the value attribute of the annotation:
  ```
  @Query(
  value = "SELECT * FROM USERS u WHERE u.status = 1", nativeQuery = true)
  Collection<User> findAllActiveUsersNative();
  ```
---

## Annotations for mongoDB only

### @Indexed
- The @Indexed annotation allows us to mark fields as having an index. And since we configured automatic index creation, we won't have to create them ourselves. By default, an index is not unique. Therefore, we have to turn it on via the unique property. Let's see it in action by creating our first example:
```
 @Indexed(unique = true)
```

### @Field
- represent a field (similar to a column in MySQL)
- if without specifying a name, it will distribute the default name
```
 @Field("description")
    private String description;
```

### @Document
- similar to entity in hibernate, mark it for maintain the table by MongoDB

### @CreatedDate and @LastModifiedDate
- similar to @CreationTimestamp and @UpdateTimestamp