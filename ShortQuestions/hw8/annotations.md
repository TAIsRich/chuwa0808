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
17. JsonProperty
18. @JoinColumn
@JoinTable
@PersistenceContext
@NamedQuery
19. @ManyToOne
20. OneToMany
21. ManyToMany
22. @ResponseStatus
@Query
@Transactional

mongodb
@Document
@Field
	