# Homework 7

1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
   a. File name: annotations.md
   b. you'd better also list a code example under the annotations.

   - See HW7/annotations.md

2. explain how the below annotaitons specify the table in database?

   ​	![1](/Users/xiazhao/repo/chuwa0808/ShortQuestions/Image/1.png)

   	- columnDefinition : Generated SQL to create a column of the inferred type.
   	- Name column is STUDENT_NAME, and the max length is 50.

3. What is the default column names of the table in database for  @Column?

   ​	![](/Users/xiazhao/repo/chuwa0808/ShortQuestions/Image/2.png)

   	- first_name 
   	- operating_system

4. What are the layers in springboot application? what is the role of each layer?

   	- **Presentation Layer** – Authentication & Json Translation
   - **Business Layer** – Business Logic, Validation & Authorization
   - **Persistence Layer** – Storage Logic
   - **Database Layer** – Actual Database

5. Describe the flow in all of the layers if an API is called by Postman.

    - **Postman** Postman specifies the API url, with post id, and request method. For example
      - Url with post id: http://localhost:8080/api/v1/posts/1
      - request method: GET
    - **Postman -> PostController** RestController, for example PostController, receives the API call with getPostById method, and able to receive the id as @PathVariable parameter.
    - **PostController -> PostService** RestController delegates the work to PostService instance, which is injected by SpringBoot framework with @Autowired annotation.
    - **PostService -> PostRepository** PostServiceImpl, which is the actualy concrect class for PostService, receives the mehtod call for getPostById, and delegates the work to PostRepository.
    - **PostRepository -> database -> PostRepository** PostRepository, which extends JpaRepository<Post, Long>, queries the database and get the specific post data with primary key, fills it into Post Entity and returns to PostService.
    - **PostRepository -> PostController** PostService returns the data to PostController.
    - **PostController -> Postman** PostController wrapped the data as ResponseEntity<PostDto> and return the data as payload to Postman.

6. What is the application.properties? do you know application.yml?

   	- `application.properties` is a key-value repository resource that is widely used for configuration properties and runtime variables. 
   	- **YAML is a convenient format for specifying hierarchical configuration data.**This can be more readable than its property file alternative since it does not contain repeated prefixes.

7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, 
   change database to MongoDB;
   a. https://www.mongodb.com/compatibility/spring-boot

   - See MavenProject/mongo-blog

8. In your redbook application, write the code for RUD APIs.
   a. https://github.com/TAIsRich/springboot-redbook.git

   		-  i. Branch: 02_post_RUD

   b. you need to call the new APIs in your postman.
   c.  You need to type it line by line and try your best to understand it. DO 
   NOT COPY PASTE

   