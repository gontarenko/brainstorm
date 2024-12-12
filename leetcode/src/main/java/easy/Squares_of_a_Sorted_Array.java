package easy;

public class Squares_of_a_Sorted_Array {
    public static void main(String[] args) {

    }

    public int[] sortedSquares1(int[] nums) {
        if (nums.length == 1) {
            return new int[]{nums[0] * nums[0]};
        }
        int[] ans = new int[nums.length]; // space - O(n)
        int i = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) { // time - O(n)
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];
            if (r > l) {
                ans[i--] = r;
                right--;
            } else {
                ans[i--] = l;
                left++;
            }
            if (left == right) {
                if (r > l) {
                    ans[i--] = l;
                } else {
                    ans[i--] = r;
                }
            }
        }
        return ans;
    }

    public int[] sortedSquares2(int[] nums) {
        if (nums.length == 1) {
            return new int[]{nums[0] * nums[0]};
        }
        int[] ans = new int[nums.length]; // space - O(n)
        int left = 0;
        int right = nums.length - 1;
        for (int i = ans.length - 1; i >= 0; i--) {
            int l = nums[left] * nums[left];
            int r = nums[right] * nums[right];
            if (r > l) {
                ans[i] = r;
                right--;
            } else {
                ans[i] = l;
                left++;
            }
        }
        return ans;
    }
}
