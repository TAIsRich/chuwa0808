## HW9
### 1. List all of the annotations you learned from class and homework to
annotaitons.md
```
See attached
```
### 2. Type the Comment feature for the class project.

### 3. In postman, call of the APIs in PostController and CommentController.

### 4. what is JPA? and what is Hibernate?
```
JPA is a standard of Object Relational Mapping. It is an interface that defines a set of
annotations for creating the object relational mapping.
The most popular ORM framework is Hibernate
```
### 5. What is Hikari? what is the benefits of connection pool?
```
Hikari is a JDBC DataSource implementation that provides a connection pooling mechanism.
Compared to other implementations, it promises to be lightweight and better performing
The benefits of connection pool:
Reduces the number of times new connection objects are created.
Promotes connection object reuse. Quickens the process of getting a connection.
Reduces the amount of effort required to manually manage connection objects.
```
### 6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.
```
@OneToMany a relationship that links one entity to many other entities
In our example, this would be a Teacher and their Courses. A teacher can give multiple courses, but a course is given by only one teacher (that's the Many-to-One perspective - many courses to one teacher).

@Entity
public class Teacher {
    private String firstName;
    private String lastName;
}@Entity
public class Course {
    private String title;
}
@OneToMany
@JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID")
private List<Course> courses;
Using this annotation will tell JPA that the COURSE table must have a foreign key column TEACHER_ID that references the TEACHER table's ID column.

We could’ve made Course the owning side of the relationship by mapping the Teacher field with @ManyToOne in the Course class instead:
@ManyToOne
@JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID")
private Teacher teacher;

Many-to-Many relationship involves a middle table referencing both other tables.

Refer to: 

https://ankitkamboj18.medium.com/a-guide-to-jpa-with-hibernate-relationship-mappings-onetoone-onetomany-manytoone-310ce31df3f6

```
### 7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what
are the other CascadeType and their features? In which situation we choose
which one?
```
CascadeType.ALL means all cascade operations on owning entity applied to related entity
orphanRemoval=true means child entity should be removed automatically by the ORM if it's no longer referenced by a parent entity, eg. we have a collection of items and we remove one of them. That item does not have a reference now and it will be removed. Be careful, not to mix it up with cascadeType which are database level operations.

JPA Cascade Types
Persist			Owning entity saved  => related entity saved
Merge			Owning entity merged => related entity merged
Refresh		Owning entity refreshed => related entity refreshed
Remove		Owning entity removed => related entity removed
Detach		Owing entity manually detached => related entity detached
All		  	All cascade operations on owning entity applied to related entity
```
### 8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the
difference? In which situation you choose which one?
```
There are two ways in which data is loaded: eager and lazy. Eager fetch
means that when a record is fetched from the database, all the
associated records from related tables are also fetched. So if we fetch a
tournament record, all the registrations for the tournament are also
fetched.
Eager fetch is the default fetch type used by Hibernate but it is not
always the most efficient. Lazy fetch on the other hand, fetches the
records only when they are needed.
FetchType.Lazy
If we don't need data from comment, JPA doesn't fetch it
Onyly fetch data from post
when we need data from comment, then JPA fecth comment data
FetchType.Eager
when we fetch post, JPA also fetch comment at the same time.
```
### 9. What is the rule of JPA naming convention? Shall we implement the method by
ourselves? Could you list some examples?
```
Default naming convention: Spring uses lower snake case by default, which means it uses only lower case letters and separates words with underscores.
Eg: firstName in field will be first_name in database column.
The documentation about the JpaRepository method naming convention is available here :
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

Key points :
•	“Order by” is represented by the keyword “OrderBy”, followed by the name of the entity member variable. Keyword “Asc” and “Desc” indicates the sort direction. You can sort by multiple columns by specifying each colum and its sort direction.
Ex : findByDossierOrderByDateAscIdAsc(Dossier dossier)
```
### 10. Add 2 more api /api/v1/posts/search?keyword=value in your class project. In
the repository layer, you need to use the naming convention to use the method
provided by JPA.
```
See attache
```
### 11. Check out a new branch(hw1_jdbcTemplate) from branch 02_post_RUD, replace
the dao layer using JdbcTemplate.
```
See attached
```
### 12. watch those videos(看⼀遍，能理解多少是多少。千万千万不要看其它的视频，会⾛⽕⼊魔晕乎乎的)
a. Spring 简介： https://www.youtube.com/watch?v=l0MqsOADAUE&list=
PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=64
b. IOC/DI: https://www.youtube.com/watch?v=PyMxNr2p0C0&list=PLmO
n9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=65
c. IOC container: https://www.youtube.com/watch?v=pLa77Tw-yyI&list=
PLmOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=66
d. Bean:
i. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PL
mOn9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=67
ii. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLm
On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=68
iii. https://www.youtube.com/watch?v=OpgMHzM7tgQ&list=PLm
On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=69
e. DI:
i. https://www.youtube.com/watch?v=MgTpBST9onM&list=PLm
On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=70
ii. https://www.youtube.com/watch?v=yhEWZx2i1BA&list=PLm
On9nNkQxJFbsU4Qz8CdRiVM4Qs3ci75&index=71

### 13. (Optional) use JDBC to read the data from database.
