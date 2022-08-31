3. What is JPQL?

   JPQL is Java Persistence Query Language defined in JPA specification. It is used to create queries against entities to store in a relational database. JPQL is developed based on SQL syntax. But it won’t affect the database directly.

4. What is @NamedQuery and @NamedQueries?

   @NameQueries annotation is used to define the multiple named queries. 
   @NameQuery annotation is used to define the single named query.

   ```
   @NamedQueries({
       @NamedQuery(name="Country.findAll",
                   query="SELECT c FROM Country c"),
       @NamedQuery(name="Country.findByName",
                   query="SELECT c FROM Country c WHERE c.name = :name"),
   }) 
   ```

5. What is @Query? In which Interface we write the sql or JPQL?

   A Query is similar in syntax to SQL, and it's generally used to perform CRUD operations. The @Query annotation takes precedence over named queries.

   By default, the query definition uses JPQL.

6. What is HQL and Criteria Queries?

   Hibernate provides three different ways to retrieve data from a database: HQL, native SQL queries and hibernate criteria queries.

   Hibernate Query Language (HQL) is an object-oriented query language, similar to SQL, but instead of operating on tables and columns, HQL works with persistent objects and their properties. Hibernate Query Language (HQL) is an object-oriented query language, similar to SQL, but instead of operating on tables and columns, HQL works with persistent objects and their properties. HQL queries are translated by Hibernate into conventional SQL queries, which in turns perform action on database.

   The criteria query API lets us build nested, structured query expressions in Java, providing a compile-time syntax checking that is not possible with a query language like HQL or SQL. 

   - HQL is to perform both select and non-select operations on the data,  but Criteria is only for selecting the data
   - HQL is suitable for executing Static Queries, where as Criteria is suitable for executing Dynamic Queries

7. What is EnityManager?

   The EntityManager is an API that manages the lifecycle of entity instances. An EntityManager object manages a set of entities that are defined by a persistence unit. Each EntityManager instance is associated with a persistence context.

   A JPA EntityManager manages connection to a database as well as to database operations. EntityManager is associated with a PersistenceContext. All operations that are performed in a specific session are stored inside the PersistenceContext.
   EntityManager is the interface to the Persistence Context. All operations on the entity go through the EntityManager. We will declare an EntityManager object in our class and mark it with the @PersistenceContext annotation.

8. What is SessionFactory and Session?

   SessionFactory is a factory class which creates Session objects. 
   It is available for the whole application while a Session is only available for particular transaction. 

9. What is Transaction? how to manage your transaction?

   A transaction is a logical unit of work that contains one or more SQL statements. It is an atomic unit -  if one step fails, the whole transaction fails (which is termed as atomicity). 

   There are 2 ways to achieve transaction management in Spring:
   Spring Programmatic Transaction Management
   With programmatic transactions, transaction management code needs to be explicitly written so as to commit when everything is successful and rolling back if anything goes wrong. The transaction management code is tightly bound to the business logic in this case.

10. Write a simple factory design pattern.

    Please check "hw3/DesignPattern/src/main/java/SimpleFactory"