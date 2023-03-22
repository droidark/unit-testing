package xyz.krakenkat.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssetTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

    @Test
    void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResult = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

        // strict parameter compare each property between two responses, otherwise, false only compare some properties.
        // The exact structure will match
        JSONAssert.assertEquals(expectedResult, actualResponse, true);
    }

    @Test
    void jsonAssert_StrictFalse() throws JSONException {
        String expectedResult = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResult, actualResponse, false);
    }

    @Test
    void jsonAssert_WithoutScapeCharacters() throws JSONException {
        String expectedResult = "{id:1, name:Ball, price:10, quantity:100}";
        JSONAssert.assertEquals(expectedResult, actualResponse, false);
    }
}
