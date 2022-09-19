* Integrate with H2 in memory database.
  * See [table_script.ddl](src/main/resources/table_script.ddl) to see table define.
  * See [data.sql](src/main/resources/data.sql) to see test data populated while application starts.
* Integrate with Swagger documentation:
  * Build and run the project, and access documentation with http://localhost:8080/swagger-ui/index.html
* Unit tests
  * WebMvcTest for controller layer tests - [TransactionControllerTest](src/test/java/com/task/rewardpoints/controller/TransactionControllerTest.java).
  * Mockito for service layer tests - [TransactionServiceTest](src/test/java/com/task/rewardpoints/service/TransactionServiceTest.java).
* Exception Handler
  * Custom exception [CustomerNotFoundException](src/main/java/com/task/rewardpoints/exception/CustomerNotFoundException.java) to handle user input with invalid customer id.
  * Global exception handler [GlobalExceptionHandler](src/main/java/com/task/rewardpoints/exception/GlobalExceptionHandler.java) handles all the exceptions and return from controller layer.
