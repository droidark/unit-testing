package xyz.krakenkat.unittesting.business;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xyz.krakenkat.unittesting.data.SomeDataService;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public int calculateSum(int[] data) {
        return Arrays.stream(data).sum();
    }

    public int calculateSumUsingDataService() {
        return Arrays.stream(someDataService.retrieveAllData()).sum();
    }
}
