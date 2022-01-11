package easy;

import java.util.Arrays;

public class MaximumProductDifferenceBetweenTwoPairs {
    public static void main(String[] args) {
        assert 34 == new Solution().maxProductDifference(new int[]{5, 6, 2, 7, 4});
    }

    static class Solution {
        public int maxProductDifference(int[] nums) {
            Arrays.sort(nums);
            return (nums[nums.length -1] * nums[nums.length - 2]) - (nums[0] * nums[1]);
        }
    }
}
