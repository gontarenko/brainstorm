package medium;

public class Minimum_Size_Subarray_Sum {

    public int minSubArrayLen(int target, int[] nums) {
        int begin = 0;
        int currSum = 0;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            while (currSum >= target) {
                minCount = Math.min(i - begin + 1, minCount);
                currSum -= nums[begin++];
            }
        }
        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
}
