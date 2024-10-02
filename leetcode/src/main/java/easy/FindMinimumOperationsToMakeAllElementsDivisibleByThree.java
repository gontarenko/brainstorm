package easy;

import org.junit.Assert;

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {
    public static void main(String[] args) {
        Assert.assertEquals(
                3,
                new FindMinimumOperationsToMakeAllElementsDivisibleByThree().minimumOperations(new int[]{1, 2, 3, 4})
        );
        Assert.assertEquals(
                4,
                new FindMinimumOperationsToMakeAllElementsDivisibleByThree().minimumOperations(new int[]{1, 2, 3, 4, 5})
        );
    }

    public int minimumOperations(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (num % 3 != 0) {
                result++;
            }
        }
        return result;
    }
}
