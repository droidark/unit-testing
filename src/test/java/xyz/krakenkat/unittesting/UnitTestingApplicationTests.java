package xyz.krakenkat.unittesting;

import lombok.SneakyThrows;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;

// @SpringBootTest
// @SpringBootTest is a Spring Test annotation that can be used to test Spring Boot applications. It is a powerful
// annotation that can be used to start up an entire Spring Boot application context for testing purposes.
//
// When you annotate a test class with @SpringBootTest, Spring Boot will automatically load the complete application
// context, including all the beans and configurations. This allows you to test your Spring Boot application in an
// environment that closely resembles the production environment.
//
// By default, @SpringBootTest will start the application context in a way that is optimized for testing. This means
// that the context is started once per test class, and is shared across all test methods within that class. You can
// configure this behavior using the @DirtiesContext annotation.

// @DirtiesContext
// @DirtiesContext is a Spring Test annotation that can be used to indicate that a test method or class modifies the
// Spring application context and should cause the context to be destroyed and recreated for subsequent tests.
//
// When you annotate a test method or class with @DirtiesContext, Spring will destroy the current application context
// and create a new one before running the next test. This can be useful in situations where a test method or class
// modifies the application context in a way that could affect subsequent tests.
//
// It's important to note that using @DirtiesContext can significantly slow down your test suite, as recreating the
// application context can be time-consuming.
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
