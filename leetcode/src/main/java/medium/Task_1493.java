package medium;

public class Task_1493 {
    public static void main(String[] args) {

    }

    public int longestSubarray2(int[] nums) {
        int begin = 0;
        int result = 0;
        int k = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                result = Math.max(result, i - begin + 1);
            } else {
                if (k > 0) {
                    k--;
                    result = Math.max(result, i - begin + 1);
                } else {
                    while (nums[begin++] != 0) {

                    }
                }
            }
        }

        return result - 1;
    }

    public int longestSubarray(int[] nums) {
        int begin = 0;
        int result = 0;
        boolean deleted = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                result = Math.max(result, i - begin + 1 + (deleted ? -1 : 0));
            } else {
                if (deleted) {
                    while (nums[begin++] != 0) {}
                } else {
                    deleted = true;
                }
            }
        }
        if (!deleted) {
            result--;
        }
        return result;
    }
}
