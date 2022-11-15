package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * 2325. Decode the Message
 */
public class DecodeTheMessage {
    public static void main(String[] args) {
        // Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
        // Output: "this is a secret"
        // Explanation: The diagram above shows the substitution table.
        // It is obtained by taking the first appearance of each letter in "the quick brown fox jumps over the lazy dog".
        var solution = new DecodeTheMessage();
        assertEquals("this is a secret", solution.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }

    public String decodeMessage(String key, String message) {
        Map<Character, Character> decoder = new HashMap<>();
        AtomicInteger alphabetIndex = new AtomicInteger(0);
        key.chars()
                .distinct()
                .filter(it -> it != ' ')
                .forEach(c -> decoder.put((char) c, (char) ('a' + alphabetIndex.getAndIncrement())));
        StringBuilder decodedMessage = new StringBuilder();
        int length = message.length();
        for (int i = 0; i < length; i++) {
            decodedMessage.append(decoder.getOrDefault(message.charAt(i), ' '));
        }
        return decodedMessage.toString();
    }
}
