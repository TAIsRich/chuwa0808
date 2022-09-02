# Homework 11

1. List all of the annotations you learned from class and homework to annotaitons.md

   - See ../annotations.md

2. What is hibernate Caching?

   - Hibernate caching acts as a layer between the actual database and your application. It reduces the time taken to obtain the required data — as it fetches from memory instead of directly hitting the database. It is very useful when you need to fetch the same kind of data multiple times.

3. What is the difference between first-level cache and second-level cache?

   - The First level cache is **by default enabled** by Hibernate itself. The session object maintains the first-level cache.

     An application can have many sessions. Data hold by one session object is not accessible to the entire application — means the data of a particular session is not shared with other sessions of the application. So you can use the first-level cache to store local data i.e. required by the session itself.

   - The second-level cache is **by default disabled** the developer needs to enable it explicitly, and the SessionFactory object is responsible to maintain it. The second-level cache is accessible by the entire application means data hold by SessionFactory can be accessible to all the sessions. Keep in mind that, once the session factory is closed all the cache associated with that is also removed from the memory.

   - https://medium.com/swlh/what-is-hibernate-caching-introduction-of-level-1-level-2-cache-8ea7339a5052#:~:text=Hibernate%20caching%20acts%20as%20a,kind%20of%20data%20multiple%20times

4. How do you understand @Transactional?

   - Describes a transaction attribute on an individual method or on a class.

   - @Transactional annotation is used **when you want the certain method/class(=all methods inside) to be executed in a transaction**.
   - The @Transactional annotation is **metadata that specifies that an interface, class, or method must have transactional semantics**; for example, "start a brand new read-only transaction when this method is invoked, suspending any existing transaction".

5. How do you handle the exception in Spring?

   - Steps  
     1. create ErrorDetails Class
     2. Create GlobalExceptionHandler Class
     3. Test using Postman Client

6. How do you do the validations in Spring?

   - Steps
     - Import dependecy
     - add validation rule to payload
     - Add @valid to controller to apply the rule 
     - Check it in postman