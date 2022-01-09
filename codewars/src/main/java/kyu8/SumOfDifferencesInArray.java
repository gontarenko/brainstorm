package kyu8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class SumOfDifferencesInArray {
    public static void main(String[] args) {
        assert 9 == sumOfDifferences(new int[]{2, 1, 10});
        assert 9 == sumOfDifferences2(new int[]{2, 1, 10});
    }

    public static int sumOfDifferences(int[] arr) {
        if (arr.length < 2)
            return 0;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            sum += arr[i] - arr[i - 1];
        }
        return sum;
    }

    public static int sumOfDifferences2(int[] arr) {
        IntSummaryStatistics statistics = Arrays.stream(arr).summaryStatistics();
        return statistics.getMax() - statistics.getMin();
    }
}
