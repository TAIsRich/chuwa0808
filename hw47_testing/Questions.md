2. what is selenium

Selenium is a user-behavior simulation. Which will mock the interaction of user's behaviors to test the web applications. 

3. what is cucumber

Cucumber is a behavior driven development tool used to develop test cases for the behavior of software's functionality. Need to define Given, when and then instructions to use Cucumber to test the web application.

4. what is JMeter

JMeter is used to load test functional behavior and measure performance. You can use JMeter to analyze and measure the performance of web application or a variety of services.

5. what is unit-test?

Test of each unit or an individual component of the web application. The purpose is to validate that each unit of the code performs as expected. Unit test is done during development of an application by the developers. 

6. What is the lifecircle of Junit

1. @BeforeAll --> class level setup
2. @BeforeEach --> setup for each test method
3. @Test --> test execution
4. @AfterEach --> cleanUp for each test method
5. @AfterAll --> class level cleanup

7. Is @BeforeAll method should be Class level(static)?

Yes, it will setup for the whole class for the test

8. What is Mockito? and what is its limitations?

Mockito: Create mock object to verify if the interaction will return the defined response to test the code. 

9. What is @Mock and what is @InjectMocks?

We can use @Mock to create and inject mocked instances without having to call Mockito.mock manually.

@InjectMocks annotation to inject mock fields into the tested object automatically.

@Mock
Map<String, String> wordMap;

@InjectMocks
MyDictionary dic = new MyDictionary();

@Test
public void whenUseInjectMocksAnnotation_thenCorrect() {
    Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

    assertEquals("aMeaning", dic.getMeaning("aWord"));
}

10. What is the stubbing?

A stub is a small piece of code that takes the place of another component during testing. The benefit of using a stub is that it returns consistent results, making the test easier to write. And you can run tests even if the other components are not working yet.

11. what is Mockito ArgumentMatchers

Use to put one respond to a wider range of values or unknown values.

Argument matchers are mainly used for performing flexible verification and stubbing in Mockito. It extends ArgumentMatchers class to access all the matcher functions.

12. what is Hamcrest Matchers

assertXXX(value1, value2) to verify if the input values are the same to test if our code will return the expected response

13. do you know @spy? what is difference between @spy and @Mock?

@Mock will mock everything.

@Spy, only mock partial part.