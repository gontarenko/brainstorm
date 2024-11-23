package easy;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 2, 3};
//        System.out.println(removeElement(nums, 3));
//        System.out.println(Arrays.toString(nums));

        int[] nums = {1, 2, 2, 3, 4};
        System.out.println(removeElement2(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeElement(int[] nums, int val) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num != val) {
                result[index++] = num;
            }
        }
        System.arraycopy(result, 0, nums, 0, index);
        return index;
    }

    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
