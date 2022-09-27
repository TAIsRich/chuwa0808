2. Document the microservice architecture and components/tools/dependencies

   Microservice is an architecture design pattern. It splits one large application into multiple
   small and independent service based applications. Each service only does one thing. 

   **Pros and Cons**

   Good/Advantage of Microservice:

   - You can update/modify one service without downtime of the entire application. ie. amazon prime: prime day service 
   - You can easily scale up to add more services 
   - For each service, you can use different tech stacks

   Bad/Drawbacks of Microservice

   - Communication between services requires more time and resources
   - DevOps – need more server and people to maintain each servers

   **Components**

   - Zuul API Gateway: it help route the incoming request to different services.
   - Eureka: Every service provided need to register within Eureka Service Registry.
   - Ribbon: load balancer, heling distribute traffic evenly.
   - Hystrix: circuit breaker, When a system call results in an error, the circuit breaker is opened and does not allow any calls to pass through.
   - Config server: Spring Cloud Config Server to manage the configuration for different services, just like pom.xml.
   - kafka: Two service can use Kafka to communicate asynchronously.
   - Docker: Every service is stored in it's own docker and every service has it's own database

3. What are Resilience patterns? What is circuit breaker?

   Resilience patterns includes the following:

   1. Time out: wait too long for another microservice

   2. Fail fast: generate an error as quickly as possible

   3. Bulkhead :Hystrix can use its own thread pool for each type of request.

   4. Circuit breaker: When a system call results in an error, the circuit breaker is opened and does not allow any calls to pass through.

   Circuit breaker: Circuit breakers are a design pattern to create resilient microservices by limiting the impact of service failures and latencies. The major aim of the Circuit Breaker pattern is to prevent any cascading failure in the system. In a microservice system, failing fast is critical.

4. Watching the below videos. and write your understanding about microservice

- Different types of architectures:

  Monolithic: all components in one place.

  Pros:

  - Simple
  - Communication costs between servers are small.

  Cons:

  - All codes must writen in 1 language with 1 technology stack within single run time. 
  - Different teams that work on different functions or parts need to make sure their work will not affect others works
  - If the code for one function is changed, the whole application will need to rebuild, redeploy.

  So it's not good a large teams and big projects.

- Microservice

  Definition: divide a large application into several smaller applications based on domain (DDD - Domain Driven Design) or business functionalities. Each microservice is independent.

- Communications among microservice:
  - Syncronized: calling api endpoints.
  - Asyncronized: Publisher publish the message into the Message Broker(RabbitMQ) and the Message Broker will forward that message to a related Subscriber

- Challenge of Microservice:

  1. Configure the communication between services

     One service is down or having issue, another service is sending request, there will be an unexpected response.

     Kubernetes, aka K8S, is a container orchestration system perfect for automating the management, scaling, and deployment of microservice applications. 

  2. Hard to monitor each service since they can be deploy separately. 

     Consul is the one stop solution for microservices (self) registration, discovery, health checks, key-value store and load balancing