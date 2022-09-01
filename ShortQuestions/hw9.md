# 4 JPA vs Hibernate
JPA is a standard for Hibernate ORM (object relational mapping), JPA can be used as a interface, it will define what methods can be used.

JPA use JDBC to CRUD database, and also transfer result from database to Java Entities. With JPA, We can map a java class or been to a table. 

Hibernate is a JAVA ORM library, it helps you to map the object from java class to a data format that can be placed in the database. 

# 5 Hiraki
Hiraki is a JDBC datasource implementation that provides a connection pooling mechanism. It has better performing. 

Connection pool, better use of space, time and data. Don't need to new a object whenever you want to use.

# 6 @OneToMany, @ManyToOne, @ManyToMany

Relationship between two tables.

# 7 cascade = CascadeType.ALL, orphanRemoval = true
Any operation did on one table will affect the related tables as well.

orphanRemoval: when remove relationship between parent class and child class, the object in  child class became an orphan.

Cascade Type: remove, persist, refresh, detach

# 8 

Eager: when fetch, all the related records will be retrieved

Lazy: when fetch, only the specific record that you requested will be retrieved.

# 9 Rule of JPA naming convention

When you define a name of a method, the name of the method must be built by the related columns' names in the table.

findByLastnameOrFirstname(a, b): the table must contains columns of lastname and firstname, and a b will be assigned accordingly.
