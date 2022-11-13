package easy;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * 771. Jewels and Stones
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        // Input: jewels = "aA", stones = "aAAbbbb"
        // Output: 3
        var solution = new JewelsAndStones();
        assertEquals(3, solution.numJewelsInStones("aA", "aAAbbbb"));
    }

    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> chatToCountMap = new HashMap<>();
        stones.chars().forEach(it -> chatToCountMap.merge((char) it, 1, Integer::sum));
        int ans = 0;
        for (int i = 0; i < jewels.length(); i++) {
            ans += chatToCountMap.getOrDefault(jewels.charAt(i), 0);
        }
        return ans;
    }

    public int numJewelsInStonesStreams(String jewels, String stones) {
        Map<Integer, Integer> chatToCountMap = new HashMap<>();
        stones.chars().forEach(it -> chatToCountMap.merge(it, 1, Integer::sum));
        return jewels.chars()
                .map(chatToCountMap::get)
                .sum();
    }
}
