package xyz.krakenkat.unittesting.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.krakenkat.unittesting.data.SomeDataService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// Try to keep the unit testing simple as much possible
//
// @ExtendWith(MockitoExtension.class)
// The @ExtendWith annotation is used to load a JUnit 5 extension. JUnit defines an extension API, which allows a
// third-party vendor like Mockito to hook into the lifecycle of running test classes and add additional functionality.
// The MockitoExtension looks at the test class, finds member variables annotated with the @Mock annotation, and creates
// a mock implementation of those variables. It then finds member variables annotated with the @InjectMocks annotation
// and attempts to inject its mocks into those classes, using either construction injection or setter injection.
//
// * hook (sth) into sth:
// To become connected or to connect something to a computer or telephone system
@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {

    // @Mock creates a mock object. Good practice, put @Mock above to @InjectMocks annotation.
    @Mock
    SomeDataService dataServiceMock;

    // @InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy)
    // annotations into this instance. Good practice, put @InjectMocks below to all @Mock
    @InjectMocks
    SomeBusinessImpl someBusiness;

    @Test
    void calculateSumUsingDataService_basic() {
        // When a specific method is called, mockito will return the specific value
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1, 2, 3});
        int actualResult = someBusiness.calculateSumUsingDataService();

        // Then
        assertEquals(6, actualResult);
    }

    @Test
    void calculateSumUsingDataService_empty() {
        // When
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        int actualResult = someBusiness.calculateSumUsingDataService();

        // Then
        assertEquals(0, actualResult);
    }

    @Test
    void calculateSumUsingDataService_oneValue() {
        // When
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {2});
        int actualResult = someBusiness.calculateSumUsingDataService();

        // Then
        assertEquals(2, actualResult);
    }
}
