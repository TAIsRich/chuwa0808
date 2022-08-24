2. explain how the below annotations specify the table in database?

   ```
   @Column(columnDefinition = "varchar(255) default
   'John Snow'")
   private String name;
   @Column(name="STUDENT_NAME", length=50,
   nullable=false, unique=false)
   private String studentName;
   ```

   创建一个列叫name，类型为“varchar(255)”， default value 'John Snow'

   创建一个列叫"STUDENT_NAME", 最大长度为50，不能为Null, 可以不是unque.

3. What is the default column names of the table in database for @Column?

   ```
   @Column
   private String firstName;
   @Column
   private String operatingSystem;
   ```

   first_name, operating_system

4. What are the layers in springboot application? what is the role of each layer?

   Service: 业务逻辑

   Controller: API layer, route requests to methods.

   Dao: Persistence logic, save data from the Service data to db or get data from db to service.

5. Describe the flow in all of the layers if an API is called by Postman.

   If an API is called, request with parameters goes to the Controller layer, which route it to different methods in the Service layer based on the url. Then the service layer process the request and save or retrieve data using DAO layer, then return data to the controller layer. Then the controller layer return the data to clients who calls the API.

6. What is the application.properties? do you know application.yml?

   It is where we configure database and sersers. yml is just another file format.

7. https://github.com/TAIsRich/chuwa0808/tree/FranklinYao/hw40/mongo-blog

7. 