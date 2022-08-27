# 2 

打断点，具体看哪里出问题了

# 3

DTO: data transfer object, an object that carries data between processes.

VO: A Value Object or VO is an object such as java.lang.Integer that hold values (hence value objects)

DO: 跟上面差不多，叫法不一样

Payload: requestBody and responseBody, 每一个object也可以叫这个



# 4

@JsonProperty("description_yyds"): update the following column name to "description_yyds", and the old column name will be invalid.

# 5

jackson: 

- Jackson has been known as "the Java JSON library" or "the best JSON parser for Java". Or simply as "JSON for Java".

- Jackson is a suite of data-processing tools for Java

- 把Json转成Java, 通过很多filter，去提取里面的值

# 6

Spring Boot starters can help to reduce the number of manually added dependencies just by adding one dependency. So instead of manually specifying the dependencies just add one starter.

Here we use web, because we are doing a web application.

There are also many other types of starter, like tomcat, json, etc.

# 7

@RequestMapping(value = "/users", method = RequestMethod.POST) -- post一个user

@RequestMapping(value = "/users", method = RequestMethod.DELETE)

@RequestMapping(value = "/users", method = RequestMethod.PUT)

@RequestMapping(value = "/users", method = RequestMethod.GET)


# 8 What is ResponseEntity

Header+body+status for a response for a normal Http request

# 9 ResultSet

A table that representing the response of the query.



# 10 ORM framework

Object Relational Mapping framework -- A technique to convert data between the object model and relational database

# 12  serialization and desrialization

## Serialization, a process of, 

converting data (code + data represented within a region of data storage)

--> 

a series of bytes (saves the state of the object in an easily transmittable form)

## desrialization

a serios of bytes --> data object

Serialization and deserialization work together to transform/recreate data objects to/from a portable format.

Serialization enables us to save the state of an object and recreate the object in a new location.

# 13 

public class MyClass {
	public static void main(String[ ] args) {
	
		List<Integer> List = Arrays.asList(20, 3, 78, 9, 6, 53, 73, 99, 24, 32);

        double result = list.stream()
        .mapToDouble(Integer::intValue) 
        . average()
        .getAsDouble();

        System.out.println(result);
    }
}
