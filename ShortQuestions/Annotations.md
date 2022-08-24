# Annotation Notes

##General
####@Autowired
    It automatically injects the dependent beans into the associated references of a POJO class. This annotation will inject the dependent beans by matching the data-type (i.e. Works internally as Autowiring byType).

##Controller
####@RestController
Spring RestController annotation is a convenience annotation that is itself annotated with @Controller and @ResponseBody . This annotation is applied to a class to mark it as a request handler. Spring RestController annotation is used to create RESTful web services using Spring MVC.

####@RequestMapping()
    It is used to map web requests onto specific handler classes and/or handler methods. @RequestMapping can be applied to the controller class as well as methods.

    @RequestMapping is used at the class level while @GetMapping is used to connect the methods. 
    
    e.g.,
    @RestController
    @RequestMapping("/api/v1")
    public class PostController {}

####@Autowired
 For service injection, see #General session for further information.
 
    e.g., 
    @Autowired
    private PostService postService;//用autowire将service注入进来

####@PostMapping()
    It is used to handle POST type of request method.
####@RequestBody
    The @RequestBody annotation is applicable to handler methods of Spring controllers. This annotation indicates that Spring should deserialize a request body into an object. This object is passed as a handler method parameter.

    e.g., 
    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {}

####@GetMapping
####@GetMapping()
    It is used to handle GET type of request method.
####@PathVariable()
    @PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable. It has the following optional elements:
            name - name of the path variable to bind to
            required - tells whether the path variable is required
            value - alias for name

    e.g.,
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){}

####@PutMapping()
    It is used to handle PUT type of request method.
    
    e.g., 
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name = "id") long id){

####@DeleteMapping()
    It is used to handle DELETE type of request method.
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id){}

##Entity
The annotations used under entity may vary based on the type of database used for the application

###MySQL

####@Entity
####@Table(name = "xxx", 
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
        })
        
        e.g.,
        @Entity
        @Table(
                name = "posts",
                uniqueConstraints = {
                        @UniqueConstraint(columnNames = {"title"})
                }
        )
        public class Post {
        
####@Id
####@GeneratedValue
    The @Id annotation specifies the primary key of an entity and the @GeneratedValue provides for the specification of generation strategies for the values of primary keys.

    e.g.,
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

####@Column(name = "TABLENAME", nullable = false/true)
    It is used for adding the column the name in the table of a particular MySQL database. 
    Relevant attributes:
        name: The name of the column.
        length: The column length.
        nullable: Whether the database column is nullable.
    
    e.g.,
    @Column(name = "content", nullable = false)
    private String content;

####@CreationTimestamp
    Declares a field as the one representing the date the entity containing the field was created.
    e.g., 
    @CreationTimestamp
    private LocalDateTime createDateTime;

####@UpdateTimestamp
    Declares a field as the one representing the date the entity containing the field was recently modified. 
    
    e.g., 
    @UpdateTimestamp
    private LocalDateTime updateDateTime;


###MongoDB

####@Document
    @Document is an annotation provided by Spring data project. It is used to identify a domain object, which is persisted to MongoDB, a document-based NoSQL database.
    
    e.g.,
    @Document(collection = "posts")
    public class Post {}

####@Id
    The @Id annotation specifies the primary key of an entity.

####@CreatedDate
    Declares a field as the one representing the date the entity containing the field was created.
    e.g., 
        @CreatedDate
        private LocalDateTime createDateTime;

####@LastModifiedDate
    Declares a field as the one representing the date the entity containing the field was recently modified. 
    
    e.g.,
        @LastModifiedDate
        private LocalDateTime updateDateTime;

##Service

####@Service
    It is used with classes that provide some business functionalities. In an application, the business logic resides within the service layer so we use the @Service Annotation to indicate that a class belongs to that layer. It is also a specialization of @Component Annotation like the @Repository Annotation.
    
    e.g.,
    @Service
    public class PostServiceImpl implements PostService {}

####@Autowired
    for DAO injection, see #General session for further information.

    e.g.,
        @Autowired
        private PostRepository postRepository;

##DAO
####@Repository
    It is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
    e.g., 
    @Repository
    public interface PostRepository extends JpaRepository<Post, Long> {
        //no need to write code
    }

##Exception
####@ResponseStatus(value = HttpStatus.XXXX)
    Marks a method or exception class with the status code() and reason() that should be returned.
    
    e.g.,
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {}
