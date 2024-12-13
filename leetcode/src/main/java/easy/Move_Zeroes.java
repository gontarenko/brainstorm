package easy;

public class Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                nums[index++] = num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        int w = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                w = i;
                break;
            }
        }
        if (w == -1) {
            return;
        }
        for (int i = w + 1;i < nums.length;i++) {
            int num = nums[i];
            if (num != 0) {
                nums[w++] = num;
                nums[i] = 0;
            }
        }
    }
}
