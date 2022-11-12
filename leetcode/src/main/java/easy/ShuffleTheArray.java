package easy;

import static org.junit.Assert.*;

/**
 * 1470. Shuffle the Array
 */
public class ShuffleTheArray {

    public static void main(String[] args) {

        // Input: nums = [2,5,1,3,4,7], n = 3
        // Output: [2,3,5,4,1,7]
        // Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

        var solution = new ShuffleTheArray();
        var expected = new int[]{2, 3, 5, 4, 1, 7};
        assertArrayEquals(expected, solution.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3));
    }

    public int[] shuffle(int[] nums, int p2) {
        int[] ans = new int[nums.length];
        int index = 0;
        int p1 = 0;
        while (p2 < nums.length) {
           ans[index++] = nums[p1++];
           ans[index++] = nums[p2++];
        }
        return ans;
    }
}
