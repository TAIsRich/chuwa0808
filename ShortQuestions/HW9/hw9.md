1.  List all of the annotations you learned from class and homework to 
annotaitons.md

2.  type the code, you need to checkout new branch from branch 02_post_RUD, 
name the new branch with 05_slides_JPQL_EntityManager_Session.

3.  What is JPQL?
The JPQL (Java Persistence Query Language) is an object-oriented query language which is used to perform database operations on persistent entities. Instead of database table, JPQL uses entity object model to operate the SQL queries. Here, the role of JPA is to transform JPQL into SQL. Thus, it provides an easy platform for developers to handle SQL tasks.

JPQL is an extension of Entity JavaBeans Query Language (EJBQL), adding the following important features to it: -

It can perform join operations.
It can update and delete data in a bulk.
It can perform aggregate function with sorting and grouping clauses.
Single and multiple value result types.

4.  What is @NamedQuery and @NamedQueries?
A named query is a statically defined query with a predefined unchangeable query string. They're validated when the session factory is created, thus making the application to fail fast in case of an error.

To define this as a named query, we'll use the org.hibernate.annotations.NamedQuery annotation. It extends the javax.persistence.NamedQuery with Hibernate features.

It's important to note that every @NamedQuery annotation is attached to exactly one entity class or mapped superclass. But, since the scope of named queries is the entire persistence unit, we should select the query name carefully to avoid a collision. And we have achieved this by using the entity name as a prefix.

If we have more than one named query for an entity, we'll use the @NamedQueries annotation to group these:

5.  What is @Query? In which Interface we write the sql or JPQL?
Spring Data provides many ways to define a query that we can execute. One of these is the @Query annotation.

In order to define SQL to execute for a Spring Data repository method, we can annotate the method with the @Query annotation — its value attribute contains the JPQL or SQL to execute.

The @Query annotation takes precedence over named queries, which are annotated with @NamedQuery or defined in an orm.xml file.

JPQL:@Query("SELECT u FROM User u WHERE u.status = 1")
Collection<User> findAllActiveUsers();

sql:@Query(
  value = "SELECT * FROM USERS u WHERE u.status = 1", 
  nativeQuery = true)
Collection<User> findAllActiveUsersNative();

6.  What is HQL and Criteria Queries?
The Hibernate Criteria Query Language (HCQL) is used to fetch the records based on the specific criteria. The Criteria interface provides methods to apply criteria such as retreiving all the records of table whose salary is greater than 50000 etc.

Hibernate provides alternate ways of manipulating objects and in turn data available in RDBMS tables. One of the methods is Criteria API, which allows you to build up a criteria query object programmatically where you can apply filtration rules and logical conditions.

The Hibernate Session interface provides createCriteria() method, which can be used to create a Criteria object that returns instances of the persistence object's class when your application executes a criteria query.

Following is the simplest example of a criteria query is one, which will simply return every object that corresponds to the Employee class.

7. What is EnityManager?
EntityManager is an interface provided by Java Persistence API (JPA) specification. We use EntityManager as a general-purpose DAO interface for managing lifecycle of entity instances, such as:

Create & Remove persistent entity instances
Find entities by their primary key
Query over entities

In a Spring Boot application that uses Spring Data JPA, you can inject an instance of EntityManager in your repository/service/controller class. The Spring’s IoC container manages an EntityManager bean, and concrete implementation is provided by Hibernate framework.

An EntityManager object manages a set of entities that are defined by persistence unit. And the entity manager is responsible for tracking all entity objects for changes, and synchronizing the changes with database.

8.  What is SessionFactory and Session?
SessionFactory is a factory class for Session objects. It is available for the whole application while a Session is only available for particular transaction.

Session is short-lived while SessionFactory objects are long-lived. SessionFactory provides a second level cache and Session provides a first level cache.

9.  What is Transaction? how to manage your transaction?
A database transaction is a sequence of actions that are treated as a single unit of work. These actions should either complete entirely or take no effect at all. Transaction management is an important part of RDBMS-oriented enterprise application to ensure data integrity and consistency. The concept of transactions can be described with the following four key properties described as ACID −

Atomicity − A transaction should be treated as a single unit of operation, which means either the entire sequence of operations is successful or unsuccessful.

Consistency − This represents the consistency of the referential integrity of the database, unique primary keys in tables, etc.

Isolation − There may be many transaction processing with the same data set at the same time. Each transaction should be isolated from others to prevent data corruption.

Durability − Once a transaction has completed, the results of this transaction have to be made permanent and cannot be erased from the database due to system failure.

A real RDBMS database system will guarantee all four properties for each transaction. The simplistic view of a transaction issued to the database using SQL is as follows −

Begin the transaction using begin transaction command.

Perform various deleted, update or insert operations using SQL queries.

If all the operation are successful then perform commit otherwise rollback all the operations.

Spring framework provides an abstract layer on top of different underlying transaction management APIs. Spring's transaction support aims to provide an alternative to EJB transactions by adding transaction capabilities to POJOs. Spring supports both programmatic and declarative transaction management. EJBs require an application server, but Spring transaction management can be implemented without the need of an application server.

(1).we can use in a @Configuration class to enable transactional support:
@Configuration
@EnableTransactionManagement
public class PersistenceJPAConfig{

   @Bean
   public LocalContainerEntityManagerFactoryBean
     entityManagerFactory(){
      //...
   }

   @Bean
   public PlatformTransactionManager transactionManager(){
      JpaTransactionManager transactionManager
        = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(
        entityManagerFactory().getObject() );
      return transactionManager;
   }
}

(2)
<bean id="txManager" class="org.springframework.orm.jpa.JpaTransactionManager">
   <property name="entityManagerFactory" ref="myEmf" />
</bean>
<tx:annotation-driven transaction-manager="txManager" />

(3)we can now annotate a bean with @Transactional either at the class or method level:
@Service
@Transactional
public class FooService {
    //...
}

The annotation supports further configuration as well:

the Propagation Type of the transaction
the Isolation Level of the transaction
a Timeout for the operation wrapped by the transaction
a readOnly flag – a hint for the persistence provider that the transaction should be read only
the Rollback rules for the transaction
Note that by default, rollback happens for runtime, unchecked exceptions only. The checked exception does not trigger a rollback of the transaction. We can, of course, configure this behavior with the rollbackFor and noRollbackFor annotation parameters.

10. Write a simple factory design pattern.