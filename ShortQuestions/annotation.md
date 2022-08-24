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