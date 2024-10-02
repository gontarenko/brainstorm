package easy;

import org.junit.Assert;

public class FindTheMaximumAchievableNumber {
    public static void main(String[] args) {
        Assert.assertEquals(7, new FindTheMaximumAchievableNumber().theMaximumAchievableX(3, 2));
    }

    public int theMaximumAchievableX(int num, int t) {
        return num + t * 2;
    }
}
