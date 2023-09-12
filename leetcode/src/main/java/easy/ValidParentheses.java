package easy;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 20. Valid Parentheses
 */
public class ValidParentheses {
    public static void main(String[] args) {
        // Example 1:
        // Input: s = "()"
        // Output: true
        assertTrue(isValid("()"));
        // Example 2:
        // Input: s = "()[]{}"
        // Output: true
        assertTrue(isValid("()[]{}"));

        // Example 3:
        // Input: s = "(]"
        // Output: false
        assertFalse(isValid("(]"));
    }

    // O(n)
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pollLast() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pollLast() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pollLast() != '{') {
                    return false;
                }
            } else {
                stack.addLast(c);
            }
        }
        return stack.isEmpty();
    }
}
