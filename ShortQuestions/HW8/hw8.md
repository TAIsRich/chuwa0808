1.  List all of the annotations you learned from class and homework to 
annotaitons.md

2.  Type the Comment feature for the class project.
database manytoone;
new excption(BlogAPIException):       
   if(!comment.getPost().getId().equals(post.getId())){
         throw new BlogAPIException(HttpStatus.BAD_REQUEST, "comment doee not belong to post");
      }

3.  In postman, call of the APIs in PostController and CommentController.

4.  what is JPA? and what is Hibernate?
A JPA (Java Persistence API) is a specification of Java which is used to access, manage, and persist data between Java object and relational database. It is considered as a standard approach for Object Relational Mapping.

JPA can be seen as a bridge between object-oriented domain models and relational database systems. Being a specification, JPA doesn't perform any operation by itself. Thus, it requires implementation. So, ORM tools like Hibernate, TopLink, and iBatis implements JPA specifications for data persistence.

A Hibernate is a Java framework which is used to store the Java objects in the relational database system. It is an open-source, lightweight, ORM (Object Relational Mapping) tool.

Hibernate is an implementation of JPA. So, it follows the common standards provided by the JPA.

5.  What is Hiraki? what is the benefits of connection pool?

Hikari is a JDBC DataSource implementation that provides a connection pooling mechanism. Compared to other implementations, it promises to be lightweight and better performing. 

Benefits of Using a Connection Pool:
Reduces the number of times new connection objects are created. Promotes connection object reuse. Quickens the process of getting a connection. Reduces the amount of effort required to manually manage connection objects.

6.  What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.
 one-to-many mapping means that one row in a table is mapped to multiple rows in another table.

 many-to-one mapping means that many instances of this entity are mapped to one instance of another entity

 @ManyToMany annotation can be used for specifying this type of relationships in Hibernate.

7. What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what 
are the other CascadeType and their features? In which situation we choose 
which one?

Entity relationships often depend on the existence of another entity, for example the Person–Address relationship. Without the Person, the Address entity doesn't have any meaning of its own. When we delete the Person entity, our Address entity should also get deleted.

Cascading is the way to achieve this. When we perform some action on the target entity, the same action will be applied to the associated entity.

CascadeType.ALL propagates all operations — including Hibernate-specific ones — from a parent to a child entity.

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Address> addresses;
}

8.  What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

EAGER loading of collections means that they are fetched fully at the time their parent is fetched. 

LAZY on the other hand means that the contents of the List are fetched only when you try to access them.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

it means when we call comment api , it shows post only showing id;

9.  What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

Spring Data JPA offers many features to use JPA in an application. Among those features, there's the standardization of table and column names in both DDL and DML queries.

we dont have to implement by ourselves

@Entity
public class Person {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
}

create table person (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id));

10. Add 2 more api  /api/v1/posts/search?keyword=value in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

11. Check out a new branch(hw1_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.

12. watch those videos(看一遍，能理解多少是多少。千万千万不要看其它的视频，会
走火入魔晕乎乎的)
a. Spring 简介： https://www.youtube.com/watch?v=l0MqsOADAUE&list=
PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=64
b. IOC/DI: https://www.youtube.com/watch?v=PyMxNr2p0C0&list=PLmO
n9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=65
c.  IOC container: https://www.youtube.com/watch?v=pLa77Tw-yyI&list=
PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=66
d.  Bean:
i.   https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PL
mOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=67
ii. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLm
On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=68
iii.  https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLm
On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=69
e.  DI: 
i.  https://www.youtube.com/watch?v=MgTpBST9onM&list=PLm
On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=70
ii. https://www.youtube.com/watch?v=yhEWZx2i1BA&list=PLm
On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=71
13. (Optional) use JDBC to read the data from database.