1.  List all of the new annotations to your annotaitons.md and explain its role.
2.  how do you do the debug?
	1. check the error code and google the error message
3.  What is DTO, VO, Payload, DO?
	1. DTO - data transfer object
	2. View Object
	3. DO - data object
	4. basically the same thing with different name
4.  What is @JsonProperty("description_yyds")?
	1. modify the variable name to "description_yyds"
5.  do you know what is jackson?
	1. Jackson is spring boot data mapping tools
6.  What is spring-boot-stater? 
	1. spring-boot-stater helps to add <dependencies> to project
	a. what dependecies in the below starter? do you know any starters?
		1. spring-boot-starter-web
		2. mysql-connector-java
7. do you know  @RequestMapping(value = "/users", method = RequestMethod.POST) ? could you list CRUD by this style?
	1. Defined path "/users" and this is a Post method
	2. @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
8.  What is ResponseEntity? why do we need it?
	1. ResponseEntity creates a httpResponse and map a object to it.
	2. we need it to return values back to client after client request call
9.  What is ResultSet in jdbc? and describe the flow how to get data using JDBC
	1. jdbc ResultSet used to store data from the database and use it in java program
	2. Simply call the variable in entity class, which mapped to database
10. What is the ORM framework?
	1. Object relational mapping framework
	2. Maps variables with database
11. Learn how to use ObjectMapper by this example.
	1. ObjectMapper can transfer between json and jsonObject
	2. `objectMapper.readValue(<responseBody>,<object.class>)`
	3. `objectMapper.writeValueAsString(<object>)`
12. What is the serialization and desrialization?
	a. https://hazelcast.com/glossary/serialization/
		1. serialization - convert data to a format that easy to transmit
		2. desrialization - recreates the object to make data easier to read and write
13. use stream api to get the average of the array [20, 3, 78, 9, 6, 53, 73, 99, 24, 32].
	1. `List<Integer> list = arrays.asList(20, 3, 78, 9, 6, 53, 73, 99, 24, 32);`
	2. `list.stream().mapToInt(i -> i).sum().average();`
14. 抄写，https://github.com/TAIsRich/springboot-redbook/tree/03_post_pageable，你也可以像我一样分branch添加新代码。
15. (Optional) 抄写 https://github.com/TAIsRich/springboot-redbook/tree/04_comment你也可以像我一样分branch添加新代码。
16. (Optional) Try to write the CRUD api for a new application Cassandra-Blog
	a. spring 提供了相关dependency,(https://start.spring.io/)
		i.  Spring Data for Apache Cassandra
	b. Cassandra十分流行，且面试问的多。
