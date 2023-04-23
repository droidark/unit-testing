package xyz.krakenkat.unittesting.spike;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
