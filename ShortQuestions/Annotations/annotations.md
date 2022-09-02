1.@SpringBootApplication: It encapsulates the three core classes of @SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan, which greatly saves the programmer's configuration time, which is the core design idea of ​​SpringBoot.

@SpringBootApplication
public class RedbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedbookApplication.class, args);
	}

}


2.@RestController is the combination of @Controller and @ResponseBody, a class is annotated with @RestController, and @ResponseBody no longer needs to be added to the data interface, which is more concise.

3.@RequestMapping, we all need to specify the path of the request.

4.@GetMapping, @PostMapping, @PutMapping, @DeleteMapping 

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    
    @Autowired
    private PostService postService;

    @PostMapping()
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto postResponse = postService.createPost(postDto); 
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }
}

5.@Service This annotation is used to mark the components of the business layer, we will process the business logic the class will add this annotations are given to the spring container. Aspects of transactions are also configured at this layer. When let this annotation is not required to be used. There is an annotation that refers to a general component. When we cannot determine the specific role, we can use the annotation that refers to a general component to be entrusted to the spring container.

6.@Component has the same annotation function as spring and is injected into the IOC container.

7.@Entity @Table  @GeneratedValue @Column @Id are Database related annotations

Entity
@Table(name = "posts",
       uniqueConstraints = {
         @UniqueConstraint(columnNames = {"title"})
       })
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title" ,nullable = false)
    private String title;


8.@Requestbody:
  the @RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object

  @PostMapping("/request")
  public ResponseEntity postController(
    @RequestBody LoginForm loginForm) {
 
    exampleService.fakeAuthenticate(loginForm);
    return ResponseEntity.ok(HttpStatus.OK);
  }


9.@pathvariable:
   @PathVariable annotation can be used to handle template variables in the request URI mapping, and set them as method parameters.

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

10.@JsonProperty
@JsonProperty(name), tells Jackson ObjectMapper to map the JSON property name to the annotated Java field's name.
    @JsonProperty("name")
    private String name;

11.@ManyToOne(fetch = FetchType.LAZY)
   tables and tables show many to one

12.@JoinColumn(name = "post_id", nullable = false)
   how to map

13.@CreationTimestamp @UpdateTimestamp

14.@Repository 
   dao layer (jpaRepository<object, long>) 

15.@ManyToMany(fetch = FetchType.LAZY) @JoinTable 
   we dont use foreign key a lot in real project,we use Cascading 
     * sku和inventory是M:N的关系
     * 仓库ID，表示可以下单到哪些仓库
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "sku_inventory",
            joinColumns = @JoinColumn(name = "sku_id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_id"))
    private Set<PmsInventory> pmsInventories = new HashSet<>();
16.@PersistenceContext

17.@NamedQueries
@Entity
@NamedQueries({
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM 
Book b WHERE b.title =                :title"),
    @NamedQuery(name = "Book.findByPublishingDate", query = "SELECT 
b FROM Book b WHERE     b.publishingDate = :publishingDate")
})
public class Book implements Serializable {

18.@Query
Query("select p from Post p where p.id = :key or p.title = 
:title")
Post getPostByIDOrTitleWithJPQLNamedParameters(@Param("key") Long 
id,@Param("title") 
String title);

SQL语句中的变量以":"开头。
名称需与@Param("status")一致
然后JPA就会把userStatus中的只传递给status,userName的值传递给name

19.@Test
test class

20.@Transactional 