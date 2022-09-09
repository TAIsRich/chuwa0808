Spring Boot general:

1.spring启动注解 @SpringbootApplication 

SpringApplication 这个类整合了其他框架的启动类, 只要运行这一个类,所有的整合
就都完成了.

@Configuration，它声明一个类作为bean的源定义
which declares a class as the source for bean definitions

@EnableAutoConfiguration，它允许应用程序添加 bean使用类路径定义
which allows the application to add beans 

@ComponentScan，它指示 Spring 在指定路径
which directs Spring to search for components in the path specified

Call the run function 调 用 run 函 数 , 将 当 前 启 动 类 的 字 节 码 传 入 ( 主 要 目 的 是 传 入
@SpringBootApplication 这个注解), 以及 main 函数的 args 参数.

Create an IOC container 通过获取当前启动类的核心信息, 创建 IOC 容器.

2.包扫描注解 @CompnonentScan

这个注解对应 Spring 的 XML 配置中的@ComponentScan，其实就是自动扫描并加
载符合条件的组件(比如@Component 和@Repository 等)或者 bean 定义, 最终将这些
bean 定义加载到 IoC 容器中.

3.重写方法 @override 

4.mapping to json

@JsonProperty(name), tells Jackson ObjectMapper to map the JSON property name to the annotated Java field's name. 

例：
   @JsonProperty("name")
   private String name;

5.测试：
@Test
test class


异常处理

1.响应状态
@ResponseStatus

2.@ExceptionHandler
Method Level used to handle the specific exceptions and sending the custom responses to the client

3.@ControllerAdvice
Class Levelto handle the exceptions globally


bean

1.定义bean注解 ：

Class level：@Component @Service @Repository @Controller

@Component 是任何 Spring 管理的组件的通用构造型。 @Service 在服务层注释类。 @Repository 在持久层注释类，它将充当数据库存储库。

Method level ：  @Bean(use with @Configuration)together

2.注入bean注解：


@Autowired match By Type > By Name
@Resource  match By Name > By Type

@Inject

3.设置bean优先级注解

We can use @Qualifier and @Primary for the same bean. Use @Qualifier to inject specific bean otherwise Spring injects bean by default which is annotated with @Primary


Controller层注解

1.@RestController is the combination of @Controller and @ResponseBody, a class is annotated with @RestController, and @ResponseBody no longer needs to be added to the data interface, which is more concise.

2.@RequestMapping, we all need to specify the path of the request.

3.@GetMapping, @PostMapping, @PutMapping, @DeleteMapping

例：
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

4.@Requestbody:the @RequestBody annotation maps the HttpRequest body to a transfer or domain object, enabling automatic deserialization of the inbound HttpRequest body onto a Java object

例：
@PostMapping("/request")
public ResponseEntity postController(@RequestBody LoginForm loginForm){
   exampleService.fakeAuthenticate(loginForm);
   return ResponseEntity.ok(HttpStatus.OK);
 }

5.@pathvariable ：@PathVariable annotation can be used to handle template variables in the request URI mapping, and set them as method parameters.

例：   
@GetMapping("/{id}")
public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
       return ResponseEntity.ok(postService.getPostById(id));
   }


Service层注解

1.@Service This annotation is used to mark the components of the business layer, we will process the business logic the class will add this annotations are given to the spring container. Aspects of transactions are also configured at this layer. When let this annotation is not required to be used. There is an annotation that refers to a general component. When we cannot determine the specific role, we can use the annotation that refers to a general component to be entrusted to the spring container.


dao层注解

1.use jpa @Repository
  dao layer (jpaRepository<object, long>)

2.自己实现 ：@PersistenceContext

3.@Transactional


entity层注解
1.@Entity @Table  @GeneratedValue @Column @Id are Database related annotations
 
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

2.@ManyToOne(fetch = FetchType.LAZY)
  tables and tables show many to one

3.@JoinColumn(name = "post_id", nullable = false)
  how to map

4.@CreationTimestamp @UpdateTimestamp

5.@ManyToMany(fetch = FetchType.LAZY) @JoinTable
  we dont use foreign key a lot in real project,we use Cascading
    * sku和inventory是M:N的关系
    * 仓库ID，表示可以下单到哪些仓库
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name = "sku_inventory",
           joinColumns = @JoinColumn(name = "sku_id"),
           inverseJoinColumns = @JoinColumn(name = "inventory_id"))
   private Set<PmsInventory> pmsInventories = new HashSet<>();

6.自己实现query语句
@NamedQueries
@Entity
 
@NamedQueries({
   @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM
Book b WHERE b.title =                :title"),
   @NamedQuery(name = "Book.findByPublishingDate", query = "SELECT
b FROM Book b WHERE     b.publishingDate = :publishingDate")
})
public class Book implements Serializable {

7.@Query
Query("select p from Post p where p.id = :key or p.title =
:title")
Post getPostByIDOrTitleWithJPQLNamedParameters(@Param("key") Long
id,@Param("title")
String title);
 
SQL语句中的变量以":"开头。
名称需与@Param("status")一致
然后JPA就会把userStatus中的只传递给status,userName的值传递给name
