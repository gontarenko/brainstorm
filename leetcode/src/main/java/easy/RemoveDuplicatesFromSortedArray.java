package easy;

import static org.junit.Assert.assertEquals;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        // Input: nums = [1,1,2]
        // Output: 2, nums = [1,2,_]
        // Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        // It does not matter what you leave beyond the returned k (hence they are underscores).
        int[] expected = new int[]{1, 2};
        int[] input = new int[]{1, 1, 2};
        int k = removeDuplicates(input);
        // assert k == expectedNums.length;
        // for (int i = 0; i < k; i++) {
        //    assert nums[i] == expectedNums[i];
        // }
        assertEquals(expected.length, k);
        for (int i = 0; i < k; i++) {
            assertEquals(expected[i], input[i]);
        }

//        Input: nums = [0,0,1,1,1,2,2,3,3,4]
//        Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]

        int[] expected2 = new int[]{0, 1, 2, 3, 4};
        int[] input2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = removeDuplicates(input2);
        assertEquals(expected2.length, k2);
        for (int i = 0; i < k2; i++) {
            assertEquals(expected2[i], input2[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 1;
        int tmp = nums[0];
        int pointer = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != tmp) {
                tmp = nums[i];
                nums[pointer++] = nums[i];
                result++;
            }
        }
        return result;
    }
}
