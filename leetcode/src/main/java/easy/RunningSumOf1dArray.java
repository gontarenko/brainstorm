package easy;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

/**
 * 1480. Running Sum of 1d Array
 */
public class RunningSumOf1dArray {
    public static void main(String[] args) {
        var solution = new RunningSumOf1dArray();
        var input = new int[]{1, 2, 3, 4};
        var expected = new int[]{1, 3, 6, 10};
        assertArrayEquals(expected, solution.runningSum(input));
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
