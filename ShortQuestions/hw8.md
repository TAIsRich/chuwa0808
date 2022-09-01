## HW8
### 1. List all of the new annotations to your annotaitons.md and explain its role.
```
See Annotations.md
```

### 2. how do you do the debug?
```
First look at error information and then dive deep into the line code has problem.
Set break point and run in debug mode.
Use step into, step over, and see the info to debug
```

### 3. What is DTO, VO, Payload, DO?
Data transfer object (DTO), formerly known as value objects or VO, is a design pattern used to transfer data between software application subsystems. DTOs are often used in conjunction with data access objects to retrieve data from a database.
VO-it is value of object .if you want to retrive the data from db or some resource then we can use value of object
The payload is used by the REST API to pass and return data structures. It is used when the data is too large to be passed as a parameter. The input payload is a filter definition passed in the request to test result resources. The output payload is a set of test results. Payloads have a predefined structure to easily create, consume, manipulate and present by the client tools.
DO: data object. The data object is actually a location or region of storage that contains a collection of attributes or groups of values that act as an aspect, characteristic, quality, or descriptor of the object. A vehicle is a data object which can be defined or described with the help of a set of attributes or data.


### 4. What is @JsonProperty("description_yyds")?
```
@JsonProperty is used to mark non-standard getter/setter method to be used with respect to json property.
```

### 5. do you know what is jackson?
<dependency>
<groupId>com.fasterxml.jackson.core</groupId>
<artifactId>jackson-databind</artifactId>
<version>2.13.3</version>
<scope>compile</scope>
</dependency>

```
Jackson is a very popular and efficient java based library to serialize or map java objects to JSON and vice versa.
```

### 6. What is spring-boot-starter?
a. what dependecies in the below starter? do you know any starters?
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>

```
Spring Boot Starters are dependency descriptors that can be added under the <dependencies> section in pom.xml. There are around 50+ Spring Boot Starters for different Spring and related technologies. These starters give all the dependencies under a single name. For example, if you want to use Spring Data JPA for database access, you can include spring-boot-starter-data-jpa dependency. 

For example a, the dependency is spring-boot-starter-web
Others like: spring-boot-starter-tomcat
	Spring-boot-starter-json
```

### 7. do you know @RequestMapping(value = "/users", method =
RequestMethod.POST) ? could you list CRUD by this style?

```
“@RequestMapping annotation maps the incoming HTTP request to the controller method that will serve this request, we can apply @RequestMapping on a class as well as a method. When used on a class, it maps a specific request path or pattern onto a controller, then the method level annotation will make the mappings more specific to handler methods.”
The above example is to define a post method, with /users

@RequestMapping(method = RequestMethod.GET)
@RequestMapping(method = RequestMethod.PUT)
@RequestMapping(method = RequestMethod.POST)
@ReqeuestMapping(method = RequestMethod.DELETE)
```



### 8. What is ResponseEntity? why do we need it?
new ResponseEntity<>(postResponse, HttpStatus.OK);
new ResponseEntity<>(postResponse,
HttpStatus.CREATED);
ResponseEntity.ok(postService.getPostById(id));

```
ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response.

```

### 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
```
ResultSet interface represents the result set of a database query.
A ResultSet object maintains a cursor that points to the current row in the result set. The term "result set" refers to the row and column data contained in a ResultSet object.
The steps is in follow:
1.	Load Driver
2.	Connect to Database
3.	Define sql statement
4.	Create a statement object
5.	Use stmt object to execute sql statement
6.	Get ResultSet’s data to java object
7.	Close connections and other resource
```

### 10. What is the ORM framework?
```
ORM stands for Object-Relational Mapping (ORM) is a programming technique for converting data between relational databases and object oriented programming languages such as Java, C#, etc.
```

### 11. Learn how to use ObjectMapper by this example.
a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-cor
e/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java
FoodOutlet foodOutlet =
objectMapper.readValue(resBody, FoodOutlet.class);
String s =
objectMapper.writeValueAsString(foodOutlet);
objectMapper.readTree() // learn how to use it?

```
The methods writeValueAsString of ObjectMapper class generate a JSON from a Java object and return the generated JSON as a string.
Eg: String carAsString = objectMapper.writeValueAsString(car);

The method readValue() converting a JSON String to a Java object
Eg: String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }"; 
Car car = objectMapper.readValue(json, Car.class);
```

### 12. What is the serialization and desrialization?
a.	https://hazelcast.com/glossary/serialization/
```
Serialization is the process of converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form. In this serialized form, the data can be delivered to another data store (such as an in-memory computing platform), application, or some other destination.

The reverse process—constructing a data structure or object from a series of bytes—is deserialization. The deserialization process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.
```

### 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```
        List<Integer> nums = Arrays.asList(20, 3, 78, 9, 6, 53, 73, 99, 24, 32);
        double res = nums.stream()
            .mapToDouble(Integer::intValue)
            .average()
            .getAsDouble();
```

### 14. 抄写，https://github.com/TAIsRich/springbootredbook/
tree/03_post_pageable，你也可以像我⼀样分branch添加新代码。
### 15. (Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comm
ent你也可以像我⼀样分branch添加新代码。

### 16. (Optional) Try to write the CRUD api for a new application Cassandra-Blog
a. spring 提供了相关dependency,(https://start.spring.io/)
i. Spring Data for Apache Cassandra
b. Cassandra⼗分流⾏，且⾯试问的多。
```
See attached
```
