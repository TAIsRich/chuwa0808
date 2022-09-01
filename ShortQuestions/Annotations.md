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
    
####@RequestParam
    The @RequestParam is used to read the HTML form data provided by a user and bind it to the request parameter. @RequestParam annotation enables spring to extract input data that may be passed as a query, form data, or any arbitrary custom data.
    
    e.g.,
    @GetMapping()
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ) {
        return postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
    }

####@PutMapping()
    It is used to handle PUT type of request method.
    
    e.g., 
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name = "id") long id){

####@DeleteMapping()
    It is used to handle DELETE type of request method.
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id){}

##Payload/DTO

####@JsonProperty("description_yyds")
    The @JsonProperty annotation is used to map property names with JSON keys during serialization and deserialization. The content of the field with this annotion will be mapped from the "description_yyds" field passed by the JSON.
    
    e.g.,
    @JsonProperty("description_yyds")
    private String description;
    

##Entity
The annotations used under entity may vary based on the type of database used for the application

####@NamedQuery and @NamedQueries

    Hibernate Named Query can be defined in Hibernate mapping files or through the use of JPA annotations @NamedQuery and @NamedNativeQuery. @NameQueries annotation is used to define the multiple named queries. @NameQuery annotation is used to define the single named query.
    
    e.g., @NamedQuery
    @Entity
    @Table(
            name = "posts",
            uniqueConstraints = {
                 @UniqueConstraint(columnNames = {"title"})
            }
    )
    @NamedQuery(name="Post.getAll", query="select p from Post p")
    public class Post {}

    e.g., @NamedQueries
    @Entity
    @NamedQueries({
        @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM 
    Book b WHERE b.title = :title"),
        @NamedQuery(name = "Book.findByPublishingDate", query = "SELECT 
    b FROM Book b WHERE b.publishingDate = :publishingDate")
    })
    public class Book implements Serializable {
    ...
    }


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

####@PersistenceContext and @Transactional
    We will declare an EntityManager object in our class and mark it with the @PersistenceContext annotation. 
    We must use @Transactional since the operation should be atomic.

    e.g.,
    @Repository
    @Transactional
    public class PostJPQLRepositoryImpl implements PostJPQLRepository {
        @PersistenceContext
        EntityManager entityManager;
        ...
    }

##DAO
####@Repository
    It is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
    e.g., 
    @Repository
    public interface PostRepository extends JpaRepository<Post, Long> {
        //no need to write code
    }
    
####@Query
    In order to define SQL to execute for a Spring Data repository method, we can annotate the method with the @Query annotation — its value attribute contains the JPQL or SQL to execute.

    e.g.,
    @Repository
    public interface PostRepository extends JpaRepository<Post, Long> {

        @Query("select p from Post p where p.id = ?1 or p.title = ?2")
        Post getPostByIDOrTitleWithJPQLIndexParameters(Long id, String title);

        ...}

####@Param
    The @Param annotation maps the variable fileds in entity class and in SQL database. The SQL variables start with ":", and the name should match status name defined in @Param("StatusName"), and then JPA will map the fields and pass values accordingly.

    e.g.,
    @Repository
    public interface PostRepository extends JpaRepository<Post, Long> {

        @Query("select p from Post p where p.id = :key or p.title = :title")
        Post getPostByIDOrTitleWithJPQLNamedParameters(@Param("key") Long id,
                                                       @Param("title") String title);
        ...}
        


##Exception
####@ResponseStatus(value = HttpStatus.XXXX)
    Marks a method or exception class with the status code() and reason() that should be returned.
    
    e.g.,
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {}
