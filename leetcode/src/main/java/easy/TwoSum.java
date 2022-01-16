package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        assert Arrays.equals(
                new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9),
                new int[]{0, 1}
        );
        assert Arrays.equals(
                new TwoSum().twoSum2(new int[]{2, 7, 11, 15}, 9),
                new int[]{0, 1}
        );
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j)
                    continue;
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numToIndexMap = new HashMap<>();
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (numToIndexMap.containsKey(target - nums[i])) {
                i1 = numToIndexMap.get(target - nums[i]);
                i2 = i;
                break;
            }
            numToIndexMap.put(nums[i], i);
        }
        return new int[]{i1, i2};
    }
}
