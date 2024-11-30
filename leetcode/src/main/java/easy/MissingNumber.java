package easy;

public class MissingNumber {
    public static void main(String[] args) {

    }

    public int missingNumber(int[] nums) {
        int sum = 0;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i + 1;
            currentSum += nums[i];
        }
        return sum - currentSum;
    }
}
