@SpringBootApplication
SpringBootApplication is the core annotation of SpringBoot, the main purpose is to enable automatic configuration.

@Service
Similar to Component annotations, applied at the service layer.

@Repository
Similar to Component annotations, applied in the data access layer

@Controller
Similar to Component annotations, applied at the control layer

@RestController
Combining annotations, combining @Controller and @ResponseBody

@Autowired
Automatically injected by the Spring dependency injection tool.

@Entity
data object

@Table
Database Table

@Id
database table primary key

@Column
database table column

@GeneratedValue
Automatically generate values

@UniqueConstraint
Values cannot be repeated

@CreationTimestamp


@UpdateTimestamp


@RequestMapping
Used to map web requests

@PostMapping


@RequestBody
Put the return value in the response body


@GetMapping
    The GetMapping annotation is used to process HTTP GET requests and map requests to specific processing methods.
@PutMapping
    The PutMapping annotation is used to process HTTP PUT requests and map requests to specific processing methods
@DeleteMapping
    The DeleteMapping annotation is used to handle HTTP DELETE requests and map requests to delete methods.
@ResponseStatus(value = HttpStatus.NOT_FOUND)
    The ResponseStatus annotation can annotate the request processing method. Using this annotation, the HTTP STATUS required for the response can be specified. In particular, we can use the HttpStauts class to assign values to the value attribute of this annotation.