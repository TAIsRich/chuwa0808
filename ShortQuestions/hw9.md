1. List all of the annotations you learned from class and homework to 
annotaitons.md

2.  Type the Comment feature for the class project.


3.  In postman, call of the APIs in PostController and CommentController.


4.  what is JPA? and what is Hibernate?
    JPA is the Java Persistence API. It describes the handling of relational data in Java applications. It is not an implementation. It is only a Java specification. It is a standard API that permits to perform database operations.
    Hibernate is an Object-Relational Mapping (ORM) tool that is used to save the Java objects in the relational database system. Hibernate is an implementation of JPA. The common standard which is given by JPA is followed by Hibernate. It is used in mapping Java data types with SQL data types and database tables.

5.  What is Hiraki? what is the benefits of connection pool?
    Hikari is a JDBC DataSource implementation that provides a connection pooling mechanism. Compared to other implementations, it promises to be lightweight and better performing. the benefits of connection pool is better performing.


6.  What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.
    @OneToMany: one object in this table can have many relationships to another table
        like posts and comments
    @ManyToOne: used combined with one to many.

    @ManyToMany: set up a table to hold @ManyToOne && @OneToMany
        must generate an intermediate table
        like warehouses and commodities


7. What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what 
are the other CascadeType and their features? In which situation we choose 
which one?
    The meaning of CascadeType.ALL is that the persistence will propagate (cascade) all EntityManager operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the relating entities. orphanRemoval = true is to delete orphaned entities from the database.

    CascadeType.PERSIST: save() or persist() cascade to related entities.
    CascadeType.MERGE: related entities are merged when the owning entity is merged.
    CascadeType.REFRESH: refresh() operation cascade to related entities.
    CascadeType.REMOVE: removes all related entities association with this setting when the owning entity is deleted.
    CascadeType.DETACH: detaches all related entities if a manual detach occurs.
    CascadeType.ALL: cascade type all is shorthand for all of the above cascade operations.

8.  What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the 
difference? In which situation you choose which one?
    FetchType.Lazy: If we don't need data from comment, JPA doesn't fetch it, Only fetch data from post
    when we need data from comment, then JPA fecth comment data

    FetchType.Eager: when we fetch post, JPA also fetch comment at the same time.


9.  What is the rule of JPA naming convention? Shall we implement the method by 
ourselves? Could you list some examples?
    Spring uses lower snake case by default, which means it uses only lower case letters and separates words with underscores.


10. Add 2 more api  /api/v1/posts/search?keyword=value in your class project. In 
the repository layer, you need to use the naming convention to use the method 
provided by JPA.


11. Check out a new branch(hw1_jdbcTemplate) from branch 02_post_RUD, replace 
the dao layer using JdbcTemplate.