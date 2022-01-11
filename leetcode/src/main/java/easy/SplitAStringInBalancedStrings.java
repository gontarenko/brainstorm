package easy;

public class SplitAStringInBalancedStrings {
    public static void main(String[] args) {
        assert 4 == new Solution().balancedStringSplit("RLRRLLRLRL");
        assert 3 == new Solution().balancedStringSplit("RLLLLRRRLR");
    }

    static class Solution {
        public int balancedStringSplit(String s) {
            int ans = 0;
            int countR = 0;
            int countL = 0;
            for (int i = 0; i < s.length(); i++) {
                char x = s.charAt(i);
                if (x == 'R')
                    countR++;
                else
                    countL++;
                if (countR == countL) {
                    ans += 1;
                    countR = 0;
                    countL = 0;
                }
            }
            return ans;
        }
    }
}
