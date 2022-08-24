Annotations

### Spring Framework Annotations

- spring core annotations

  1. **DI-Related Annotations**

     a. @Autowired Annotation

     - @Autowired annotation is applied to the **fields, setter methods, and constructors**. It injects object dependency implicitly. We use **@Autowired** to mark the dependency that will be injected by the Spring container.

     - ``` java
       class Student {
         //field injection
         @Autowired
       	Address address
           
         //constructor injection
         @Autowired
         Student(Address address) {
           this.address = address;
         }
         
         //setter injection
         @Autowired
         void setAddress(Address address) {
           this.address = address;
         } 
       ```
  
- spring mvc web annotations
  
  1. @Controller - marks the class as a web controller, capable of handling the HTTP requests. Spring will look at the methods of the class marked with the @Controller annotation and establish the routing table to know which methods serve which endpoints.
  
     ``` java
     @Controller
     public class BooksController {
     }
     ```
  
  2. @ResponseBody - The @ResponseBody is a utility annotation that makes Spring bind a method's return value to the HTTP response body. When building a JSON endpoint, this is an amazing way to magically convert your objects into JSON for easier consumption.
	
     ``` java
	   public class BooksController {
       @PostMapping
	     public Employee getBooksByName(@RequestBody Employee e){}
     }
     ```
  
  3. @RestController - Then there's the @RestController annotation, a convenience syntax for @Controller and @ResponseBody together. This means that all the action methods in the marked class will return the JSON response.
  
     ``` java
     @RestController
     public class PostController {
     }
     ```
  
  4. @RequestMapping(method = RequestMethod.GET, value = "/path") - The @RequestMapping(method = RequestMethod.GET, value = "/path") annotation specifies a method in the controller that should be responsible for serving the HTTP request to the given path. Spring will work the implementation details of how it's done. You simply specify the path value on the annotation and Spring will route the requests into the correct action methods.
  
     ``` java
     public class BooksController {
       @RequestMapping(value = "/{name}". metthod = RequestMethod.GET)
       public Employee getBooksByName(){}
     }
     ```
  
  5. @PathVariable("placeholderName") - Another common way to provide information to the backend is to encode it in the URL. Then you can use the @PathVariable("placeholderName") annotation to bring the values from the URL to the method arguments.
  
     ``` java
     @PutMapping("/{id}")
     public PostDto updatePostById(@PathVariable(name = "id") long id) {
        return postService.updatePost(id);
     }
     ```
  
  6. Composed @ RequestMapping Variants
  
    1. @GetMapping 
  
       This annotation is used for mapping HTTP GET requests onto specific handler methods. @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
  
       ``` java
       @GetMapping("/{id}")
       public PostDto getPostById(@PathVariable(name = "id") long id) {
          return null;
       }
       ```
  
    2. @PostMapping
      This annotation is used for mapping HTTP POST requests onto specific handler methods. @PostMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST)
  
      ``` java
      @PostMapping
      public PostDto createP() {
         return null;
      }
      ```
  
    3. @PutMapping
      This annotation is used for mapping HTTP PUT requests onto specific handler methods. @PutMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PUT)
  
      ``` java
      @PutMapping("/{id}")
      public PostDto updatePostById(@PathVariable(name = "id") long id) {
         return postService.updatePost(id);
      }
      ```
  
    4. @PatchMapping
      This annotation is used for mapping HTTP PATCH requests onto specific handler methods. @PatchMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PATCH)
  
    5. @DeleteMapping
      This annotation is used for mapping HTTP DELETE requests onto specific handler methods. @DeleteMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.DELETE)
  
      ``` java
      @DeleteMapping("/{id}")
      public PostDto deletePostById(@PathVariable(name = "id") long id) {
         return null;
      }
      ```


- spring Framework stereotype annotations
  1. @Controller
    The @Controller annotation is used to indicate the class is a Spring controller. This annotation can be used to identify controllers for Spring MVC or Spring WebFlux.
  
  2. @Service
    This annotation is used on a class. The @Service marks a Java class that performs some service, such as execute business logic, perform calculations and call external APIs. This annotation is a specialized form of the @Component annotation intended to be used in the service layer.

    ``` java
    @Service
    public class TestService {
      public void service1(){}
    }
    ```
  
  3. @Repository
    This annotation is used on Java classes which directly access the database. The @Repository annotation works as marker for any class that fulfills the role of repository or Data Access Object.
  
     This annotation has a automatic translation feature. For example, when an exception occurs in the @Repository there is a handler for that exception and there is no need to add a try catch block.
  
    ``` java
    @Repositoty
    public class TestRepository {
      public void delete()
    }
    ```
  
      

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  

  