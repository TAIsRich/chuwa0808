1. List all of the annotations you learned from class and homework to annotaitons.md

   Plz check the "hw40/annotations.md"

2. Type the Comment feature for the class project.

3. In postman, call of the APIs in PostController and CommentController.

4. what is JPA? and what is Hibernate?

   - A JPA (Java Persistence API) is a specification of Java which is used to access, manage, and persist data between Java object and relational database. It is considered as a standard approach for Object Relational Mapping.
   - A Hibernate is a Java framework which is used to store the Java objects in the relational database system. It is an open-source, lightweight, ORM (Object Relational Mapping) tool.Hibernate is an implementation of JPA. So, it follows the common standards provided by the JPA.

5. What is Hiraki? what is the benefits of connection pool?

   - Hikari is a JDBC DataSource implementation that provides a connection pooling mechanism.
   - Using connection pools helps to both alleviate connection management overhead and decrease development tasks for data access. Each time an application attempts to access a backend store (such as a database), it requires resources to create, maintain, and release a connection to that datastore.

6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples

   - @OneToMany: one object in this table can have many relationships to another table
   - @ManyToOne: used combined with one to many.
   - @ManyToMany: set up a table to hold @ManyToOne && @OneToMany

7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?

   https://stackoverflow.com/questions/4329577/how-does-jpa-orphanremoval-true-differ-from-the-on-delete-cascade-dml-clause

   Cascading means propagating an operation from the owning entity to the related entity. When a record in the owning entity (parent table) is saved, updated or deleted, the change should be reflected in the related entity (child table) as well.

   `CascadeType.ALL` is that the persistence will propagate (cascade) all EntityManager operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the relating entities.

   `orphanRemoval` is an entirely **ORM-specific thing**. It marks "child" entity to be removed when it's no longer referenced from the "parent" entity, e.g. when you remove the child entity from the corresponding collection of the parent entity.

   Types:

   - CascadeType.PERSIST: cascade type presist means that save() or persist() operations cascade to related entities.
   - CascadeType.MERGE: cascade type merge means that related entities are merged when the owning entity is merged.
   - CascadeType.REFRESH: cascade type refresh does the same thing for the refresh() operation.
   - CascadeType.REMOVE: cascade type remove removes all related entities association with this setting when the owning entity is deleted.
   - CascadeType.DETACH: cascade type detach detaches all related entities if a “manual detach” occurs.
   - CascadeType.ALL: cascade type all is shorthand for all of the above cascade operations.

8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?

   - FetchType.EAGER: tells Hibernate to get all elements of a relationship when selecting the root entity.
   - FetchType.LAZY: tells Hibernate to only fetch the related entities from the database when you use the relationship.

9. What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?

   - Spring uses lower snake case by default, which means it uses only lower case letters and separates words with underscores.
   - Yes
   - `firstName` -> `first_name`

10. Add 2 more api /api/v1/posts/search?keyword=value in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.

    Plz check the redbook project.

11. Check out a new branch(hw1_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.

    Plz check the branch "hw1_jdbcTemplate"

12. watch those videos(看⼀遍，能理解多少是多少。千万千万不要看其它的视频，会 ⾛⽕⼊魔晕乎乎的)