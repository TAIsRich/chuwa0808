### 2.  how do you do the debug? 
```
1. check the error message which points to the problem in your code
2. based on the information and your analysis, locate where the problem might be, mark the code, and start debug
3. step over each time to check if we are getting desired. if not, we found the bug
```

### 3. What is DTO, VO, Payload, DO?
```
DTO - Data Transfer Object, carries useful data between processes/systems
VO - Value Object, a small object holds values
Payload - contains the data that could be stored or updated (the body of your request and response message)
DO - Data object, a collection of one or more data points that create meaning as a whole.
```

### 4. What is @JsonProperty("description_yyds")?
```
The @JsonProperty annotation is used to map property names with JSON keys during serialization and deserialization. 
By default, if you try to serialize a POJO, the generated JSON will have keys mapped to the fields of the POJO 

description_yyds: Through JsonProperty, the API of key and value can be generated in the Controller layer first
At this time, it has not passed to the service layer and cannot be generated in the database
```

### 5. do you know what is jackson?
```
Jackson is a very popular and efficient java based library to serialize or map java objects to JSON and vice versa
```

### 6. What is spring-boot-stater? what dependecies in the below starter? do you know any starters?
```
Spring Boot Starters are dependency descriptors that can be added under the <dependencies> section in pom.xml. 
There are around 50+ Spring Boot Starters for different Spring and related technologies. 

The below starter is spring-boot-starter-web, which is for the web development. 
It by default uses Spring MVC, REST and Tomcat as a default embedded server.

spring-boot-starter-data-jpa
spring-boot-starter-data-mongodb
```

### 7. do you know  `@RequestMapping(value = "/users", method = RequestMethod.POST)` ? could you list CRUD by this style?
```
Use the @RequestMapping annotation to map different HTTP requests to their respective controller methods.

@RequestMapping(value = "/users", method = RequestMethod.POST)
@RequestMapping(value = "/users", method = RequestMethod.GEt)
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
```

### 8. What is ResponseEntity? why do we need it?
```
ResponseEntity represents the whole HTTP response: status code, headers, and body. 
We can use it to fully configure the HTTP response.
```

### 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
```
ResultSet represents the result set of a database query. A ResultSet object maintains a cursor that points to the current row in the result set. 

JDBC consists of 7 elements that are known as connection steps:
1	Import the package 
2	Load and Register the drivers 
3	Establish the connection 
4	Create the statement 
5	Execute the statement 
6	Process Result
7	Close/terminate
```

### 10. What is the ORM framework?
```
ORM stands for object–relational mapping. 
It is a programming technique for converting data between type systems using object-oriented programming languages.
```

### 12. What is the serialization and desrialization?
```
Serialization is the process of converting a data object — a combination of code and data represented within a region of data storage — into a series of bytes that saves the state of the object in an easily transmittable form.

The deserialization process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.
```

### 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32]
```
import java.util.*;

public class MyClass {
     public static void main(String[] args) {
        List<Integer> list = Arrays.asList(20, 3, 78, 9, 6, 53, 73, 99, 24, 32);
        
        double ans = list.stream()
            .mapToDouble(Integer :: intValue)
            .average()
            .getAsDouble();
    
        System.out.println(ans);
    }
}
```

```
import java.util.*;
import java.util.stream.IntStream;

public class MyClass {
     public static void main(String[] args) {
        IntStream stream = IntStream.of(20, 3, 78, 9, 6, 53, 73, 99, 24, 32);
        
        double ans = stream.average()
            .getAsDouble();
    
        System.out.println(ans);
    }
}
```
