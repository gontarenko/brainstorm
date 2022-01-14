package kyu8;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayPlusArray {
    public static void main(String[] args) {
        assert 21 == arrayPlusArray(new int[]{1, 2, 3}, new int[]{4, 5, 6});
        assert 21 == arrayPlusArray2(new int[]{1, 2, 3}, new int[]{4, 5, 6});
    }

    public static int arrayPlusArray(int[] arr1, int[] arr2) {
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sum();
    }

    public static int arrayPlusArray2(int[] arr1, int[] arr2) {
        int sum = 0;
        for (int i : arr1) {
            sum += i;
        }
        for (int i : arr2) {
            sum += i;
        }
        return sum;
    }
}
