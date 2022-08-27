2. how do you do the debug? 
* Check the logs in the console for the error information.
* Add breakpoints to code.

3. What is DTO, VO, Payload, DO?
- DTO: `Data Transfer Object`
    - A `Data Transfer Object` is an object that is used to encapsulate data, and send it from one subsystem of an application to another. 通常是前后端的传输, between View layer and Service layer.
- VO:
    - `Value Object` in DDD 领域模型
    - `View Object` in MVC
    - 视图对象，位于 View layer，只要是这个东西是让人看到的，这就叫 VO
    - 与 `DTO` 的区别:
        - 一个是字段不一样，VO 根据需要会删减一些字段
        - 另一个是值不一样，VO 会根据需要对 DTO 中的值进行展示业务的解释
- Payload:
    - We store `DTOs` in `payload` package.
    - `Payload` is the essential information in a data block that you send to or receive from the server when making API requests. The Payload can be sent or received in a variety of formats, including JSON.
    - 例如有一位客户需要支付一笔费用委托货车司机运送一车钢板，钢板本身的重量、车子的重量、司机的重量等等，这些都属于载重(load)。但是对于该客户来说，他关心的只有钢板的重量，所以钢板的重量是有效载重(payload，也就是付费的重量)。
- DO: `Data Object`
    - the same to `PO`（Persistant Object）持久对象
    - the same to `Entity` 实体

4. What is @JsonProperty("description_yyds")? 
* The content of the field with this annotion will be mapped from the "description_yyds" field passed by the JSON.

5. Do you know what is jackson? 
* Jackson is a very popular and efficient java based library to serialize or map java objects to JSON and vice versa. It is one such Java Json library used for parsing and generating Json files. It has built in Object Mapper class which parses json files and deserializes it to custom java objects. It helps in generating json from java objects.

6. What is spring-boot-starter?
* Spring Boot Starters are dependency descriptors that can be added under the <dependencies> section in pom. xml. There are around 50+ Spring Boot Starters for different Spring and related technologies. These starters give all the dependencies under a single name.

7. do you know @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD use this style?
* `@RequestMapping(value = "/users", method = RequestMethod.GET)`
* `@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)`
* `@RequestMapping(value = "/users", method = RequestMethod.DELETE)`

8. What is ResponseEntity? why do we need it?
* ResponseEntity represents the whole HTTP response: status code, headers, and body. As a result, we can use it to fully configure the HTTP response. If we want to use it, we have to return it from the endpoint; Spring takes care of the rest.
* We can use it to configure the HTTP response.

9. What is ResultSet in jdbc? and describe the flow how to get data using JDBC
* ResultSet Interface is present in the java.sql package. It is used to store the data which are returned from the database table after the execution of the SQL statements in the Java Program. The object of ResultSet maintains cursor point at the result data. In default, the cursor positions before the first row of the result data.
* Steps:
  1. Import the packages
  2. Open a connection
  3. Execute a query
  4. Extract Data
  5. Clean up the environment

10. What is the ORM framework? 
* An object-relational mapper (ORM) is a code library that automates the transfer of data stored in relational database tables into objects that are more commonly used in application code.

12. What is the serialization and desrialization?
* Serialization is a mechanism of converting the state of an object into a byte stream.
* Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory.

13. Use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
```java
List list = Arrays.asList(20, 3, 78, 9, 6, 53, 73, 99, 24, 32);
double res = list
        .stream()
        .mapToDouble(Integer::intValue)
        .average()
        .getAsDouble();

System.out.println(res);

```
