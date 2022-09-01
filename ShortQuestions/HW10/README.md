# Homework

1. List all of the annotations you learned from class and homework to annotaitons.md
   - See annotations.md

2. type the code, you need to checkout new branch from branch **02_post_RUD**, name the new branch with **05_slides_JPQL_EntityManager_Session**.
   - see MarvenProject/redbook-jpal

3. What is JPQL?
   - The JPQL (Java Persistence Query Language) is an object-oriented query language which is used to perform database operations on persistent entities. Instead of database table, JPQL uses entity object model to operate the SQL queries. Here, the role of JPA is to transform JPQL into SQL. Thus, it provides an easy platform for developers to handle SQL tasks.
   - https://www.javatpoint.com/jpa-jpql-introduction

4. What is @NamedQuery and @NamedQueries?

   - A named query is a statically defined query with a predefined unchangeable query string. Using named queries instead of dynamic queries may improve code organization by separating the JPQL query strings from the Java code. It also enforces the use of query [parameters](https://www.objectdb.com/java/jpa/query/parameter) rather than embedding literals dynamically into the query string and results in more efficient queries.

   - The `@NamedQuery` annotation contains four elements - two of which are required and two are optional. The two required elements, `name` and `query` define the name of the query and the query string itself and are demonstrated above. The two optional elements, `lockMode` and `hints`, provide static replacement for the `setLockMode` and `setHint` methods.

     Every `@NamedQuery` annotation is attached to exactly one entity class or mapped superclass - usually to the most relevant entity class. But since the scope of named queries is the entire persistence unit, names should be selected carefully to avoid collision (e.g. by using the unique entity name as a prefix).

   - multiple named queries to the same entity class requires wrapping them in a `@NamedQueries` annotation.

5. What is @Query? In which Interface we write the sql or JPQL?

   - The @Query annotation declares finder queries directly on repository methods. While similar @NamedQuery is used on domain classes, Spring Data JPA @Query annotation is used on Repository interface.

6. What is HQL and Criteria Queries?

   - Hibernate Query Language (HQL) is an object-oriented query language, similar to SQL, but instead of operating on tables and columns, HQL works with persistent objects and their properties.
   - The criteria query API **lets us build nested, structured query expressions in Java, providing a compile-time syntax checking that is not possible with a query language like HQL or SQL**.

7. What is EnityManager?

   - A JPA EntityManager manages connection to a database as well as to database operations. EntityManager is associated with a PersistenceContext . All operations that are performed in a specific session are stored inside the PersistenceContext.

     EntityManager is the interface to the Persistence Context . All operations on the entity go through the EntityManager . We will declare an EntityManager object in our class and mark it with the @PersistenceContext annotation.

8. What is SessionFactory and Session?

   - SessionFactory is a factory class for Session objects. It is available for the whole application while a Session is only available for particular transaction. Session is short-lived while SessionFactory objects are long-lived. SessionFactory provides a second level cache and Session provides a first level cache.
   - **The time interval in which two systems(i.e. the client and the server) communicate with each other** can be termed as a session. In simpler terms, a session is a state consisting of several requests and response between the client and the server.

9. What is Transaction? how to manage your transaction?

   - A transaction, in the context of a database, is a logical unit that is independently executed for data retrieval or updates. Experts talk about a database transaction as a “unit of work” that is achieved within a database design environment.

     In relational databases, database transactions must be atomic, consistent, isolated and durable—summarized as the ACID acronym. Engineers have to look at the build and use of a database system to figure out whether it supports the ACID model or not. Then, as newer kinds of database systems have emerged, the question of how to handle transactions becomes more complex.

   - Manage transaction

     - `*@Transactional*` (Declarative Transaction Management) vs Programmatic Transaction Management.
     - Physical vs Logical transactions.
     - Spring `*@Transactional*` and JPA / Hibernate integration.
     - Spring `*@Transactional*` and Spring Boot or Spring MVC integration.
     - Rollbacks, Proxies, Common Pitfalls and much more.

10. Write a simple factory design pattern.

    - See ShortQuestions/designPatterns.md