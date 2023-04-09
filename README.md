# UNIT TESTING IN JAVA
## What is unit testing?
Unit testing is a software testing technique where individual units or components of a software system are tested in isolation from the rest of the system to ensure that they work correctly. In this approach, a unit is the smallest testable part of a software application, such as a function, method, or class.

Unit testing involves writing automated tests that exercise a unit of code, typically using a framework or tool that provides facilities for creating test cases, running tests, and reporting results. These tests are designed to verify that the unit behaves as expected under various input conditions, and that it produces the expected output and side effects.

Unit testing is a critical part of the software development process as it helps developers catch bugs early in the development cycle, before they become more complex and costly to fix. It also helps to ensure that changes to the codebase do not introduce regressions, i.e., unintended changes in functionality. Overall, unit testing is an important practice for building reliable, maintainable, and scalable software systems.

## Difference between unit testing and coverage testing
Unit testing and coverage testing are two different types of software testing techniques that serve different purposes.

Unit testing is a technique in which individual units or components of a software system are tested in isolation from the rest of the system. The primary goal of unit testing is to ensure that each unit of code works as intended and meets its specifications. This is achieved by creating and running automated tests that verify the behavior of the code under different conditions.

Coverage testing, on the other hand, is a technique that measures how much of the codebase is covered by the tests. Coverage testing provides a quantitative measure of the degree to which the automated tests exercise the code. The idea is to ensure that the tests cover as much of the code as possible, so that any potential bugs or issues are more likely to be caught.

In other words, unit testing focuses on testing the behavior of individual units of code, while coverage testing focuses on measuring the completeness of the test suite with respect to the codebase. While unit testing is a form of testing, coverage testing is a form of analysis.

Overall, both unit testing and coverage testing are important techniques for ensuring the quality of software systems, but they serve different purposes and are complementary to each other.

---

## Junit
JUnit is a popular open-source testing framework for Java that is widely used for unit testing. It provides an easy-to-use API for writing and running automated tests, making it an essential tool for developers who practice Test-Driven Development (TDD) or Behavior-Driven Development (BDD).

JUnit allows developers to write tests that can be executed automatically, making it possible to quickly and easily verify that code is working as expected. JUnit also provides a number of features that make it easy to set up and tear down test fixtures, organize tests into suites, and handle exceptions and errors.

JUnit is widely used in the Java development community, and has become an essential tool for developers who want to ensure the quality and correctness of their code. It is supported by a large community of developers and has a wide range of plugins and extensions that make it easy to integrate with other development tools and frameworks.

### Junit most common annotations
| **Annotation**           | **Description**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       |
|--------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `@Test`                  | Denotes that a method is a test method. Unlike JUnit 4's `@Test` annotation, this annotation does not declare any attributes, since test extensions in JUnit Jupiter operate based on their own dedicated annotations. Such methods are _inherited_ unless they are _overridden_.                                                                                                                                                                                                                                                                                                                                     |
| `@ParameterizedTest`     | Denotes that a method is a [parameterized test](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests). Such methods are _inherited_ unless they are _overridden_.                                                                                                                                                                                                                                                                                                                                                                                                                      |
| `@RepeatedTest`          | Denotes that a method is a test template for a [repeated test](https://junit.org/junit5/docs/current/user-guide/#writing-tests-repeated-tests). Such methods are _inherited_ unless they are _overridden_.                                                                                                                                                                                                                                                                                                                                                                                                            |
| `@TestFactory`           | Denotes that a method is a test factory for [dynamic tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests). Such methods are _inherited_ unless they are _overridden_.                                                                                                                                                                                                                                                                                                                                                                                                                |
| `@TestTemplate`          | Denotes that a method is a [template for test cases](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-templates) designed to be invoked multiple times depending on the number of invocation contexts returned by the registered [providers](https://junit.org/junit5/docs/current/user-guide/#extensions-test-templates). Such methods are _inherited_ unless they are _overridden_.                                                                                                                                                                                                             |
| `@TestClassOrder`        | Used to configure the [test class execution order](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-execution-order-classes) for `@Nested` test classes in the annotated test class. Such annotations are _inherited_.                                                                                                                                                                                                                                                                                                                                                                            |
| `@TestMethodOrder`       | Used to configure the [test method execution order](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-execution-order-methods) for the annotated test class; similar to JUnit 4's `@FixMethodOrder`. Such annotations are _inherited_.                                                                                                                                                                                                                                                                                                                                                             |
| `@TestInstance`          | Used to configure the [test instance lifecycle](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle) for the annotated test class. Such annotations are _inherited_.                                                                                                                                                                                                                                                                                                                                                                                                              |
| `@DisplayName`           | Declares a custom [display name](https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-names) for the test class or test method. Such annotations are not _inherited_.                                                                                                                                                                                                                                                                                                                                                                                                                              |
| `@DisplayNameGeneration` | Declares a custom [display name generator](https://junit.org/junit5/docs/current/user-guide/#writing-tests-display-name-generator) for the test class. Such annotations are _inherited_.                                                                                                                                                                                                                                                                                                                                                                                                                              |
| `@BeforeEach`            | Denotes that the annotated method should be executed _before_ **each** `@Test`, `@RepeatedTest`, `@ParameterizedTest`, or `@TestFactory` method in the current class; analogous to JUnit 4's `@Before`. Such methods are _inherited_ – unless they are _overridden_ or _superseded_ (i.e., replaced based on signature only, irrespective of Java’s visibility rules).                                                                                                                                                                                                                                                |
| `@AfterEach`             | Denotes that the annotated method should be executed _after_ **each** `@Test`, `@RepeatedTest`, `@ParameterizedTest`, or `@TestFactory` method in the current class; analogous to JUnit 4's `@After`. Such methods are _inherited_ – unless they are _overridden_ or _superseded_ (i.e., replaced based on signature only, irrespective of Java’s visibility rules).                                                                                                                                                                                                                                                  |
| `@BeforeAll`             | Denotes that the annotated method should be executed _before_ **all** `@Test`, `@RepeatedTest`, `@ParameterizedTest`, and `@TestFactory` methods in the current class; analogous to JUnit 4's `@BeforeClass`. Such methods are _inherited_ – unless they are _hidden_, _overridden_, or _superseded_, (i.e., replaced based on signature only, irrespective of Java’s visibility rules) – and must be `static` unless the "per-class" [test instance lifecycle](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle) is used.                                                     |
| `@AfterAll`              | Denotes that the annotated method should be executed _after_ **all** `@Test`, @RepeatedTest, @ParameterizedTest, and @TestFactory methods in the current class; analogous to JUnit 4’s @AfterClass. Such methods are inherited – unless they are hidden, overridden, or superseded, (i.e., replaced based on signature only, irrespective of Java’s visibility rules) – and must be static unless the "per-class" [test instance lifecycle](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle) is used.                                                                         |
| `@Nested`                | Denotes that the annotated class is a non-static [nested test class](https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested). On Java 8 through Java 15, `@BeforeAll` and `@AfterAll` methods cannot be used directly in a `@Nested` test class unless the "per-class" [test instance lifecycle](https://junit.org/junit5/docs/current/user-guide/#writing-tests-test-instance-lifecycle) is used. Beginning with Java 16, `@BeforeAll` and `@AfterAll` methods can be declared as `static` in a `@Nested` test class with either test instance lifecycle mode. Such annotations are not _inherited_. |
| `@Tag`                   | Used to declare [tags for filtering tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-tagging-and-filtering), either at the class or method level; analogous to test groups in TestNG or Categories in JUnit 4. Such annotations are inherited at the class level but not at the method level.                                                                                                                                                                                                                                                                                                   |
| `@Disabled`              | Used to [disable](https://junit.org/junit5/docs/current/user-guide/#writing-tests-disabling) a test class or test method; analogous to JUnit 4's `@Ignore`. Such annotations are not _inherited_.                                                                                                                                                                                                                                                                                                                                                                                                                     |
| `@Timeout`               | Used to fail a test, test factory, test template, or lifecycle method if its execution exceeds a given duration. Such annotations are _inherited_.                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| `@ExtendWith`            | Used to [register extensions declaratively](https://junit.org/junit5/docs/current/user-guide/#extensions-registration-declarative). Such annotations are _inherited_.                                                                                                                                                                                                                                                                                                                                                                                                                                                 |
| `@RegisterExtension`     | Used to [register extensions programmatically](https://junit.org/junit5/docs/current/user-guide/#extensions-registration-programmatic) via fields. Such fields are _inherited_ unless they are _shadowed_. |

---

## Mockito

### What is Mockito?
Mockito is a popular open-source Java testing framework used for creating mock objects in unit testing. Mockito provides an easy-to-use API for creating mock objects that mimic the behavior of real objects in a controlled way, allowing developers to test code in isolation without needing to set up complex dependencies.

Mockito can be used to mock both interfaces and concrete classes, and supports a wide range of mocking features, including mocking methods with different return values, throwing exceptions, verifying method calls, and more.

Using Mockito, developers can write more effective and efficient unit tests, which can lead to better quality code and faster development cycles. It is widely used in both Java development and testing communities, and has become an essential tool for developers who practice Test-Driven Development (TDD) or Behavior-Driven Development (BDD).

### How to use Mockito

#### Annotations

`@Mock` Creates a mock object. Good practice, put `@Mock` above to `@InjectMocks` annotation. Example:
```java
public class DemoClassTest {
    
    @Mock
    private ServiceA serviceA;

    @Mock
    private ServiceB serviceB;

    @InjectMocks
    private DemoClass demoClass;
}
```

`@InjectMocks` Creates an instance of the class and injects the mocks that are created with the `@Mock` (or `@Spy`). annotations into this instance. Good practice, put `@InjectMocks` below to all `@Mock`

`@ExtendWith(MockitoExtension.class)` The `@ExtendWith` annotation is used to load a **JUnit 5** extension. JUnit defines an extension API, which allows a third-party vendor like **Mockito** to hook into the lifecycle of running test classes and add additional functionality.

The MockitoExtension looks at the test class, finds member variables annotated with the @Mock annotation, and creates a mock implementation of those variables. It then finds member variables annotated with the `@InjectMocks` annotation and attempts to inject its mocks into those classes, using either construction injection or setter injection.
> **_NOTE:_**  hook (sth) into sth:
> To become connected or to connect something to a computer or telephone system

---

## Spring Boot Unit Testing

### Controller Layer
Before doing a controller test is relevant to know some important annotations that help us to achieve the unit testing over the controller layer.

#### @MockMvc
`@MockMvc` is a testing framework in Java used to test Spring MVC applications. It provides a way to test controllers in isolation by simulating HTTP requests and verifying the responses received.

`@MockMvc` allows you to write unit tests for your controllers without deploying the application to a server, thus making it faster and more efficient. With MockMvc, you can test the behavior of your controllers, check the status code and content of the response, and also validate the request parameters and headers.

`@MockMvc` is a part of the Spring Test framework and is included in the spring-test module. It is widely used in the Spring ecosystem for testing web applications.

#### @WebMvcTest
The `@WebMvcTest` annotation is used for Spring MVC tests. It disables full autoconfiguration and instead applies only configuration relevant to MVC tests.
> **_NOTE:_** The `@WebMvcTest` annotation autoconfigure `@MockMvc` instance as well.

#### @MockBean
`@MockBean` is an annotation in the Spring Framework used for unit testing. It is used to mock a bean that is part of the application context so that it can be replaced with a test double during testing.

When `@MockBean` is used, the Spring context will replace the bean with a mock or a stub that can be used in the test. This allows you to test your code in isolation, without having to rely on other parts of the application.

Follow the next example to do a controller unit testing:
````java
@WebMvcTest(ItemController.class)
class ItemControllerTest {
    
    @MockBean
    private ItemBusinessService service;
    
    @Test
    void retrieveAllItems_basic() throws Exception {
        when(service.getAllItems()).thenReturn(List.of(
                Item.builder()
                        .id(1)
                        .name("Ball")
                        .price(10)
                        .quantity(100)
                        .build()));

        // GET call to "/all-items-from-database" that produces an application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(request)
                .andExpect(status().isOk())
                // content() is the method who get the response from the controller
                // so, content() can be used as actualResult
                //
                // Get the expected json response from a json file, so that is the expectedResult
                .andExpect(content() // <- works as ACTUAL RESULT
                        .json(fromFile("item-list.json"))) // <- works as EXPECTED RESULT
                .andReturn();
    }

    // Method to get json content from json file and parse as String to compare against actual result.
    @SneakyThrows
    private String fromFile(String path) {
        return new String(new ClassPathResource(path).getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
````


---

## Advices
- Try to keep the unit testing simple as much possible.
- Do not mock types you don’t own.
- Don’t mock value objects.
- Don’t mock everything