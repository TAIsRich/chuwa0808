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