# Annotation Notes

##API Gateway -  Zull/Zull2/Spring Cloud Gateway
###Dependency Management
  <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    

##Service Discovery - Eureka

###Dependency Management 
<dependency>
      <groupId>org.springframework.cloud</groupId>
      <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
 
  <dependencyManagement>
    <dependencies>
      <dependency>
        
<groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-dependencies</artifactId>
        <version>${spring-cloud.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>


####@EnableEurekaServer
    e.g.,
    @SpringBootApplication
    @EnableEurekaServer
    public class EurekaServerApplication {
      public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
      }
    }
    
####@EnableEurekaClient
    Added on top of the client service

##Circuit Breaker
##Load Balancer

####@EnableHystrix
The @EnableHystrix annotation is used to enable the Hystrix functionalities into your Spring Boot application. To enable Hystrix, we have to annotate our main class with either @EnableCircuitBreaker or @EnableHystrix. The former option allows us to implement the circuit breaker pattern with other technologies as well. The latter option allows us to implement the circuit breaker pattern only with Hystrix.

####@EnableCircuitBreaker
    The @EnableCircuitBreaker annotation will scan the classpath for any compatible Circuit Breaker implementation.
    
####@@LoadBalanced
    Spring contains the  RestTemplate to easily implement REST calls. If a  RestTemplate is 
created by Spring and annotated with  @LoadBalanced

    e.g.,
    @SpringBootApplication
    @EnableCircuitBreaker
    public class VaccinationCenterApplication {
      public static void main(String[] args) {
        SpringApplication.run(VaccinationCenterApplication.class, args);
      }
      
      @Bean
      @LoadBalanced
      public RestTemplate getRestTemplate() {
        return new RestTemplate();
      }
    }

####@HytrixCommand
    It specify the fallbackMethod.
    
    e.g.,
    @GetMapping("/id/{id}")
    @HystrixCommand(fallbackMethod = "handleCitizenDownTime")
    public ResponseEntity<RequiredResponse> getAllDataBasedonCenterId(@PathVariable Integer id) {
        RequiredResponse response = new RequiredResponse();
        //get vaccination center detail
        ...
    }
