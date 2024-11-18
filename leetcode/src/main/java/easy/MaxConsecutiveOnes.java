package easy;

import org.junit.Assert;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        MaxConsecutiveOnes solution = new MaxConsecutiveOnes();
        // Input: nums = [1,1,0,1,1,1]
        // Output: 3
        // Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
        Assert.assertEquals(3, solution.findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}
