package easy;

import org.junit.Assert;

public class LicenseKeyFormatting {
    public static void main(String[] args) {

        LicenseKeyFormatting w = new LicenseKeyFormatting();



        Assert.assertEquals("2-5G-3J", w.licenseKeyFormatting("2-5g-3-J", 2));

//        Input: s = "2-5g-3-J", k = 2
//        Output: "2-5G-3J"
//        Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.

    }

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int group = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                group++;
                sb.append(Character.toUpperCase(c));
                if (group == k) {
                    group = 0;
                    sb.append('-');
                }
            }
        }
        for (int i = sb.length() - 1; i > 0; i--) {
            if (sb.charAt(i) == '-') {
                sb.deleteCharAt(i);
            } else {
                break;
            }
        }
        return sb.reverse().toString();
    }
}
