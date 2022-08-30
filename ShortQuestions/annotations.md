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
- The @GeneratedValueannotation is to configure the way of increment of the specified column(field). For example when using Mysql, you may specify auto_incrementin the definition of table to make it self-incremental, and then use
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

- @CreationTimestamp mapping example
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
- @Repository Annotation is a specialization of @Component annotation which is used to indicate that the class provides the mechanism for storage, retrieval, update, delete and search operation on objects. Though it is a specialization of @Component annotation, so Spring Repository classes are autodetected by spring framework through classpath scanning. This annotation is a general-purpose stereotype annotation which very close to the DAO pattern where DAO classes are responsible for providing CRUD operations on database tables.
```
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
```

### @RestController
- @RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody annotations, and as a result, simplifies the controller implementation
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
- The HTTP *method* parameter has **no default.** So, if we don't specify a value, it's going to map to any HTTP request.
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