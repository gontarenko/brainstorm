package easy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 9. Palindrome Number
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        assertFalse(isPalindrome(10));
        assertFalse(isPalindrome(-121));
        assertTrue(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int input = x;
        int result = 0;
        while (x != 0) {
            result = (result * 10) + (x % 10);
            x /= 10;
        }
        return input == result;
    }
}
