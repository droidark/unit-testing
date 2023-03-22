package xyz.krakenkat.unittesting.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// It's important to test many scenarios
class SomeBusinessTest {

    @Test
    void calculateSum_basic() {
        int expectedResult = 6;
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int actualResult = someBusiness.calculateSum(new int[] {1,2,3});
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_empty() {
        int expectedResult = 0;
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int actualResult = someBusiness.calculateSum(new int[] {});
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSum_oneValue() {
        int expectedResult = 5;
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        int actualResult = someBusiness.calculateSum(new int[] {5});
        assertEquals(expectedResult, actualResult);
    }
}