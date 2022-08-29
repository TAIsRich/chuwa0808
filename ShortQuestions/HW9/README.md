# Homework 9

1. List all of the annotations you learned from class and homework to 
   annotaitons.md

   - See annotations.md

2. Type the Comment feature for the class project.

3. In postman, call of the APIs in PostController and CommentController.

4. what is JPA? and what is Hibernate?

   - JPA is a standard of Object relational Mapping. It is an interface that defines a set of annotations for  creating the object relational mapping.
   - Hibernate is the most popular ORM framework.
   - The benefit of using JPA instead of Hibernate is that JPA is a standard and one can switch to any other implementation later.

5. What is Hiraki? what is the benefits of connection pool?

   - Hiraki is a JDBC DataSource implementation that provides a connection pooling mechanism.
   - Compared to other implementations, it promises to be lightweight and better performing.
   - The benefits of connection pool:
     - Reduces the number of times new connection objects are created. 
     - Promotes connection object reuse. Quickens the process of getting a connection. 
     - Reduces the amount of effort required to manually manage connection objects.

6. What is the  @OneToMany, @ManyToOne, @ManyToMany? write some examples.

   - In a relational database system, a one-to-one table relationship links two tables based on a `Primary Key` column in the child which is also a `Foreign Key` referencing the `Primary Key` of the parent table row.
   - In a relational database system, a many-to-many table relationship links two parent tables via a child table which contains two `Foreign Key` columns referencing the `Primary Key` columns of the two parent tables.
   - In a relational database system, a one-to-many table relationship associates two tables based on a `Foreign Key` column in the child table referencing the `Primary Key` of one record in the parent table.
   - https://stackoverflow.com/questions/3113885/difference-between-one-to-many-many-to-one-and-many-to-many

7. What is the  cascade = CascadeType.ALL, orphanRemoval = true? and what 
   are the other CascadeType and their features? In which situation we choose 
   which one?

   - Cascading :

     - Entity relationships often depend on the existence of another entity, for example the *Person*–*Address* relationship. Without the *Person*, the *Address* entity doesn't have any meaning of its own. When we delete the *Person* entity, our *Address* entity should also get deleted.

       Cascading is the way to achieve this. **When we perform some action on the target entity, the same action will be applied to the associated entity.**

   - Type: 

     - CascadeType.ALL

       *CascadeType.ALL* **propagates all operations — including Hibernate-specific ones — from a parent to a child entity.**

     - CascadeType.PERSIST

       The persist operation makes a transient instance persistent. **Cascade Type \*PERSIST\* propagates the persist operation from a parent to a child entity.** When we save the *person* entity, the *address* entity will also get saved.

     - cascadeType.MERGE

       The merge operation copies the state of the given object onto the persistent object with the same identifier. ***CascadeType.MERGE\* propagates the merge operation from a parent to a child entity.**

     - cascadeType.REMOVE

       As the name suggests, the remove operation removes the row corresponding to the entity from the database and also from the persistent context.

     - CascadeType.DETACH

       The detach operation removes the entity from the persistent context. **When we use \*CascadeType.DETACH\*, the child entity will also get removed from the persistent context.**

     - CascadeType.REFRESH

       Refresh operations **reread the value of a given instance from the database.** In some cases, we may change an instance after persisting in the database, but later we need to undo those changes.

     - CascadeType.SAVE_UPDATE

       *CascadeType.SAVE_UPDATE* propagates the same operation to the associated child entity. It's useful when we use **Hibernate-specific operations like \*save\*, \*update\* and \*saveOrUpdate\*.** 

     - CascadeType.LOCK

       **Unintuitively, \*CascadeType.LOCK\* reattaches the entity and its associated child entity with the persistent context again.**

     - CascadeType.REPLICATE

       **The replicate operation is used when we have more than one data source and we want the data in sync.** With *CascadeType.REPLICATE*, a sync operation also propagates to child entities whenever performed on the parent entity.

8. What is the  fetch = FetchType.LAZY, fetch = FetchType.EAGER? what is the 
   difference? In which situation you choose which one?

   - Both `FetchType.LAZY` and `FetchType.EAGER` are used to define the default fetch plan.

     Unfortunately, you can only override the default fetch plan for LAZY fetching. EAGER fetching is less flexible and can lead to many performance issues.

   - to restrain the urge of making your associations EAGER because fetching is a query-time responsibility. So all your queries should use the **fetch** directive to only retrieve what's necessary for the current business case.

9. What is the rule of JPA naming convention? Shall we implement the method by 
   ourselves? Could you list some examples?

   | Keyword           | Sample                                                | JPQL snippet                                                 |
   | ----------------- | ----------------------------------------------------- | ------------------------------------------------------------ |
   | And               | findByLastnameAndFirstname                            | … where x.lastname = ?1 and x.firstname = ?2                 |
   | Or                | findByLastnameOrFirstname                             | … where x.lastname = ?1 or x.firstname = ?2                  |
   | IsEquals          | findByFirstnamefindByFirstnameIsfindByFirstnameEquals | … where x.firstname = ?1                                     |
   | Between           | findByStartDateBetween                                | … where x.startDate between ?1 and ?2                        |
   | LessThan          | findByAgeLessThan                                     | … where x.age < ?1                                           |
   | LessThanEqual     | findByAgeLessThanEqual                                | … where x.age <= ?1                                          |
   | GreaterThan       | findByAgeGreaterThan                                  | … where x.age > ?1                                           |
   | GreaterThanEqual  | findByAgeGreaterThanEqual                             | … where x.age >= ?1                                          |
   | After             | findByStartDateAfter                                  | … where x.startDate > ?1                                     |
   | Before            | findByStartDateBefore                                 | … where x.startDate < ?1                                     |
   | IsNull            | findByAgeIsNull                                       | … where x.age is null                                        |
   | IsNotNull,NotNull | findByAge(Is)NotNull                                  | … where x.age not null                                       |
   | Like              | findByFirstnameLike                                   | … where x.firstname like ?1                                  |
   | NotLike           | findByFirstnameNotLike                                | … where x.firstname not like ?1                              |
   | StartingWith      | findByFirstnameStartingWith                           | … where x.firstname like ?1(parameter bound with appended %) |
   | EndingWith        | findByFirstnameEndingWith                             | … where x.firstname like ?1(parameter bound with prepended %) |
   | Containing        | findByFirstnameContaining                             | … where x.firstname like ?1(parameter bound wrapped in %)    |
   | OrderBy           | findByAgeOrderByLastnameDesc                          | … where x.age = ?1 order by x.lastname desc                  |
   | Not               | findByLastnameNot                                     | … where x.lastname <> ?1                                     |
   | In                | findByAgeIn(Collection<Age> ages)                     | … where x.age in ?1                                          |
   | NotIn             | findByAgeNotIn(Collection<Age> ages)                  | … where x.age not in ?1                                      |
   | True              | findByActiveTrue()                                    | … where x.active = true                                      |
   | False             | findByActiveFalse()                                   | … where x.active = false                                     |
   | IgnoreCase        | findByFirstnameIgnoreCase                             | … where UPPER(x.firstame) = UPPER(?1)                        |

10. Add 2 more api  /api/v1/posts/search?keyword=value in your class project. In 
    the repository layer, you need to use the naming convention to use the method 
    provided by JPA.

11. Check out a new branch(hw1_jdbcTemplate) from branch 02_post_RUD, replace 
    the dao layer using JdbcTemplate.

12. Watch videos.

13. (Optional) use JDBC to read the data from database.