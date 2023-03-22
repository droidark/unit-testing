package xyz.krakenkat.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// The @WebMvcTest annotation is used for Spring MVC tests. It disables full autoconfiguration and instead applies only
// configuration relevant to MVC tests.
// The @WebMvcTest annotation autoconfigure MockMvc instance as well.
@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    // MockMvc is a testing framework in Java used to test Spring MVC applications. It provides a way to test
    // controllers in isolation by simulating HTTP requests and verifying the responses received.
    //
    // MockMvc allows you to write unit tests for your controllers without deploying the application to a server, thus
    // making it faster and more efficient. With MockMvc, you can test the behavior of your controllers, check the
    // status code and content of the response, and also validate the request parameters and headers.
    //
    // MockMvc is a part of the Spring Test framework and is included in the spring-test module. It is widely used in
    // the Spring ecosystem for testing web applications.
    @Autowired
    private MockMvc mockMvc;

    @Test
    void helloWorld_basic() throws Exception {

        // Call GET "/hello-world" application/json
        RequestBuilder request = MockMvcRequestBuilders
                .get("/hello-world")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"))
                .andReturn();

        // Verify hello-world
        //assertEquals("Hello World!", result.getResponse().getContentAsString());
    }

}