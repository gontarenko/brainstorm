package easy;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * 2108. Find First Palindromic String in the Array
 */
public class FindFirstPalindromicStringInTheArray {
    public static void main(String[] args) {
        // Input: words = ["abc","car","ada","racecar","cool"]
        // Output: "ada"
        // Explanation: The first string that is palindromic is "ada".
        // Note that "racecar" is also palindromic, but it is not the first.
        var solution = new FindFirstPalindromicStringInTheArray();

        assertEquals("ada", solution.firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"}));
        assertEquals("ada", solution.streamsSolution1(new String[]{"abc", "car", "ada", "racecar", "cool"}));
        assertEquals("ada", solution.firstPalindrome2(new String[]{"abc", "car", "ada", "racecar", "cool"}));
        assertEquals("ada", solution.streamsSolution2(new String[]{"abc", "car", "ada", "racecar", "cool"}));
    }

    // memory - O(n), performance - O(n)
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (new StringBuilder(word).reverse().toString().equals(word)) {
                return word;
            }
        }
        return "";
    }

    public String streamsSolution1(String[] words) {
        return Arrays.stream(words)
                .filter(word -> new StringBuilder(word).reverse().toString().equals(word))
                .findFirst()
                .orElse("");
    }

    // memory - O(1)
    // performance - O(n)
    public String firstPalindrome2(String[] words) {
        for (String word : words) {
            int length = word.length();
            boolean isPalindrome = true;
            for (int left = 0, right = length - 1; left < length / 2; left++, right--) {
                if (word.charAt(left) != word.charAt(right)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (!isPalindrome)
                continue;
            return word;
        }
        return "";
    }

    public String streamsSolution2(String[] words) {
        return Arrays.stream(words)
                .filter(word -> {
                    int length = word.length();
                    for (int left = 0, right = length - 1; left < length / 2; left++, right--) {
                        if (word.charAt(left) != word.charAt(right)) {
                            return false;
                        }
                    }
                    return true;
                })
                .findFirst()
                .orElse("");
    }
}
