1. List all of the new annotations to your annotaitons.md and explain its role.

   https://github.com/TAIsRich/chuwa0808/tree/FranklinYao/hw40/annotations.md

2. how do you do the debug?

   - check console log
   - set breakpoints
   - print variables

3. What is DTO, VO, Payload, DO?

   - **Value Object** : Use when need to measure the objects' equality based on the objects' value.
   - **Data Transfer Object** : Pass data with multiple attributes in one shot from client to server across layer, to avoid multiple calls to remote server.
   - Payload: In simple words, the payload means body in the HTTP request and response message

4. What is `@JsonProperty("description_yyds")`?

   The @JsonProperty annotation is used to map property names with JSON keys during serialization and deserialization. By default, if you try to serialize a POJO, the generated JSON will have keys mapped to the fields of the POJO. If you want to override this behavior, you can use the @JsonProperty annotation on the fields. So in the example of `@JsonProperty("description_yyds")`, it maps "description" in POJO to "description_yyds" in JSON files.

5. do you know what is jackson?

   ```
   <dependency>
   <groupId>com.fasterxml.jackson.core</groupId>
   <artifactId>jackson-databind</artifactId>
   <version>2.13.3</version>
   <scope>compile</scope>
   </dependency>
   ```

   Jackson is a very popular and efficient java based library to serialize or map java objects to JSON and vice versa.

6. What is spring-boot-stater?

   Spring Boot Starters are dependency descriptors that can be added under the <dependencies> section in pom. xml. There are around 50+ Spring Boot Starters for different Spring and related technologies. These starters give all the dependencies under a single name.

   a. what dependecies in the below starter? do you know any starters?

   ```
   <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
   </dependency>
   ```

   spring-boot-starter-json

   spring-boot-starter-tomcat

7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?

   It maps URLs and https methods to methods in controllers.

   ```
   @RequestMapping(value = "/users", method = RequestMethod.POST)
   @RequestMapping(value = "/users", method = RequestMethod.GET)
   @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
   @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
   ```

8. What is ResponseEntity? why do we need it?
   ResponseEntity<> is a generic class with a type parameter, you can specify what type of object to be serialized into the response body. @ResponseBody is an annotation, indicates that the return value of a method will be serialized into the body of the HTTP response.

9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC

   ResultSet interface represents the result set of a database query.

   A ResultSet object maintains a cursor that points to the current row in the result set. The term "result set" refers to the row and column data contained in a ResultSet object.
   JDBC acts as an interface (not the one we use in Java) or channel between your Java program and databases i.e it establishes a link between the two so that a programmer could send data from Java code and store it in the database for future use. When you want to get data using JDBC, you first set up a connection with the database, then you send some SQL queries to JDBC which asks the DB for the data and then return the data to you. Then JDBC close the connection.

10. What is the ORM framework?

    Object-relational mapping (ORM) libraries provide this mapping of database tables to domain object classes. It translate between them.

11. Learn how to use ObjectMapper by this example.

12. What is the serialization and desrialization?

    Serialization is a mechanism of converting the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory. This mechanism is used to persist the object.

13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].

    ```
    public class test {
        public static void main(String[] args){
            List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
            Stream<Integer> st = integerList.stream();
            Double ave = st.mapToDouble(u -> u).average().getAsDouble();
            System.out.println(ave);
        }
    }
    ```

14. https://github.com/TAIsRich/chuwa0808/tree/FranklinYao/w3d1/demo/src/main/java/com/chuwa/demo