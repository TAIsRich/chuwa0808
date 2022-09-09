### @CompnonentScan

One of the most important annotations in spring is @ComponentScan which is used along with the @Configuration annotation to specify the packages that we want to be scanned. @ComponentScan without arguments tells Spring to scan the current package and all of its sub-packages.

```http request
https://www.geeksforgeeks.org/spring-componentscan-annotation-with-example/
```

### @SpringbootApplication

Spring Boot @SpringBootApplication annotation is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. It’s same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.

```http request
https://www.digitalocean.com/community/tutorials/springbootapplication-springapplication
```

### @ExceptionHandler

The @ExceptionHandler is an annotation used to handle the specific exceptions and sending the custom responses to the client.
You can define the @ExceptionHandler method to handle the exceptions as shown. This method should be used for writing the Controller Advice class file.

```java
@ExceptionHandler(value = ProductNotfoundException.class)

public ResponseEntity<Object> exception(ProductNotfoundException exception) {
}
```

### @ControllerAdvice

You can use the following code to create @ControllerAdvice class to handle the exceptions globally

```java
package com.tutorialspoint.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
   public class ProductExceptionController {
}
```

### @Transactional

With transactions configured, we can now annotate a bean with @Transactional either at the class or method level:

```java
@Service
@Transactional
public class FooService {
    //...
}
```

### @Validated and @Valid

In Spring, we use @Valid annotation for method level validation. We also use it to mark a member attribute for validation. However, this annotation doesn't support group validation.

Groups help to limit the constraints applied during validation. One particular use case is UI wizards. In the first step, we may have a certain sub-group of fields. In the subsequent step, there may be another group belonging to the same bean. So we need to apply constraints on these limited fields in each step, but @Valid doesn't support this.

In this case, for group-level, we have to use Spring's @Validated, which is a variant of @Valid.  This is used at the method-level. For marking member attributes, we continue to use the @Valid annotation.

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