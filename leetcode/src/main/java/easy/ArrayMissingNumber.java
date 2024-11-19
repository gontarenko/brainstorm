package easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayMissingNumber {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(nums.length);

        int[] nums2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums3 = {1, 2, 3, 4, 5, 6, 8, 9, 10};

        System.out.println(findMissingNumber(nums2));
        System.out.println(findMissingNumber(nums3));
    }

    private static int findMissingNumber(int[] nums) {
        int sumWithoutMissingNumber = Arrays.stream(nums).sum();
        int sum = IntStream.range(1, nums.length + 1 + 1).sum();

        return sum - sumWithoutMissingNumber;
    }
}
