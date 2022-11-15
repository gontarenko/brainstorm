package easy;

import static org.junit.Assert.assertEquals;

/**
 * 2413. Smallest Even Multiple
 */
public class SmallestEvenMultiple {
    public static void main(String[] args) {
        // Input: n = 5
        // Output: 10
        // Explanation: The smallest multiple of both 5 and 2 is 10.
        var solution = new SmallestEvenMultiple();
        assertEquals(10, solution.smallestEvenMultiple(5));
        // Input: n = 6
        // Output: 6
        // Explanation: The smallest multiple of both 6 and 2 is 6. Note that a number is a multiple of itself.
        assertEquals(6, solution.smallestEvenMultiple(6));
    }

    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}
