1. List all of the annotations you learned from class and homework to annotaitons.md

   Plz check ../annotations.md

2. What is hibernate Caching?

   Hibernate caching acts as **a layer between the actual database and your application**. It reduces the time taken to obtain the required data — as it fetches from memory instead of directly hitting the database. It is very useful when you need to fetch the same kind of data multiple times.

3. What is the difference between first-level cache and second-level cache?

   - The primary difference is that **the first level cache is maintained at the Session level while the second level cache is maintained at the SessionFactory level**. 
   - The data stored in the first level cache is accessible to the only Session that maintains it, while the second level cache is accessible to all.

4. How do you understand @Transactional?

   It is an annotation to implement transactions. Describes a transaction attribute on an individual method or on a class.
   When this annotation is declared at the class level, it applies as a default to all methods of the declaring class and its subclasses. Note that it does not apply to ancestor classes up the class hierarchy; inherited methods need to be locally redeclared in order to participate in a subclass-level annotation. 

5. How do you handle the exception in Spring?

   We can use the @ExceptionHandler at the method level to handle the specific exceptions and sending the custom
   responses to the client or use ControllerAdvice at the class level to handle the exceptions globally.

6. How do you do the validations in Spring?

   Add validation Rule to payload and Add @valid to controller to apply the Rule.