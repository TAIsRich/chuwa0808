| Annotations      | Description | 
| :---        |    ----:   |    
| @CreatedDate      | creat time inside a entity class, under springframework.data.annotation | 
| @LastModifiedDate   | update time inside a entity class, under springframework.data.annotation | 
| @CreationTimestamp      | creat time inside a entity class, under hibernate.annotations |
| @UpdateTimestamp      | update time inside a entity class, under hibernate.annotations |
| @Override |  indicates the method is override from super |    
| @Service |  Indicates that an annotated class is a "Service" |  
| @SpringBootApplication | Indicates a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning.  |
| @EnableMongoRepositories | Annotation to activate MongoDB repositories. |
| @Autowired | The @Autowired annotation marks a Constructor, Setter method, Properties and Config() method as to be autowired that is ‘injecting beans'(Objects) at runtime by Spring Dependency Injection mechanism |
| @Document | indicate this class is related document in mongodb |
| @Id | indicate it's a id |
| @Repository | Indicates that an annotated class is a "Repository", defined by as "a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects". |
| @RestController | A convenience annotation that is itself annotated with @Controller and @ResponseBody. |
| @RequestMapping | Annotation for mapping web requests onto methods in request-handling classes with flexible method signatures. |
| @PostMapping | Annotation for mapping HTTP POST requests onto specific handler methods. |
| @GetMapping | Annotation for mapping HTTP GET requests onto specific handler methods. |
| @PutMapping | Annotation for mapping HTTP PUT requests onto specific handler methods. |
| @DeleteMapping | Annotation for mapping HTTP Delete requests onto specific handler methods. |
| @RequestBody | Annotation indicating a method parameter should be bound to the body of the web request. |
| @PathVariable | Annotation which indicates that a method parameter should be bound to a URI template variable. Supported for RequestMapping annotated handler methods. |
| @OneToMany | it is used in list attributes of entity usually there will be mappedBy to map this one object and fetch type |
| @ManyToOne | used in a Object attribute and it will be used with JoinColmn(name="forgin_id")  |
| @ManyToMany | used in ManyToMany relationship, there will be a relationship table, @JoinTbale and @JoinColumn and @inverseJoinColumns |
| @Query | this annotation will execute sql or jpql, it also accept parameters |
| @NamedQuery | define a single query usually jpql | 
| @NamedQueries | define many NamedQuery togather |
| @Transaction | define this method or class as transactional, the whole can be seen as a unit |
| @EnableTransactionManagement | enable the transaction in spring boot application |
| @ControllerAdvice | provide a grobal exception handle |
| @Valid | check if the request body is obey the rule defined in playload class |
| @Bean | method level bean, usually under @COnfiguration |
| @Component | a normal spring bean: service, reposotory and controller are also component |
| @ComponentScan | will scan all the component and add them into ioc container |
| @Configuration | config class, it must have at least one @Bean method |
| @Primary | assign a primary impl class to inject |
| @Qualifier | assign a specific impl class to inject |
| @Aspect | using this annotation means this class is aspect(AOP), conbind advice and pointcuts |
| @Pointcut | pointcut means the position/aspect, usually the class or method  |
| @Around | around means this method will be executed before and after the pointcut |
| @Before | before means this medthod will run before the pointcut |
| @AfterReturning | AfterReturning means this method will run after the pointcut return |
| @AfterThrowing | AfterThrowing means this method will run after the pointcut throw exception |
| joinPoint | not annotation, but is important, joinpoint is a point of any place in program: the call of method, the execution of a constructor, the access of a field are all joinpoints |


| @JsonProperty | set json attribute name |
| @Value | e.g: @Value("${app.jwt-secret}") to get value from application.property |









