# For entity
1. @Entity -- make the class as a entity, will be used to map with actual database
2. @Table -- name the table, and can add constrains to the table, 
3. @UniqueConstraint(columnNames = {"title"} -- title name in the table can't have duplicate
4. @Id -- mark primary key
5. @GeneratedValue -- primary key建立的策略，比如(strategy = GenerationType.IDENTITY) 
6. @Column -- specify the information for this column, like name, or if the column can be null
- (name = "title", nullable = false), title 不能为空
7. @CreateTimeStamp -- 建立时间戳
8. @UpdateTimeStamp -- update时间点


# For controller
1. @Controller -- make the class a web component
2. @RestController -- = @Controller + @response
3. @RequestMapping ("api/v1/posts")-- 定义具体的地址, define REST API, such as HTTP URL, method, etc
4. @Autowired -- dependency injection, injection只限于constructor / filed
- private String string, 只new object, 没有赋值，将生成的object放在IoC container里面，跟sessionFactory不一样，sessionFactory是在hibernate里面的
5. @PostMapping -- 
6. @RequestBody -- Convert the request body in the http request to a backend object, usually as JSON format
7. @ResponseBody -- use on a method to indicate that the return value should be written straight to the HTTP response body, and it will be automatically convert to json format
8. 

