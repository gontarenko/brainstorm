package easy;

import org.junit.Assert;

public class RemoveTrailingZerosFromAString {
    public static void main(String[] args) {
        Assert.assertEquals(
                "512301",
                new RemoveTrailingZerosFromAString().removeTrailingZeros("51230100")
        );
    }

    public String removeTrailingZeros(String num) {
        StringBuilder sb = new StringBuilder(num);
        for (int i = sb.length() - 1; i > 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    // faster
    public String removeTrailingZeros2(String num) {
        int length = num.length();
        int zeroCount = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (num.charAt(i) == '0') {
                zeroCount++;
            }
        }
        return num.substring(0, length - zeroCount);
    }
}
