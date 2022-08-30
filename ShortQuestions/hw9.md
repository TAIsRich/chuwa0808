### 3. In postman, call of the APIs in PostController and CommentController.
- PostController
  - POST http://localhost:8080/api/v1/posts
```
  //Request Body:
  {
            "title": "redbook_updated_4",
            "description": "updated test4",
            "content": "updated_4"
}


//Response body:
{
    "id": 9,
    "title": "redbook_updated_4",
    "description": "updated test4",
    "content": "updated_4"
}

```
  - GET http://localhost:8080/api/v1/posts/9
```
//Response body:
{
    "id": 9,
    "title": "redbook_updated_4",
    "description": "updated test4",
    "content": "updated_4"
}
```

  - GET http://localhost:8080/api/v1/posts?pageNo=0&pageSize=10&sortBy=id
```
//Response body:
{
    "content": [
        {
            "id": 1,
            "title": "my first spring boot application",
            "description": "my first post api",
            "content": "my first root api is HTTP POST method"
        },
        {
            "id": 5,
            "title": "redbook_updated",
            "description": "updated test1",
            "content": "updated"
        },
        {
            "id": 7,
            "title": "redbook_updated_2",
            "description": "updated test2",
            "content": "updated_2"
        },
        {
            "id": 8,
            "title": "redbook_updated_3",
            "description": "updated test3",
            "content": "updated_3"
        },
        {
            "id": 9,
            "title": "redbook_updated_4",
            "description": "updated test4",
            "content": "updated_4"
        }
    ],
    "pageNo": 0,
    "pageSize": 10,
    "totalElement": 5,
    "totalPages": 1,
    "last": true
}
```

  - PUT http://localhost:8080/api/v1/posts/9
```
//Request Body:
{
    "title": "redbook_updated_4",
    "description": "updated test_for_the_hw9",
    "content": "updated_4"
}
//Response body:
{
    "id": 9,
    "title": "redbook_updated_4",
    "description": "updated test_for_the_hw9",
    "content": "updated_4"
}
```

  - DELETE http://localhost:8080/api/v1/posts/9
```
//Response body:
Post entity deleted successfully.
```

- CommentController
  - POST http://localhost:8080/api/v1/posts/1/comments

```
//Request Body:
{
    "name": "Skylar",
    "email": "Skylar@gmail.com",
    "body": "great job!"
}
//Response body:
{
    "id": 3,
    "name": "Skylar",
    "email": "Skylar@gmail.com",
    "body": "great job!"
}
```

  - GET http://localhost:8080/api/v1/posts/1/comments
```
[
    {
        "id": 1,
        "name": "Rick",
        "email": "rickarar@gmail.com and ijaigja@hotmail.com",
        "body": "nice post, keep do it"
    },
    {
        "id": 2,
        "name": "Li",
        "email": "li@gmail.com",
        "body": "aint like it"
    },
    {
        "id": 3,
        "name": "Skylar",
        "email": "Skylar@gmail.com",
        "body": "great job!"
    }
]
```

  - GET http://localhost:8080/api/v1/posts/1/comments/1
```
{
    "id": 1,
    "name": "Rick",
    "email": "rickarar@gmail.com and ijaigja@hotmail.com",
    "body": "nice post, keep do it"
}
```

  - PUT http://localhost:8080/api/v1/posts/1/comments/1
```
//Request Body:
{
    "name": "Rick",
    "email": "rickarar@gmail.com and ijaigja@hotmail.com",
    "body": "nice post, keep do it"
}

//Response Body:
{
    "id": 1,
    "name": "Rick",
    "email": "rickarar@gmail.com and ijaigja@hotmail.com",
    "body": "nice post, keep do it"
}
```
  
  - DELETE http://localhost:8080/api/v1/posts/1/comments/3
```
Comment deleted Successfully
```
### 4. what is JPA? and what is Hibernate?
- Java developers use lots of code, or use the proprietary framework to interact with the database, whereas using JPA, the burden of interacting with the database reduces significantly. It forms a bridge between object models (Java program) and relational models (database program).
- Java Persistence API is a collection of classes and methods to persistently store the vast amounts of data into a database which is provided by the Oracle Corporation.
- To reduce the burden of writing codes for relational object management, a programmer follows the ＆JPA Provider＊ framework, which allows easy interaction with database instance. Here the required framework is taken over by JPA.

- ORM tools like Hibernate, TopLink, and iBatis ***implements JPA specifications*** for data persistence.
- A Hibernate is a Java framework which is used to store the Java objects in the relational database system. It is an open-source, lightweight, ORM (Object Relational Mapping) tool.
- Hibernate is a framework which provides some abstraction layer, meaning that the programmer does not have to worry about the implementations, Hibernate does the implementations for you internally like Establishing a connection with the database, writing query to perform CRUD operations etc.
- It is a java framework which is used to develop persistence logic. Persistence logic means to store and process the data for long use. More precisely Hibernate is an open-source, non-invasive, light-weight java ORM(Object-relational mapping) framework to develop objects which are independent of the database software and make independent persistence logic in all JAVA, JEE.
### 5. What is Hiraki? what is the benefits of connection pool?
- HikariCP is solid high-performance JDBC connection pool. A connection pool is a cache of database connections maintained so that the connections can be reused when future requests to the database are required. Connection pools may significantly reduce the overall resource usage.
- The framework is so fast because the following techniques have been applied:
  - ***Bytecode-level engineering*** 每 some extreme bytecode level engineering (including assembly level native coding) has been done
  - ***Micro-optimizations*** 每 although barely measurable, these optimizations combined boost the overall performance
  - ***Intelligent use of the Collections framework*** 每 the ArrayList<Statement> was replaced with a custom class, FastList, that eliminates range checking and performs removal scans from head to tail
- HikariCP stands out because of these database properties. It's even advanced enough to detect connection leaks by itself.
### 6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.
- @OneToMany:
  - one-to-many mapping means that one row in a table is mapped to multiple rows in another table
  - For this example, we'll implement a cart system where we have a table for each cart and another table for each item. One cart can have many items, so here we have a one-to-many mapping.
  - The way we do it in code is with @OneToMany.
  - the @OneToMany annotation is used to define the property in Item class that will be used to map the mappedBy variable.
```
public class Cart {

    //...     
 
    @OneToMany(mappedBy="cart")
    private Set<Item> items;
	
    //...
}
```
- For example, if one department can employ for several employees then, department to employee is a one to many relationship (1 department employs many employees), while employee to department relationship is many to one (many employees work in one department).

- @ManyToOne
  - Based on the example above, We can also add a reference to Cart in each Item using @ManyToOne, making this a bidirectional relationship. Bidirectional means that we are able to access items from carts, and also carts from items.
  - the @ManyToOne annotation is associated with the Cart class variable. @JoinColumn annotation references the mapped column.
  - As we have seen in section 2, we can specify a many-to-one relationship by using the @ManyToOne annotation. A many-to-one mapping means that many instances of this entity are mapped to one instance of another entity 每 many items in one cart.
  - The @ManyToOne annotation lets us create bidirectional relationships too.
```
@Entity
@Table(name="ITEMS")
public class Item {
    
    //...
    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;

    public Item() {}
    
    // getters and setters
}
```

- @ManyToMany
  - A relationship is a connection between two types of entities. In the case of a many-to-many relationship, both sides can relate to multiple instances of the other side.
  - A student can like many courses, and many students can like the same course
  - s we know, in RDBMSs we can create relationships with foreign keys. Since both sides should be able to reference the other, we need to create a separate table to hold the foreign keys, Such a table is called a join table. In a join table, the combination of the foreign keys will be its composite primary key.
  - We should include a Collection in both classes, which contains the elements of the others. After that, we need to mark the class with @Entity and the primary key with @Id to make them proper JPA entities. Also, we should configure the relationship type. So, we mark the collections with @ManyToMany annotations:
```
@Entity
class Student {

    @Id
    Long id;

    @ManyToMany
    Set<Course> likedCourses;

    // additional properties
    // standard constructors, getters, and setters
}

@Entity
class Course {

    @Id
    Long id;

    @ManyToMany
    Set<Student> likes;

    // additional properties
    // standard constructors, getters, and setters
}
```
  - We can do this with the @JoinTable annotation in the Student class. We provide the name of the join table (course_like) as well as the foreign keys with the @JoinColumn annotations. The joinColumn attribute will connect to the owner side of the relationship, and the inverseJoinColumn to the other side:
```
@ManyToMany
@JoinTable(
  name = "course_like", 
  joinColumns = @JoinColumn(name = "student_id"), 
  inverseJoinColumns = @JoinColumn(name = "course_id"))
Set<Course> likedCourses;
```
  - Note that using @JoinTable or even @JoinColumn isn't required. JPA will generate the table and column names for us. However, the strategy JPA uses won't always match the naming conventions we use. So, we need the possibility to configure table and column names. On the target side, we only have to provide the name of the field, which maps the relationship. Therefore, we set the mappedBy attribute of the @ManyToMany annotation in the Course class:
```
@ManyToMany(mappedBy = "likedCourses")
Set<Student> likes;
```
### 7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?
- let＊s look at how this cascade type attribute is defined in our code for more clear understanding. Take a scenario where an employee can have multiple accounts, but one account must be associated with only one employee.
- Look at the bold line in the above source code for EmployeeEntity. It defines ※cascade=CascadeType.ALL§ and it essentially means that any change happened on EmployeeEntity must cascade to AccountEntity as well.
- If we save an employee, then all associated accounts will also be saved into the database. If you delete an Employee then all accounts associated with that Employee also be deleted. Simple enough !!
```
@Entity
@Table(name = "Employee")
public class EmployeeEntity implements Serializable
{
	private static final long serialVersionUID = -1798070786993154676L;
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private Integer           employeeId;
	@Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
	private String            firstName;
	@Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
	private String            lastName;

	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE_ID")
	private Set<AccountEntity> accounts;

	//Getters and Setters Hidden
}

@Entity
@Table(name = "Account")
public class AccountEntity implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer           accountId;
	@Column(name = "ACC_NO", unique = false, nullable = false, length = 100)
	private String            accountNumber;

	@ManyToOne (mappedBy="accounts",  fetch = FetchType.LAZY)
	private EmployeeEntity employee;

}
```
- The orphanRemoval option was introduced in JPA 2.0. This provides a way to delete orphaned entities from the database.
- Whenever we delete an employee, all his accounts will get deleted if we use the CascadeType.REMOVE. But if want that whenever we remove the relationship between an account and an employee, hibernate will check for the accounts in other references. If none is found, hibernate will delete the account since it＊s an orphan.
```
@OneToMany(orphanRemoval = true, mappedBy = "...")
```


- CascadeType.PERSIST : cascade type presist means that save() or persist() operations cascade to related entities.
- CascadeType.MERGE : cascade type merge means that related entities are merged when the owning entity is merged.
- CascadeType.REFRESH : cascade type refresh does the same thing for the refresh() operation.
- CascadeType.REMOVE : cascade type remove removes all related entities association with this setting when the owning entity is deleted.
- CascadeType.DETACH : cascade type detach detaches all related entities if a ※manual detach§ occurs.
- CascadeType.ALL : cascade type all is shorthand for all of the above cascade operations.
### 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?
- Sometimes you have two entities and there's a relationship between them. For example, you might have an entity called University and another entity called Student and a University might have many Students:
- The University entity might have some basic properties such as id, name, address, etc. as well as a collection property called students that returns the list of students for a given university:
```
public class University {
   private String id;
   private String name;
   private String address;
   private List<Student> students;

   // setters and getters
}
```
- Now when you load a University from the database, JPA loads its id, name, and address fields for you. But you have two options for how students should be loaded:

  1. To load it together with the rest of the fields (i.e. eagerly), or
  2. To load it on-demand (i.e. lazily) when you call the university's getStudents() method.
- When a university has many students it is not efficient to load all of its students together with it, especially when they are not needed and in suchlike cases you can declare that you want students to be loaded when they are actually needed. This is called lazy loading.
- Here's an example, where students is explicitly marked to be loaded eagerly:
```
@Entity
public class University {

    @Id
    private String id;

    private String name;

    private String address;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Student> students;

    // etc.    
}
```

- And here's an example where students is explicitly marked to be loaded lazily:
```
@Entity
public class University {

    @Id
    private String id;

    private String name;

    private String address;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Student> students;

    // etc.
}
```

- In order for lazy loading to work, the JDBC session must still be open when the target entities want to be loaded into the memory by invoking the getter method (e.g. getStudents()), but sometimes this is not possible, because by the time this method is called, the session is already closed and the entity detached. Similarly, sometimes we have a client/server architecture (e.g. Swing client/JEE server) and the entities/DTOs are transferred over the wire to the client and again most often in these scenarios lazy loading won't work due to the way the entities are serialized over the wire.
### 9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
- Default Naming Convention
  -  imagine we have a Person entity:
```
@Entity
public class Person {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}
```
  - We have a few names here that have to be mapped to the database. Well, Spring uses lower snake case by default, which means it uses only lower case letters and separates words with underscores. Therefore, the table creation query for the Person entity would be:
```
create table person (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id));
select first_name from person;
```
- Custom Naming Convention
  - We can also implement our own naming convention, Imagine we can't use the Spring lower snake case strategy, but we need to use upper snake case. Then, we'd need to provide an implementation of PhysicalNamingStrategy.
  - we're going to keep to snake case, the fastest option is to inherit from the SpringPhysicalNamingStrategy and turn identifiers to upper case:
```
public class UpperCaseNamingStrategy extends SpringPhysicalNamingStrategy {
    @Override
    protected Identifier getIdentifier(String name, boolean quoted, JdbcEnvironment jdbcEnvironment) {
        return new Identifier(name.toUpperCase(), quoted);
    }
}
```
  - We're just overriding the getIdentifier() method, which is in charge of turning the identifiers to lower case in the super-class. Here we're using it to convert them to upper case.
  - Once we've written our implementation, we must register it so that Hibernate knows to use it. Using Spring, this is done by setting the spring.jpa.hibernate.naming.physical-strategy property in our application.properties:
```
spring.jpa.hibernate.naming.physical-strategy=com.baeldung.namingstrategy.UpperCaseNamingStrategy
```

```
create table PERSON (ID bigint not null, FIRST_NAME varchar(255), LAST_NAME varchar(255), primary key (ID));

select FIRST_NAME from PERSON;
```

- Hibernate splits the mapping of the entity or attribute name to the table or column name into 2 steps:
  - It first determines the logical name of an entity or attribute. You can explicitly set the logical name using the @Table and @Column annotations. If you don＊t do that, Hibernate will use one of its implicit naming strategies.
  - It then maps the logical name to a physical name. By default, Hibernate uses the logical name as the physical name. But you can also implement a PhysicalNamingStrategy that maps the logical name to a physical one that follows your internal naming convention. Or, since Hibernate 5.5.4, you can activate Hibernate＊s CamelCaseToUnderscoresNamingStrategy.
  - So, why does Hibernate differentiate between a logical and a physical naming strategy, but the JPA specification doesn＊t?
  - JPA＊s approach works, but if you take a closer look at it, you recognize that Hibernate＊s approach provides more flexibility. By splitting the process into 2 steps, Hibernate allows you to implement a conversion that gets applied to all attributes and classes.
  - If your naming conventions, for example, require you to ad ※_TBL§ to all table names, you can do that in your PhysicalNamingStrategy. It then doesn＊t matter if you explicitly specify the table name in a @Table annotation or if you do it implicitly based on the entity name. In both cases, Hibernate will add ※_TBL§ to the end of your table name.
  - Explicit naming strategy: The explicit naming strategy is very easy to use. You probably already used it yourself. The only thing you need to do is annotate your entity class with @Table or your entity attribute with @Column and provide your preferred name as a value to the name attribute.

- Also, JPA would implement the method based on the column name in the table. On the condition that we need to follow the rule of naming convention while writing the method name.
- For instance, findByLastnameOrFirstname(a, b), which means the database has included the column name like lastname and firstname. The first parameter, "a," will invoke lastname, and the same for the second parameter, "b."
### 10. Add 2 more api /api/v1/posts/search?keyword=value in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

### 11. Check out a new branch(hw1_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.
