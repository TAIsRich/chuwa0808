1. @RestController
	1. usage: restController specify this is a controller class and use to handle api response
	2. understanding: calls some class to create controller class
	3. example: 
		1. `@RestController`
2. @RequestMapping
	1. usage: create a path for api
	2. understanding: defined a path in the coressponding port
	3. example: `@RequestMapping("/api/v1")`
3. @Autowired
	1. usage: use on reponsitory and service
	2. understanding: autowiring on properties, setters, and constructors
	3. example: 
		1. `@Autowired`
		2. `private PostService postService;`
4. @PostMapping
	1. usage: create a post Endpoint
	2.  understanding: to create a post endpoint in the specify path
	3. example:  
		        1. `@PostMapping("/posts")`  
   		      2. `public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {`  
        		3. `PostDto postResponse = postService.createPost(postDto);`  
        		4. `return new ResponseEntity<>(postResponse, HttpStatus.CREATED);}` 
    

5. @GetMapping
	1. Usage: use to create a get Endpoint
	2. Understanding: To create a get endpoint 
	3. example:  
		1. `@GetMapping("/get")`  
		2. `public String getResponse(@RequestParam(value = "name", defaultValue = "World") String name){`  
		3. `return String.format("Hello %s!", name);}`  
6. @Repository
	1. usage: in dao class, marks the dao class that import the right things for that class
	2. understanding: repository can help with crud operations
	3. example: 
		1. `@Repository`
		2. `public interface PostRepository extends JpaRepository<Post, Long> {}`
7. @Entity
	1. usage: use on the class that contains data and connec to database
	2. understanding: @Entity connects the table to the database
	3. example:
		1. `@Entity`
8. @Table
	1. usage: create a table in mysql database
	2. understanding: create a table in mysql database with name specify in it
	3. example: 
		1. `@Table(name = "RedBook")`
		2.  `public class Post`
9. @UniqueConstraint
	1. usage: use with @Table
	2. understanding: create a table with unique column
	3. example: 
        1. `@Table(`
        2. `name = "posts",`
        3. `uniqueConstraints = {`
        4. `@UniqueConstraint(columnNames = {"title"})`
        5. `}`

10. @Id  
	1. usage: specifies the primary key of an entity
	2. understanding: use that value as a unique id
	3. example:  
		    1. `@Id`  
    		2. `@GeneratedValue(strategy = GenerationType.IDENTITY)`  
    		3. `private Long id;`  
11. @Column
	1. usage: in entity class that has @Table, use on fields
	2. understanding: use to create a column under a specify table
	3. example
        1. `@Column(name = "title", nullable = false)`
        2. `private String title;`
12. @UpdateTimestamp
	1. usage: in entity class with LocalDateTime variable
	2. understanding: automatically unpdate the timestamp when any update is made
	3. example:
		1. `@UpdateTimestamp`
   		2. `private LocalDateTime updateDateTime;`
13. @CreationTimestamp
	1. usage: in entity class with LocalDateTime variable
	2. understanding: automatically record the creation time 
	3. example:
        1. `@CreationTimestamp`
        2. `private LocalDateTime createDateTime;`
14. @Service
	1. usage: on service class, most operations write inside service class
	2. understanding: marks this class as service class that deals with business logic	
	3. example:
		1. `@Service`
		2. `public class PostServiceImpl implements PostService`
	
15. @SpringBootApplication
	1. Usage: Mark the main class of spring boot applications
	2. Understanding: auto generated annotations by spring boot, tells that it is a springboot applications
	3. example: 
        1. `@SpringBootApplication`  
        2. `public class RedbookApplication {...}`
16. @DeleteMapping
	1. Usage: use in controller class, creates a delete endpoint
	2. understanding: use to create a delete endpoint
	3. example:
		1. `@DeleteMapping("/{id}")`
17. @JsonProperty
	1. usage: for fields that mapped to db, use for Serialization and deserialization
	2. def: to replace the classname/variable name with given name defined in property
	3. example
		1. `@JsonProperty(name = "Email")`
		2. `private string email;`
18. @JoinColumn
	1. usage: after OneToOne,OneToMany,ManyToOne... relationships
	2. def: joins the data to another column so both side have data
	3. example:
		1. `@ManyToOne`
    		2. `@JoinColumn(name = "post_id")`
   		3. `private String post_id;`
19. @JoinTable
	1. usage: after ManyToOne/OneToMany etc. relationships
	2. def: Join the data to another tables, make it bidirectional
	3. example
		1. @ManyToOne
		2. @JoinTable(name = "post", )
		3. example
20. @PersistenceContext
	1. usage: for create EntityManager
	2. def: associate with entitymanager, things stores in persistence context
	3. example:
		1. @PersistenceContext
		2. EntityManager entityManager;

21. @NamedQuery
	1. usage: for functions in entity class
	2. def:  defines a name and links to a query command
	3. example: 
		1. `@NamedQuery(name="get_all_posts", query="select p from Post p")`
		2. `public class Post {...}`
19. @ManyToOne
	1. usage: on data field
	2. def: multiple object can associate with this field
	3. example: 
		1. @ManyToOne
    		2. @JoinColumn(name="cart_id", nullable=false)
    		3. private Cart cart;

20. OneToMany
	1. usage: on data field
	2. def: state that this field will associate with multiple object
	3. example: 
		1. @OneToMany(mappedBy="cart")
    		2. private Set<Item> items;
21. ManyToMany
	1. usage: on data field
	2. def: state that this field can have a many to many relationship
	3. example: 
		1. @ManyToMany
    		2. Set<Student> likes;
22. @ResponseStatus
	1. usage:
	2. def:
	3. example: 
23. @Query
	1. usage: in repository, use with abstract functions
	2. def: bind a query to the functions
	3. example:  
		1. @Query("select p from Post p where p.id = ?1 or p.title = ?2")
		2. Post getPostByIDOrTitleWithJPQLIndexParameters(Long id, String title);
24. @Transactional
	1. usage: in repositoryImpl that implments another repostory interface
	2. def: use transactional functions that rollback if adding the data to database failed
	3. example: 
		1. `@Repository`
		2. `@Transactional`
		3. `public class PostJPQLRepositoryImpl implements PostJPQLRepository {...}`
25. @RequestParam
	1. usage: on controller layer, on Mapping functions
	2. def: set a endpoint that takes parameter from client
	3. example: public PostDto searchId(@RequestParam("id") String str)

26. @NamedQueries
	1. usage: in entity class, above class
	2. def: creates a list of NamedQuery
	3. example:
		1. `@Entity`
		2. `@NamedQueries({`
		3. `@NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM `
		4. `Book b WHERE b.title =                :title"),`
		5. `@NamedQuery(name = "Book.findByPublishingDate", query = "SELECT `
		6. `b FROM Book b WHERE     b.publishingDate = :publishingDate")`
		7. `})`
		8. `public class Book implements Serializable {...}`
		9. `})`
@Bean
	1. usage:
	2. def:
	3. example: 
@Component
@Controller
@ExceptionHandler
	1. usage: use in globalexceptionalhandler class, use in speicify type of exceptions
	2. def: if this expception is being called, use the followering function to handle
	3. example: 
		1. `@ExceptionHandler(ResourceNotFoundException.class)`
    		2. `public ResponseEntity<ErrorDetails> handleResourceNotFoundException(`
		3. `		ResourceNotFoundException exception,`
                                   4. `                               WebRequest webRequest) {...}`
@ControllerAdvice
	1. usage: in class globalExceptionalhandler extends ResponseEntityExceptionHandler 
	2. def: check the controller input is valid or not, throws exceptions if not
	3. example: 
		1. `@ControllerAdvice`
		2. `public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {...}`
@Valid
	1. usage: in controller class with validation library that set up with payload class
	2. def:  check if the @RequestBody is valid, if not valid throws exceptions
	3. example: 
		1. `@PostMapping()`
    		2. `public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {...}`
@NotEmpty
	1. usage: use in payload class
	2. def: must not be empty, if empty throws exceptions
	3. example: 
		1. `@NotEmpty`
    		2. `@Size(min = 2, message = "Post title should have at least 2 characters")`
    		3. `private String title;`
@Email
	1. usage: in payload class, must use on string email(holds a email address)
	2. def: check whether the string is a valid email address format
	3. example: 
		1. `@NotEmpty(message = "Email should not be null or empty")`
    		2. `@Email`
    		3. `private String email;`
@Size
	1. usage: use in payload class
	2. def: defined the minimum length of this string
	3. example: 
		1. `@NotEmpty`
    		2. `@Size(min = 2, message = "Post title should have at least 2 characters")`
    		3. `private String title;`
@PathVariable
	1. usage: use in controller class, in mapping functions
	2. def: pathvariable is the name/content that in that url
	3. example: 
		1. `@GetMapping("/{id}")`
    		2. `public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {..}`
@RequestBody
	1. usage: in controller class in mapping functions
	2. def: is the json format input from client
	3. example: 
		1. `@PostMapping()`
    		2. `public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {...}`
@Configuration
@EnableAutoConfiguration
@ComponentScan
@Resource
@Inject
	1. usage:
	2. def:
	3. example: 
end



	