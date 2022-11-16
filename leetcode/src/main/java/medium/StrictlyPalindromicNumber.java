package medium;

import static org.junit.Assert.assertFalse;

/**
 * 2396. Strictly Palindromic Number
 */
public class StrictlyPalindromicNumber {
    public static void main(String[] args) {
        // Input: n = 9
        // Output: false
        // Explanation: In base 2: 9 = 1001 (base 2), which is palindromic.
        // In base 3: 9 = 100 (base 3), which is not palindromic.
        // Therefore, 9 is not strictly palindromic, so we return false.
        // Note that in bases 4, 5, 6, and 7, n = 9 is also not palindromic.
        var solution = new StrictlyPalindromicNumber();
        assertFalse(solution.isStrictlyPalindromic(9));
    }

    public boolean isStrictlyPalindromic(int n) {
        for (int base = 2; base <= n - 2; base++) {
            String value = Integer.toString(n, base);
            if (!new StringBuilder(value).reverse().toString().equals(value)) {
                return false;
            }
        }
        return true;
    }

}
