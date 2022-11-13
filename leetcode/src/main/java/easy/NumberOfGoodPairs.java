package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * 1512. Number of Good Pairs
 */
public class NumberOfGoodPairs {
    public static void main(String[] args) {
        // Input: nums = [1,2,3,1,1,3]
        // Output: 4
        // Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

        var solution = new NumberOfGoodPairs();
        assertEquals(4, solution.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> numberToIndexCountMap = new HashMap<>();
        int ans = 0;
        for (int key : nums) {
            if (numberToIndexCountMap.containsKey(key)) {
                int indexesCount = numberToIndexCountMap.get(key);
                ans += indexesCount;
                numberToIndexCountMap.put(key, indexesCount + 1);
            } else {
                numberToIndexCountMap.put(key, 1);
            }
        }
        return ans;
    }

    public int numIdenticalPairsSaveIndexes(int[] nums) {
        Map<Integer, List<Integer>> numberToIndexMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (numberToIndexMap.containsKey(key)) {
                List<Integer> indexes = numberToIndexMap.get(key);
                ans += indexes.size();
                indexes.add(i);
            } else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                numberToIndexMap.put(key, indexes);
            }
        }
        return ans;
    }
}
