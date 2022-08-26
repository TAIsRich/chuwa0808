1. List all of the new annotations to your annotaitons.md and explain its role.
    @GetMapping
        The GetMapping annotation is used to process HTTP GET requests and map requests to specific processing methods.
    @PutMapping
        The PutMapping annotation is used to process HTTP PUT requests and map requests to specific processing methods
    @DeleteMapping
        The DeleteMapping annotation is used to handle HTTP DELETE requests and map requests to delete methods.
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
        The ResponseStatus annotation can annotate the request processing method. Using this annotation, the HTTP STATUS required for the response can be specified. In particular, we can use the HttpStauts class to assign values to the value attribute of this annotation.

2. how do you do the debug?
    Use the debug button of the IDE, breakpoints, see the error message, google

3. What is DTO, VO, Payload, DO?
    DTO is data transfer object, VO is view object, They are used to transfer data between Controller and DAO. They have different names in different business logic, but the functions are similar. Usually their package is Payload.
    DO is data object. It corresponds to a table in the database

4. What is @JsonProperty("description_yyds")?
    The JsonProperty annotation is used on properties to serialize the name of the property to another name. In this example, use description_yyds to declare description in Json.

5.  do you know what is jackson?
    Spring Boot provides integration with three JSON mapping libraries: Gson, Jackson and JSON-B.Jackson is the preferred default library.

6.  What is spring-boot-starter? 
    Spring Boot Starters are dependency descriptors that can be added under the <dependencies> section in pom. xml.
    a. what dependecies in the below starter? do you know any starters?
<dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot</artifactId>
      <version>2.7.3</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-autoconfigure</artifactId>
      <version>2.7.3</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-logging</artifactId>
      <version>2.7.3</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>jakarta.annotation</groupId>
      <artifactId>jakarta.annotation-api</artifactId>
      <version>1.3.5</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>5.3.22</version>
      <scope>compile</scope>
    </dependency>
    <dependency>
      <groupId>org.yaml</groupId>
      <artifactId>snakeyaml</artifactId>
      <version>1.30</version>
      <scope>compile</scope>
    </dependency>
</dependencies>


7. do you know  @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
    C: post
    U: put @RequestMapping(value = "/user",method = RequestMethod.PUT)
    R: get @RequestMapping(value = "/user",method = RequestMethod.GET)
    D: delete @RequestMapping(value = "/user",method = RequestMethod.DELETE)

8.  What is ResponseEntity? why do we need it?
    ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response. If we want to use it, we have to return it from the endpoint; Spring takes care of the rest. ResponseEntity is a generic type.

9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
    ResultSet interface represents the result set of a database query.
    1. Import JDBC packages.
    2. Load and register the JDBC driver.
    3. Open a connection to the database.
    4. Create a statement object to perform a query.
    5. Execute the statement object and return a query resultset.
    6. Process the resultset.
    7. Close the resultset and statement objects.
    8. Close the connection.

10. What is the ORM framework?
    Object relational mapping in computer science is a programming technique for converting data between type systems using object-oriented programming languages.

12. What is serialization and deserialization.
    Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory. 

13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]
    Stream<Integer> y = Stream.of(10, 0, 90, 86, 47, 24, 18, 73, 64, 55);
    x = y.mapToDouble(Integer::intValue).average().getAsDouble();
    System.out.println(x);