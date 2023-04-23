# UNIT TESTING IN JAVA
## Table of content
[What is unit testing?](##what-is-unit-testing?)
[Mockito](##mockito)

---

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
```java
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
```
### Business Layer

The business layer doesn't require a special configuration, it's enough to use JUnit and Mockito to fill this part. Follow this code to test the business layer and how to mock the repository layer.
```java
@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

    private List<Item> items;

    @Mock
    ItemRepository itemRepository;

    @InjectMocks
    ItemBusinessService itemBusinessService;

    @Test
    void getAllItems_basic() {
        // given
        int expectedOne = 1000, expectedTwo = 800;

        // when
        when(itemRepository.findAll()).thenReturn(items);
        List<Item> actual = itemBusinessService.getAllItems();

        // then
        assertEquals(expectedOne, actual.get(0).getValue());
        assertEquals(expectedTwo, actual.get(1).getValue());
    }
}
```
### Repository Layer
#### @DataJpaTest

`@DataJpaTest` is a Spring Test annotation that is used to test JPA applications. This annotation is typically used in conjunction with JPA repositories, and it can be used to set up an in-memory database, initialize a test database with test data, and run tests against that database.

When you annotate a test class with `@DataJpaTest`, Spring Boot automatically configures an in-memory H2 database, scans for `@Entity` classes, configures Spring Data JPA repositories, and sets up the necessary dependencies. This allows you to test your JPA repositories in isolation, without having to set up a full Spring application context.

> **_NOTE:_** By default, `@DataJpaTest` will configure a transactional test. This means that each test method will run in its own transaction, and the transaction will be rolled back at the end of the test. This ensures that the tests are isolated and do not interfere with each other.

#### @DataMongoTest

`DataMongoTest` is a Spring Test annotation that is used to test MongoDB applications. This annotation is typically used in conjunction with MongoDB repositories, and it can be used to set up an embedded MongoDB instance, initialize a test database with test data, and run tests against that database.

When you annotate a test class with `@DataMongoTest`, Spring Boot automatically configures an embedded MongoDB database, scans for `@Document` classes, configures Spring Data MongoDB repositories, and sets up the necessary dependencies. This allows you to test your MongoDB repositories in isolation, without having to set up a full Spring application context.

> **_NOTE:_** By default, `@DataMongoTest` will configure a transactional test. This means that each test method will run in its own transaction, and the transaction will be rolled back at the end of the test. This ensures that the tests are isolated and do not interfere with each other.

Follow the next example to do a simple repository test.

```java
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository repository;

    @Test
    void testFindAll() {
        List<Item> items = repository.findAll();
        assertEquals(1001, items.get(0).getId());
    }
}
```
---
## Spring Boot Integration Testing

## What is integration testing?
Integration testing is a software testing methodology that focuses on testing the interactions between different components or modules of a system, to ensure that they work together correctly as a whole. In other words, integration testing is used to test the integration or "glue" code that connects different parts of a system together.

Integration testing is typically performed after unit testing and before system testing. During integration testing, individual modules or components of the system are combined and tested as a group, to ensure that they function correctly together. The purpose of integration testing is to identify and resolve any issues that arise from the interactions between different components, such as interface mismatches, communication problems, or data flow issues.

There are several approaches to integration testing, including top-down, bottom-up, and middle-out. Top-down integration testing involves testing the highest-level components of the system first, and gradually integrating lower-level components. Bottom-up integration testing, on the other hand, involves testing the lowest-level components first, and gradually integrating higher-level components. Middle-out integration testing is a combination of both approaches, where integration testing starts from the middle of the system and expands outwards in both directions.

Integration testing can be performed manually or with the help of automated testing tools. Automated integration testing tools can simulate the interactions between different components of the system and generate reports on the results of the tests.

Integration testing is an important part of the software development process, as it helps to ensure that the system functions correctly as a whole, and that all of the components work together seamlessly. By identifying and resolving issues during integration testing, developers can prevent more serious problems from arising later in the development cycle, and ensure that the final product meets the requirements and expectations of its users.

### Integration testing in Spring
Before to start is important to know a couple to concepts about the integration testing in Spring Boot.

#### @SpringBootTest
`@SpringBootTest` is a Spring Test annotation that can be used to test Spring Boot applications. It is a powerful annotation that can be used to start up an entire Spring Boot application context for testing purposes.

When you annotate a test class with `@SpringBootTest`, Spring Boot will automatically load the complete application context, including all the beans and configurations. This allows you to test your Spring Boot application in an environment that closely resembles the production environment.

By default, `@SpringBootTest` will start the application context in a way that is optimized for testing. This means that the context is started once per test class, and is shared across all test methods within that class. You can configure this behavior using the `@DirtiesContext` annotation.

> **_NOTE:_** It's important to note that `@SpringBootTest` is a heavyweight annotation, and it can take a significant amount of time to start up the entire application context.

#### @DirtiesContext
`@DirtiesContext` is a Spring Test annotation that can be used to indicate that a test method or class modifies the Spring application context and should cause the context to be destroyed and recreated for subsequent tests.

When you annotate a test method or class with `@DirtiesContext`, Spring will destroy the current application context and create a new one before running the next test. This can be useful in situations where a test method or class modifies the application context in a way that could affect subsequent tests.

> **_NOTE:_** It's important to note that using `@DirtiesContext` can significantly slow down your test suite, as recreating the application context can be time-consuming.

#### Integration testing example in controller layer
```java
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UnitTestingApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() throws JSONException {
        String response = restTemplate.getForObject("/all-items-from-database", String.class);
        JSONAssert.assertEquals(fromFile("items-from-db.json"), response, false);
    }

    @SneakyThrows
    private String fromFile(String path) {
        return new String(new ClassPathResource(path).getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
```

---

## Testing frameworks

### Hamcrest
Hamcrest is a testing framework for Java that provides a set of matchers that can be used to write expressive and readable tests. Hamcrest matchers allow you to write tests in a more natural language style, making it easier to understand the intent of the test.

Hamcrest matchers can be used with any testing framework that supports JUnit or TestNG, including popular testing frameworks such as Mockito, JMock, and EasyMock. Hamcrest matchers can also be used with the built-in assertions provided by JUnit and TestNG.

Hamcrest provides a wide range of matchers, including matchers for collections, strings, numbers, objects, and more. You can also write your own custom matchers if needed.

Using Hamcrest can make your tests more readable and easier to maintain, especially when dealing with complex data structures and objects.

Simple example using Hamcrest:

```java
public class HamcrestMatcherTest {
    
    @Test
    void learning () {
        List<Integer> numbers = List.of(12, 15, 45);
        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(12, 45));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(100)));

        // Strings
        assertThat("", is(emptyString()));
        assertThat("ABCDE", containsString("BCD"));
        assertThat("ABCDE", startsWith("ABC"));
        assertThat("ABCDE", endsWith("CDE"));
    }
}
```

### AssertJ

AssertJ is a popular assertion library for Java that provides a fluent API for writing expressive and readable tests. Like Hamcrest, AssertJ aims to make tests more readable and maintainable, but it provides a more modern and intuitive API.

AssertJ provides a rich set of assertions that cover various types of objects, such as collections, dates, strings, numbers, and more. You can also easily extend AssertJ with your own custom assertions to meet your specific testing needs.

AssertJ also provides advanced features, such as soft assertions, which allow you to continue running tests even if an assertion fails. This can be useful when you want to report all the failures in a test, rather than stopping at the first one.

Overall, AssertJ is a powerful and user-friendly assertion library that can help you write more readable, maintainable, and effective tests.

Simple example using AssertJ:

```java
public class AssertJTest {

    @Test
    void learning() {
        List<Integer> numbers = List.of(12, 15, 45);

        assertThat(numbers)
                .hasSize(3)
                .contains(12, 15)
                .allMatch(n -> n > 10)
                .allMatch(n -> n < 100)
                .noneMatch(n -> n < 0);

        assertThat("").isEmpty();

        // Strings
        assertThat("ABCDE")
                .contains("BCD")
                .startsWith("ABC")
                .endsWith("CDE");
    }
}
```
### JSONPath

JSONPath is a query language used to extract specific data from JSON (JavaScript Object Notation) documents. It is commonly used in Java testing frameworks like Rest Assured to verify the response of RESTful API endpoints that return JSON data.

In Rest Assured, JSONPath expressions are used to extract values from the JSON response and perform assertions on them. JSONPath's expressions are similar to XPath expressions used in XML, but they are specifically designed for JSON data.

Overall, JSONPath is a powerful tool for testing REST API endpoints that return JSON data in Java, as it allows you to easily extract and verify specific data in the response.

Simple example using some JSONPath features:

```java
public class JsonPathTest {

    @Test
    void learning() {
        String responseService = fromFile("items-from-db.json");

        DocumentContext context = JsonPath.parse(responseService);

        // Get length of the array
        int length = context.read("$.length()");

        // Get the ids inside the json
        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(1001, 1002, 1003);

        // Some properties from JsonPath
        System.out.println(context.read("$.[1]").toString());
        System.out.println(context.read("$.[0:1]").toString()); // The right index is exclusive
        System.out.println(context.read("$.[?(@.name=='Item-1003')]").toString());
        System.out.println(context.read("$.[?(@.quantity==201)]").toString());
    }

    @SneakyThrows
    private String fromFile(String path) {
        return new String(new ClassPathResource(path).getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
```
---
## Coverage

Code coverage is a metric used in software testing to measure the degree to which the source code of a program has been executed by a test suite. It indicates how much of the code has been exercised by tests, and can be used to assess the quality of the test suite.

Code coverage is typically expressed as a percentage, representing the proportion of code that has been executed by tests. There are different types of code coverage metrics, such as statement coverage, branch coverage, and path coverage, each measuring different aspects of code execution.

Statement coverage, for example, measures the percentage of executable statements in the code that have been executed by tests. Branch coverage measures the percentage of decision points (such as if-else statements) that have been executed by tests. Path coverage measures the percentage of possible execution paths in the code that have been exercised by tests.

Code coverage can be measured using a variety of tools, including code analysis tools, profiling tools, and test coverage tools. These tools can generate reports that show which lines of code have been executed by tests, and which lines have not.

> **_NOTE:_** While code coverage is an important metric for assessing the quality of a test suite, it is not a guarantee of correctness. It is possible to have high code coverage but still have bugs in the program, or to have low code coverage but still have a correct program. Therefore, code coverage should be used in conjunction with other testing techniques, such as code reviews, static analysis, and manual testing, to ensure that software is of high quality.
---
## JaCoCo

**JaCoCo** (Java Code Coverage) is an open-source code coverage tool that can be used to measure how much of your Java code is being executed during testing. It was created by the EclEmma team, and is now an official Eclipse Foundation project.

**JaCoCo** provides detailed information about which lines of code are executed during tests and which are not. This information can be used to identify areas of your code that are not being adequately tested and to improve your test suite. JaCoCo can generate coverage reports in a variety of formats, including HTML, XML, and CSV.

One of the key features of **JaCoCo** is its ability to measure code coverage at the instruction level. This means that it can detect if certain branches or conditions within a line of code are not being executed during testing, which is particularly useful for identifying edge cases and boundary conditions that may be missed by less detailed code coverage tools.

**JaCoCo** can be easily integrated with a wide range of build tools and frameworks, including Maven, Gradle, Ant, and Eclipse. It supports both offline and online instrumentation, and can be used with both unit tests and integration tests. Overall, **JaCoCo** is a powerful and flexible tool for measuring code coverage in Java applications.

The steps to configure **JaCoCo** are the next

### Add plugin in Maven
```xml
<!-- JACOCO -->
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>${jacoco.version}</version>
    <configuration>
        <destFile>${basedir}/target/coverage-reports/jacoco-unit.exec</destFile>
        <dataFile>${basedir}/target/coverage-reports/jacoco-unit.exec</dataFile>
        <output>file</output>
        <append>true</append>
        <excludes>
            <exclude>*MethodAccess</exclude>
            <exclude>**/model/**</exclude>
            <exclude>**/repository/**</exclude>
        </excludes>
    </configuration>
    <executions>
        <execution>
            <id>jacoco-initialize</id>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
            <phase>test-compile</phase>
        </execution>
        <execution>
            <id>jacoco-site</id>
            <phase>verify</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
<!-- MUST BE ADDED IF YOU'RE USING JUNIT 5 -->
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>${surefire.version}</version>
</plugin>
```

### Execute Maven

Execute `mvn clean install` to generate the JaCoCo report.

> **_NOTE:_** In `\target\site\jacoco` you'll be able to find the file called **index.html** with all the details related to JaCoCo reports.

---

## Advices
- Try to keep the unit testing simple as much possible.
- Do not mock types you don’t own.
- Don’t mock value objects.
- Don’t mock everything
- Review [XUnit Test Patterns](http://xunitpatterns.com/) to know more about the different testing patterns.
- Put focus on business layer and try to put in minimum the repository and controller layer.
- Try to avoid launching Spring Test Context as mush as possible.
- A good unit testing should be:
  - **Fast:** One look at the test, and you know what is being tested!
  - **Readable:** What happens if unit tests take a long time to run?
  - **Isolated:** Fails only when there is an issue with code!
  - **Run Often:**
    - What is the use of having unit tests which are not run frequently?
    - What happen if you don't commit code often?