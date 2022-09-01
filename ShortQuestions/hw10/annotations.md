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
@Query
	1. usage:
	2. def:
	3. example: 
@Transactional
	1. usage:
	2. def:
	3. example: 
mongodb
@Document
@Field
	