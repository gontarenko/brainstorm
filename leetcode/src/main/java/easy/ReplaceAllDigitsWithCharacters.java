package easy;

import static org.junit.Assert.assertEquals;

/**
 * 1844. Replace All Digits with Characters
 */
public class ReplaceAllDigitsWithCharacters {
    public static void main(String[] args) {
        // Input: s = "a1c1e1"
        // Output: "abcdef"
        // Explanation: The digits are replaced as follows:
        // - s[1] -> shift('a',1) = 'b'
        // - s[3] -> shift('c',1) = 'd'
        // - s[5] -> shift('e',1) = 'f'
        var solution = new ReplaceAllDigitsWithCharacters();
        assertEquals("abcdef", solution.replaceDigits("a1c1e1"));
    }

    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        char previousChar = ' ';
        for (int i = 0; i < length; i++) {
            char currentChar = s.charAt(i);
            if (i % 2 == 0) {
                sb.append(currentChar);
                previousChar = currentChar;
            } else {
                sb.append((char) (previousChar + Character.digit(currentChar, 10)));
            }
        }
        return sb.toString();
    }
}
