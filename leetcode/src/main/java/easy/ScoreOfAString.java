package easy;

import org.junit.Assert;

/**
 * 3110. Score of a String
 */
public class ScoreOfAString {
    public static void main(String[] args) {
        Assert.assertEquals(13, new ScoreOfAString().scoreOfString("hello"));
    }

    public int scoreOfString(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int result = 0;
        int prev = s.charAt(0);
        for (int i = 1; i < length; i++) {
            int current = s.charAt(i);
            result += Math.abs(prev - current);
            prev = current;
        }
        return result;
    }
}
