### Annotions

```
@componnent
The @Component annotation is the most common method of defining beans.

@Component
public class Vehicle {
}

@Autowired
The @Autowired annotation tells Spring to find and inject a collaborating bean into another. If more than one bean of the same type is available, Spring throws an error. In the following scenario, two beans of type Operator are detected by Spring:

@Component
class Arithmetic(){
@Autowired
private Operator operator;
//...
}
@Component
class Addition implements Operator {
}
@Component
class Subtraction implements Operator {
}


@Entity - it is a enity, will be used to map with database
@Table - will be used to locate the database table name
@Id - this column is a primary key
@GeneratedValue - 主键⾃增的策略
@Column - specify the informaiton for this column, like name in database, can be null or not in database

## Entity

### @Entity

It identifies that a class is an entity class and and is mapped to a database table.

```java
@Entity
public class Post{

}
```

### @Table

The `@Table` annotation specifies the name of the database table `posts` to be used for mapping.

```java
@Entity
@Table(name = "posts", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title"})
})
public class Post {

}

```

### @Id

The `@Id` annotation specifies the primary key of an entity.

```java
@Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
```

### @GeneratedValue

The `@GeneratedValue` annotation is used to specify the primary key generation strategy to use.

- `GenerationType.TABLE`
- `GenerationType.SEQUENCE`
- `GenerationType.IDENTITY`
- `GenerationType.AUTO`: If we don't explicitly specify a value, the generation type defaults to AUTO.

### @Column

The `@Column` annotation is used for adding the column name in the table of the MySQL database. We can set name, nullable, unique, length...

```java
@Column(name = "title", nullable = false)
    private String title;
```

### @CreationTimestamp

Helps automatically save the creation timestamp to the column of the table.

### @UpdateTimestamp

Helps automatically save and update the update timestamp to the column of the table.

### @JsonProperty

used to map property names with JSON keys during serialization and deserialization.

```java
public class Comment {
    // ...

    @JsonProperty("name")
    private String name;
}
```

### @ManyToOne

means that mutiple rows in a table is mapped to one row in another table.

```java
public class Comment {
    // ...

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

}
```

### @OneToMany

means that one row in a table is mapped to multiple rows in another table.

```java
public class Post {
    // ...

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<Comment> comments = new HashSet<>();
}

```

### @JoinColumn

marks a column as a join column for an entity association or an element collection.

---

## DAO

### @Repository

`@Repository` Annotation is a specialization of `@Component` annotation which is used to indicate that the class provides CRUD operation on objects.

```java
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
```

---

## Service

### @Service

- In an application, the business logic resides within the service layer so we use the `@Service` Annotation to indicate that a class belongs to that layer.
- It is also a specialization of `@Component` Annotation like the `@Repository` Annotation.
- One most important thing about the `@Service` Annotation is it can be applied only to classes. It is used to mark the class as a service provider.

```java
@Service
public class PostServiceImpl implements PostService {

}
```

---

## Controller

### @RestController

- This annotation is used at the class level and allows the class to handle the requests made by the client.
- `@RestController` allows to handle all REST APIs, like CRUD.

```java
@RestController
@RequestMapping("/api/posts")
public class PostController {

}
```

### @RequestMapping

- `@RequestMapping` is used to map HTTP requests to handler methods of MVC and REST controllers.
- The `@RequestMapping` annotation can be applied to class-level and/or method-level in a controller.

### @PostMapping

`@PostMapping` is used for handling the post request that is made by the client containing the JSON data in the header

```java
@PostMapping
public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {

    }
```

### @GetMapping

Annotation for mapping HTTP GET requests onto specific handler methods.

```java
@GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }
```

```java
@GetMapping
    public PostResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir
    ) {
        return postService.getAllPost(pageNo, pageSize, sortBy, sortDir);
    }
```

### @PutMapping

Annotation for mapping HTTP PUT requests onto specific handler methods.

```java
@PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name = "id") long id) {
        PostDto postResponse = postService.updatePost(postDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }
```

### @DeleteMapping

Annotation for mapping HTTP DELETE requests onto specific handler methods.

```java
@DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePostById(id);
        return new ResponseEntity<>("Post entity deleted successfully.", HttpStatus.OK);
    }
```

---

## Other

### @Autowired

- `@Autowired` allows Spring to resolve and inject collaborating beans into our bean.
- By declaring all the bean dependencies in a Spring configuration file, Spring container can autowire relationships between collaborating beans. This is called Spring bean autowiring.
- After enabling annotation injection, we can use autowiring on properties, setters, and constructors.

```java

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;
}

```



