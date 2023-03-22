package xyz.krakenkat.unittesting.business;

import org.junit.jupiter.api.Test;
import xyz.krakenkat.unittesting.data.SomeDataService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessStubTest {

    @Test
    void calculateSumUsingDataService_basic() {
        int expectedResult = 6;
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setSomeDataService(new SomeDataServiceImpl());
        int actualResult = someBusiness.calculateSumUsingDataService();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSumUsingDataService_empty() {
        int expectedResult = 0;
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setSomeDataService(() -> new int[0]); // <- A Functional Interface example
        int actualResult = someBusiness.calculateSumUsingDataService();
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSumUsingDataService_oneValue() {
        int expectedResult = 2;
        SomeBusinessImpl someBusiness = new SomeBusinessImpl();
        someBusiness.setSomeDataService(() -> new int[] {2}); // <- A Functional Interface example
        int actualResult = someBusiness.calculateSumUsingDataService();
        assertEquals(expectedResult, actualResult);
    }
}

class SomeDataServiceImpl implements SomeDataService {

    @Override
    public int[] retrieveAllData() {
        return new int[] {1,2,3};
    }
}
