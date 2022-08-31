1. List all of the annotations you learned from class and homework to annotaitons.md
2. Type the Comment feature for the class project.
3. In postman, call of the APIs in PostController and CommentController.
4. what is JPA? and what is Hibernate?
   1. JPA is java persistence API, it is used for mapping database and java object
   2. hibernate is a framework to provide functionlity of persistence layer, mapping between java object and database. usually relational database. hibernate is a implementation of JPA
5. What is Hiraki? what is the benefits of connection pool?
   1. hiraki provide datasource connection pool, it's a JDBC datasource implementation.
   2. it can reuse the connection like thread pool.
6. What is the @OneToMany, @ManyToOne, @ManyToMany? write some examples.
   1. @OneToMany is a relationship such that one company can have many employees but each employee can only have one company.
   2. @ManyToOne is opposite relationship, like many employees can have only one company.
   3. @ManyToMany is a relationship that both side can have many mapping, like one student can have many teachers and one teacher can have many students.
   4. in code, we can use post and comments as example:
   5. in post design, one post can have many comments, so there should be @OneToMany to join comments table. it would be @OneToMany(mappedBy = "Post", cascade=CascadeType.All) List<Comment> comments;
   6. in comment design, one comment can only have one post, so there should be @ManyToOne.In code, it would be @ManyToOne(fetch=FetchType.LAZY) @JoinColumn(name = "post_id",nullable=false) Post post;
   7. @ManyToMany(fetch = FetchType.LAZY) @JoinTable(name = "student_teacher", joinColumns = @JoinColumn(name = "stu_id"), inverseJoinColumns = @JoinColumn(name ="inventory_id")) List<Teacher> teachers
   8. @ManyToMany(mappedBy = "teachers")
   9. 
7. What is the cascade = CascadeType.ALL, orphanRemoval = true? and what are the other CascadeType and their features? In which situation we choose which one?
   1. the CascadeType.ALL means that the persistence will cascade all operations(PERSIST,MERGE, REMOVE, REFRESH, DETACH) to realtional tables.
   2. orphanRemoval means when there is a relationship of parent and child, when parent is deleted the child will be deleted as well if orphanRemoval=true
   3. PERSIST: when we save one class, the related classes will be saved as well.
   4. MERGE: when we merge one class, the related classes will be merged as well.
   5. REMOVE: when we remove one class, the related classes will be removed as well.
   6. REFRESH: when we refresh one class, the related classes will be refreshed as well.
   7. DETACH: when we detach one class, the related classes will be detached as well.
   8. 
8. What is the fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the difference? In which situation you choose which one?
   1. lazy fetch type will fetch the data when needed but eager type will fetch the data when related class is fetched
   2. 
9.  What is the rule of JPA naming convention? Shall we implement the method by ourselves? Could you list some examples?
    1.  we can write method by table name and column and JPA will automatically implemente the method.
    2.  no, findByXXXAndXXX(a,b), findByXXXOrXXX(a,b)
10. Add 2 more api /api/v1/posts/search?keyword=value in your class project. In the repository layer, you need to use the naming convention to use the method provided by JPA.
11. Check out a new branch(hw1_jdbcTemplate) from branch 02_post_RUD, replace the dao layer using JdbcTemplate.
12. watch those videos(看一遍，能理解多少是多少。千万千万不要看其它的视频，会 走火入魔晕乎乎的)