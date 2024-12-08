package yandexpr;

public class TwoPointers {
    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, 5, 4, -10, 4, 11};
        int x = 7;

        boolean hasX = hasX(nums, x);
        System.out.println(hasX);
    }

    public static boolean hasX(int[] nums, int x) {
        int left = 0;
        int right = 0;
        int sum = 0;

        while (left < nums.length && right < nums.length) {
            for (int i = left; i <= right; i++) {
                sum += nums[i];
            }
            if (sum == x) {
                return true;
            }
            if (sum < x) {
                right++;
            }
            if (sum > x) {
                left++;
            }
            sum = 0;
        }
        return false;
    }
}
