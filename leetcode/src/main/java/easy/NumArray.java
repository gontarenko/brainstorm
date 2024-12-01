package easy;

public class NumArray {
    private final int[] nums;

    public NumArray(int[] nums) {
        this.nums = new int[nums.length];
        this.nums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.nums[i] = nums[i] + this.nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left < 1) {
            return nums[right];
        }
        return nums[right] - nums[left - 1];
    }
}
