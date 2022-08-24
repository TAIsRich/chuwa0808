2. explain how the below annotaitons specify the table in database?
    Two columns in the database are defined
    NAME varchar(255) default 'John Snow',
    STUDENT_NAME, length 50, can have duplicate values, cannot be null

3. What is the default column names of the table in database for @Column?
    first_name, operating_system

4. What are the layers in springboot application? what is the role of each layer?
    1. Controller layer
        Respond to client http and https requests( API layer )

    2. Service layer
        business logic layer

    3. Data Access layer
        Connect java program and database

5. Describe the flow in all of the layers if an API is called by Postman.


6. What is the application.properties? do you know application.yml?
    1. application.properties defines the datasource of the spring application (url, user, password)
    2. application.properties determines the database version required by hibernate

