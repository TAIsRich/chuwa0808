## Test
### @SpringBootTest
Spring Boot provides a convenient way to start up an application context to be used in a test.

### @Test
- Test is used to signal that the annotated method is a test method.
- @Test methods must **not** be **private** or **static** and must **not return a value**.
```
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegisterUseCaseIntegrationTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Test
    void registrationWorksThroughAllLayers() throws Exception {
	    UserResource user = new UserResource("Zaphod", "zaphod@galaxy.net");

	    mockMvc.perform(post("/forums/{forumId}/register", 42L)
			.contentType("application/json")
			.param("sendWelcomeMail", "true")
			.content(objectMapper.writeValueAsString(user)))
			.andExpect(status().isOk());

	    UserEntity userEntity = userRepository.findByName("Zaphod");
	    assertThat(userEntity.getEmail()).isEqualTo("zaphod@galaxy.net");
    }
}
```
```
If the property foo exists in the default setting, it will be overridden by the value bar for this test.

@SpringBootTest(properties = "foo=bar")
class SpringBootPropertiesTest {
    @Value("${foo}")
    String foo;

    @Test
    void test(){
        assertThat(foo).isEqualTo("bar");
    }
}
```