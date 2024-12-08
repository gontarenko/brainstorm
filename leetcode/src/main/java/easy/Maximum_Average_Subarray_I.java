package easy;

public class Maximum_Average_Subarray_I {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double currentSum = 0.;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        double maxAvg = currentSum / k;
        for (int i = k; i < nums.length; i++) {
            currentSum -= nums[i - k];
            currentSum += nums[i];
            double avg = currentSum / k;
            if (avg > maxAvg) {
                maxAvg = avg;
            }
        }

        return maxAvg;
    }
}
