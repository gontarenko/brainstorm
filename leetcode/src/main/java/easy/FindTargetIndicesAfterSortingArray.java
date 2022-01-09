package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetIndicesAfterSortingArray {

    public static void main(String[] args) {
        assert Arrays.equals(
                new Solution().targetIndices(new int[]{1, 2, 5, 2, 3}, 2).stream()
                        .mapToInt(x -> x)
                        .toArray(),
                new int[]{1, 2}
        );
    }

    static class Solution {
        public List<Integer> targetIndices(int[] nums, int target) {
            Arrays.sort(nums);
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target)
                    ans.add(i);
            }
            return ans;
        }
    }
}
