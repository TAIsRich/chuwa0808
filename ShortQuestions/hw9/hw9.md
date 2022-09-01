1.  List all of the annotations you learned from class and homework to annotaitons.md
2.  Type the Comment feature for the class project.
3.  In postman, call of the APIs in PostController and CommentController.
4.  what is JPA? and what is Hibernate?
	1. JPA use JDBC to CRUD database, and also transfer result from database to Java Entities
	2. Hibernate is ORM(object relational mapping) framework
5.  What is Hiraki? what is the benefits of connection pool?
	1. Hikari is the default DataSource implementation
	2. benefits is that you don't need to spend time to create and destroy after your task is done
6.  What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.
	1. OneToMany 1:M relationship means one company could hire many employee
	2. ManyToOne M:1 relationship means many employee could work for one company
	3. ManyToMany M:M means a relationship that can have many in another side
7. What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?
	1. cascade = CascadeType.ALL - all cascade operations on owning entity applied to related entity
	2. orphanRemoval = true - remove the record so it becomes orphan record
8.  What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?
	1. FetchType.LAZY - fetch post only don't fetch comment
	2. FetchType.EAGER - fetch post also fetch comment
9.  What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
	1. use keywords like and, or, by, find,between...
	2. includes database variable names in the name
	3. JPA can handle the functions as long as you use jpa naming conventions
	4. example: findByPostId
10. Add 2 more api  /api/v1/posts/search?keyword=value in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
11. Check out a new branch(hw1_jdbcTemplate) from branch 02_post_RUD, replace 
the dao layer using JdbcTemplate.
12. watch those videos(看一遍，能理解多少是多少。千万千万不要看其它的视频，会
走火入魔晕乎乎的)