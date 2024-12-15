package medium;

public class Max_Consecutive_Ones_III {

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }

    public static int longestOnes(int[] nums, int k) {
        int begin = 0;
        int result = Integer.MIN_VALUE;

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

        return result == Integer.MIN_VALUE ? 0 : result;
    }
}
