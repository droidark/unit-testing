package xyz.krakenkat.unittesting.controller;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import xyz.krakenkat.unittesting.model.Item;
import xyz.krakenkat.unittesting.service.ItemBusinessService;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // @MockBean is an annotation in the Spring Framework used for unit testing. It is used to mock a bean that is part
    // of the application context so that it can be replaced with a test double during testing.
    //
    // When @MockBean is used, the Spring context will replace the bean with a mock or a stub that can be used in the
    // test. This allows you to test your code in isolation, without having to rely on other parts of the application.
    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    void dummyItem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                // json doesn't match the exact string, like string() method
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
    }

    @Test
    void dummyItem_fromFile() throws Exception {
        when(itemBusinessService.getHardcodedItem()).thenReturn(Item.builder().id(1).name("Ball").quantity(10).price(100).build());

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                // Get the expected json response from a json file
                .andExpect(content().json(fromFile("item.json")))
                .andReturn();
    }

    @Test
    void itemFromBusinessService_basic () throws Exception {

        when(itemBusinessService.getHardcodedItem()).thenReturn(Item.builder()
                .id(1)
                .name("Ball")
                .quantity(100)
                .price(10)
                .build());

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                // content() is the method who get the response from the controller
                // so, content() can be used as actualResult
                //
                // Get the expected json response from a json file, so that is the expectedResult
                .andExpect(content().json(fromFile("item.json")))
                .andReturn();
    }

    @Test
    void retrieveAllItems_basic() throws Exception {
        when(itemBusinessService.getAllItems()).thenReturn(List.of(
                Item.builder()
                        .id(1)
                        .name("Ball")
                        .price(10)
                        .quantity(100)
                        .build()));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content() // actual result
                        .json(fromFile("item-list.json"))) // expected result
                .andReturn();
    }

    @SneakyThrows
    private String fromFile(String path) {
        return new String(new ClassPathResource(path).getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}