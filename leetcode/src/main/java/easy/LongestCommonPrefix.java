package easy;

import static org.junit.Assert.assertEquals;

/**
 * 14. Longest Common Prefix
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        // Input: strs = ["flower","flow","flight"]
        // Output: "fl"
        assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.length() == 0) {
                return "";
            }

            StringBuilder newLcp = new StringBuilder();
            for (int j = 0; j < lcp.length() && j < str.length(); j++) {
                if (lcp.charAt(j) == str.charAt(j)) {
                    newLcp.append(lcp.charAt(j));
                } else {
                    break;
                }
            }
            lcp = newLcp.toString();
        }
        return lcp;
    }
}
