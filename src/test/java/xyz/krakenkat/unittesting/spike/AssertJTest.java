package xyz.krakenkat.unittesting.spike;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


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

        assertThat("ABCDE")
                .contains("BCD")
                .startsWith("ABC")
                .endsWith("CDE");
    }
}
