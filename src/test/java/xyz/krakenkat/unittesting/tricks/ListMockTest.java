package xyz.krakenkat.unittesting.tricks;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    void size_basic() {
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    void returnDifferentValues() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    void returnWithParameters() {
        when(mock.get(0)).thenReturn("hi");
        assertEquals("hi", mock.get(0));
        assertEquals(null, mock.get(1));
    }

    @Test
    void returnWithGenericParameters() {
        when(mock.get(anyInt())).thenReturn("hi");
        assertEquals("hi", mock.get(0));
        assertEquals("hi", mock.get(1));
    }

    // Verify is used to check if a method was called on the test. Verify is used to test void methods.
    @Test
    void verificationBasics() {
        // SUT (System Under Testing)
        String value1 = mock.get(0);
        String value2 = mock.get(1);

        // Verify
        verify(mock).get(0);
        verify(mock, times(2)).get(anyInt());
        verify(mock, atLeast(1)).get(anyInt());
        verify(mock, atLeastOnce()).get(anyInt());
        verify(mock, atMost(2)).get(anyInt());
        verify(mock, never()).get(2);
    }

    // ArgumentCaptor<T> is used to capture the parameters passed to mock method
    @Test
    void argumentCapturing() {
        // SUT
        mock.add("SomeString");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    // Used to capture arguments called multiple times
    @Test
    void multipleArgumentCapturing() {
        // SUT
        mock.add("SomeString1");
        mock.add("SomeString2");

        // Verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString1", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }

    @Test
    void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); // null
        System.out.println(arrayListMock.size()); // 0
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size()); // 0 because arrayListMock is a mock
        when(arrayListMock.size()).thenReturn(5); // Mocking size method behavior
        System.out.println(arrayListMock.size()); // Mocked value -> 5
    }

    // In Mockito, a spy is an object that allows you to wrap an existing instance of a class and selectively override
    // some of its methods. This can be useful for testing purposes when you want to isolate and test a specific
    // behavior of an object.
    //
    // A spy, by default, retains the behavior (code) of the original class.
    //
    // The main difference with Mock is that Spy creates a real object instance.
    //
    // One important thing to note is that when you create a spy object, all the methods of the original object are
    // still executed unless you explicitly stub them. If you don't want to call the original method, you can use the
    // doReturn method to stub it.
    @Test
    void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");

        System.out.println(arrayListSpy.get(0)); // Test0
        System.out.println(arrayListSpy.size()); // 1

        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");

        System.out.println(arrayListSpy.size()); // 3

        // Mocking the behavior of this specific method
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size()); // 5

        arrayListSpy.add("Test3");
        System.out.println(arrayListSpy.size()); // 5 because this method was mocked

        verify(arrayListSpy).add("Test3");

    }
}
