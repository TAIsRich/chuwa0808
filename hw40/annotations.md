##### Basic Setup

- SpringBootApplication

  It is a combination of three annotations **@EnableAutoConfiguration, @ComponentScan,** and **@Configuration**.

  一般放在主程序入口类之前。

  ```
  @SpringBootApplication
  public class DemoApplication
  ```

- Controller：类似下面的Service用法，在controller类之前加上。

- Service

  ```
  @Service
  public class PostServiceImpl implements PostService
  ```

- RestController

- RequestMapping：映射类到指定url

- Autowired：用在JavaBean中的注解，通过byType形式，用来给指定的字段或方法注入所需的外部资源

- PostMapping：映射方法到指定url

  ```
  @RestController
  @RequestMapping("/api/v1")
  public class PostController {
      @Autowired
      private PostService postService;
  
      @PostMapping("/posts")
      public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
          PostDto postResponse = postService.createPost(postDto);
          return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
      }
  }
  ```

- Entity

- Table

  ```
  @Entity
  @Table(
          name = "posts",
          uniqueConstraints = {
                  @UniqueConstraint(columnNames = {"title"})
          }
  )
  ```

- Id：主键，id

- GenerateValue：主键自增

- Column: 数据库列

- CreationTimestamp

- UpdateTimestamp

  ```
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "title", nullable = false)
  private String title;
  @CreationTimestamp
  private LocalDateTime createDateTime;
  
  @UpdateTimestamp
  private LocalDateTime updateDateTime;
  ```

  

