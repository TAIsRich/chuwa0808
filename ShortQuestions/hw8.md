### 2. how do you do the debug?
- At first, I usually check the console where the log at; if anything exception or error is placed, I'd set a breakpoint there and re-run the program to see what reason led to the error.
### 3. What is DTO, VO, Payload, DO?
- DTO is a class representing some data with no logic in it. DTO’s are usually used for transferring data between different applications or different layers within a single application. You can look at them as dumb bags of information the sole purpose of which is to just get this information to a recipient. A DTO does not have any explicit behavior. It basically helps in making the code loosely coupled by decoupling the domain models from the presentation layer. OOP environments rely on a system of "calls." Each one is a bit like a data lookup, and they require both time and processing speed. If you’re not careful, calls can also expose sensitive data you'd like to keep hidden. As one programmer explains, you might require an employee's name and photo to enter your company. You need to provide that data for a match, but you don't need to give other information about the employee that you have within your database. A DTO can transfer only the information required
- Value Object is a full member of your domain model. It conforms to the same rules as Entity. The only difference between Value Object and Entity is that Value Object doesn’t have its own identity. It means that two Value Objects with the same property set should be considered the same whereas two Entities differ even if their properties match. a value object is a small object that represents a simple entity whose equality is not based on identity: i.e. two value objects are equal when they have the same value, not necessarily being the same object. Examples of value objects are objects representing an amount of money or a date range.
- The Payload of an API Module is the body of your request and response message. It contains the data that you send to the server when you make an API request. You can send and receive Payload in different formats, for instance JSON.
- Data object is similar to payload and DTO
### 4. What is @JsonProperty("description_yyds")?
- The @JsonProperty annotation is used to map property names with JSON keys during serialization and deserialization. By default, if you try to serialize a POJO, the generated JSON will have keys mapped to the fields of the POJO. If you want to override this behavior, you can use the @JsonProperty annotation on the fields. It takes a String attribute that specifies the name that should be mapped to the field during serialization.
- We can also use this annotation during deserialization when the property names of the JSON and the field names of the Java object do not match.
```
public class PropertyDemoBean {
    @JsonProperty("person-id")
    public long personId = 123L;
    @JsonProperty("name")
    public String  name = "James Clark";

    @Override
    public String toString() {
        return "PropertyDemoBean{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                '}';
    }
}
```
### 5. do you know what is jackson?
- Jackson is mainly known as a library that converts JSON strings and Plain Old Java Objects (POJOs). It also supports many other data formats such as CSV, YML, and XML.
### 6. What is spring-boot-stater?
- Spring Boot Starters were introduced to solve this problem so that the developers can spend more time on actual code than Dependencies. Spring Boot Starters are dependency descriptors that can be added under the <dependencies> section in pom.xml.
    
    a. what dependecies in the below starter? do you know any starters?
    - the dependency below is Spring web
    - I also know the Spring Data JPA, MySQL Connector, Spring Data MongoDB etc.
```
<dependency> 
	<groupId>org.springframework.boot</groupId> 
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
### 7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
- Before spring 4.3, we have to use @RequestMapping to map three different HTTP requests by respective methods, such as:
```
@RequestMapping(value = "/users", method = RequestMethod.GET)
@RequestMapping(value = "/users", method = RequestMethod.POST)
@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
```
### 8. What is ResponseEntity? why do we need it?
- ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response.
- If we want to use it, we have to return it from the endpoint; Spring takes care of the rest.
- ResponseEntity is a generic type. Consequently, we can use any type as the response body
```
new ResponseEntity<>(postResponse, HttpStatus.OK);
new ResponseEntity<>(postResponse,
HttpStatus.CREATED);
ResponseEntity.ok(postService.getPostById(id));
```
- ResponseEntity provides two nested builder interfaces: HeadersBuilder and its subinterface, BodyBuilder. Therefore, we can access their capabilities through the static methods of ResponseEntity. The simplest case is a response with a body and HTTP 200 response code:
```
@GetMapping("/hello")
ResponseEntity<String> hello() {
    return ResponseEntity.ok("Hello World!");
}
```
### 9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
- The ResultSet object whose cursor moves only in one direction is known as forward only ResultSet. By default, JDBC result sets are forward-only result sets.
- You can move the cursor of the forward only ResultSets using the next() method of the ResultSet interface. It moves the pointer to the next row from the current position. This method returns a boolean value. If there are no rows next to its current position it returns false, else it returns true.
- Therefore, using this method in the while loop you can iterate the contents of the ResultSet object.
```
while(rs.next()){
}
```
### 10. What is the ORM framework?
- ORM stands for Object-Relational Mapping (ORM) is a programming technique for converting data between relational databases and object oriented programming languages
-  First of all, you hide the SQL away from your logic code. This has the benefit of allowing you to more easily support more database engines.
```
Person p = repository.GetPerson(10);
String name = p.FirstName;

Person p = Person.Get(10);

Person p = Person.Get(Person.Properties.Id == 10);
```
### 11. Learn how to use ObjectMapper by this example.
	a. https://github.com/TAIsRich/chuwa-eij-tutorial/blob/main/02-java-core/src/main/java/com/chuwa/exercise/oa/api/FoodOutletJackson.java
```
// converting a JSON String to a Java object using the ObjectMapper class
FoodOutlet foodOutlet = objectMapper.readValue(resBody, FoodOutlet.class);

//The methods writeValueAsString and writeValueAsBytes of ObjectMapper class generate a JSON from a Java object and return the generated JSON as a string or as a byte array
String s = objectMapper.writeValueAsString(foodOutlet);

//To read JSON into a JsonNode with Jackson, you start by creating a Jackson ObjectMapper instance. On the ObjectMapper instance you call readTree() passing the JSON source as parameter. Here is an example of deserializing JSON into a JsonNode
objectMapper.readTree() // learn how to use it?
```
### 12. What is the serialization and desrialization?
	a. https://hazelcast.com/glossary/serialization/
- Serialization is the process of converting a data object—a combination of code and data represented within a region of data storage—into a series of bytes that saves the state of the object in an easily transmittable form.
- The deserialization process recreates the object, thus making the data easier to read and modify as a native structure in a programming language.
### 13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```
 List<Integer> list = Arrays.asList(20, 3, 78, 9, 6, 53, 73, 99, 24, 32);
      double res = list.stream()
                    .mapToDouble(Integer::intValue)
                    .average()
                    .getAsDouble();
```
### 14. 抄写，https://github.com/TAIsRich/springbootredbook/tree/03_post_pageable，你也可以像我⼀样分branch添加新代码。
### 15. (Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comment你也可以像我⼀样分branch添加新代码。
### 16. (Optional) Try to write the CRUD api for a new application Cassandra-Blog
	a. spring 提供了相关dependency,(https://start.spring.io/)
		i. Spring Data for Apache Cassandra
	b. Cassandra⼗分流⾏，且⾯试问的多。



