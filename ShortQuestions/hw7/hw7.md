1. create a file to list all of the annotaitons you learned and known, and explain the usage and how do you understand it. you need to update it when you learn a new annotation. Please organize those annotations well, like annotations used by entity, annotations used by controller.
	a. File name: annotations.md
	b. you'd better also list a code example under the annotations
2. explain how the below annotaitons specify the table in database?  
	`@Column(columnDefinition = "varchar(255) default 'John Snow'")`  
	`private String name;`  
  
	`@Column(name="STUDENT_NAME", length=50, `  
	`nullable=false, unique=false)`  
	`private String studentName;`  

	1. @Column @Column(columnDefinition = "varchar(255) default 'John Snow'")
		1. creates a column with define type varchar 255 and default value John Snow
	2. @Column(name="STUDENT_NAME", length=50, nullable=false, unique=false)
		2. create a column name = STUDENT_NAME" and size = 50, can not be null and content not unique
3. What is the default column names of the table in database for  @Column?
	`@Column`
	`private String firstName;`
	`@Column`
	`private String operatingSystem;`
	1. firstName and operating System
4. What are the layers in springboot application? what is the role of each layer?
	1. Presentation Layer
		1. Authentication
		2. JSON Translation
	2. Business Layer
		1. Business logic
		2. Validation
		3. Authorisation
	3. Persistence Layer
		1. Storage logic
	4. Database 
		1. store data

5. Describe the flow in all of the layers if an API is called by Postman.
	1. client talk to controller
	2. controller talk to service
	3. service talk to dao
	4. dao talk to db
6. What is the application.properties? do you know application.yml?
	1. application.properties file stores database connection info, such as port number, username and password
	2. yml file also contains database connection info
7. Create a Project, name it with mongo-blog, write a POST API for mongo-blog, change database to MongoDB;

8.  In your redbook application, write the code for RUD APIs




