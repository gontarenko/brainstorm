package easy;

import org.junit.Assert;

public class TeemoAttacking {
    public static void main(String[] args) {
        TeemoAttacking sol = new TeemoAttacking();
        // Input: timeSeries = [1,4], duration = 2
        //Output: 4
        //Explanation: Teemo's attacks on Ashe go as follows:
        //- At second 1, Teemo attacks, and Ashe is poisoned for seconds 1 and 2.
        //- At second 4, Teemo attacks, and Ashe is poisoned for seconds 4 and 5.
        //Ashe is poisoned for seconds 1, 2, 4, and 5, which is 4 seconds in total.

        // poisoned = [t, t + duration - 1]

        Assert.assertEquals(4, sol.findPoisonedDuration(new int[]{1, 4}, 2));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        int[] poisonedInterval = new int[2];
        poisonedInterval[0] = timeSeries[0];
        poisonedInterval[1] = timeSeries[0] + duration - 1;
        for (int i = 1; i < timeSeries.length; i++) {
            int attackTime = timeSeries[i];
            if (attackTime <= poisonedInterval[1]) {
                poisonedInterval[1] = attackTime + duration - 1;
            } else {
                result += poisonedInterval[1] - poisonedInterval[0] + 1;
                poisonedInterval[0] = attackTime;
                poisonedInterval[1] = attackTime + duration - 1;
            }
        }
        result += poisonedInterval[1] - poisonedInterval[0] + 1;
        return result;
    }
}
