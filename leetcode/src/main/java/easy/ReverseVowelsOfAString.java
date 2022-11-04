package easy;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * 345. Reverse Vowels of a String
 */
public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        var solution = new ReverseVowelsOfAString();
        assertEquals("holle", solution.reverseVowels("hello"));
        assertEquals("leotcede", solution.reverseVowels("leetcode"));
        assertEquals("holle", solution.reverseVowels2("hello"));
        assertEquals("leotcede", solution.reverseVowels2("leetcode"));
        assertEquals("holle", solution.reverseVowels3("hello"));
        assertEquals("leotcede", solution.reverseVowels3("leetcode"));
    }

    private static final Set<Character> vowels = Set.of(
            'a',
            'e',
            'i',
            'o',
            'u',
            'A',
            'E',
            'I',
            'O',
            'U'
    );

    public String reverseVowels(String s) {
        StringBuilder answer = new StringBuilder(s);
        StringBuilder vowelsFromString = new StringBuilder();
        int length = answer.length() - 1;
        for (int i = length; i >= 0; i--) {
            char c = answer.charAt(i);
            if (vowels.contains(c)) {
                vowelsFromString.append(c);
            }
        }
        int counter = 0;
        for (int i = 0; i <= length; i++) {
            if (vowels.contains(answer.charAt(i))) {
                answer.setCharAt(i, vowelsFromString.charAt(counter++));
            }
        }
        return answer.toString();
    }

    /**
     * 2 pointers solution
     */
    public String reverseVowels2(String s) {
        StringBuilder answer = new StringBuilder(s);

        for (int p1 = 0, p2 = s.length() - 1; ; ) {
            if (p1 == p2 || p1 > p2)
                break;

            char charLeft = answer.charAt(p1);
            char charRight = answer.charAt(p2);
            boolean isLeftVowel = vowels.contains(charLeft);
            boolean isRightVowel = vowels.contains(charRight);

            if (isLeftVowel && isRightVowel) {
                answer.setCharAt(p1, charRight);
                answer.setCharAt(p2, charLeft);
                p1++;
                p2--;
            } else if (isLeftVowel) {
                while (!vowels.contains(charRight)) {
                    p2--;
                    charRight = answer.charAt(p2);
                }
                if (p2 == p1) {
                    break;
                }
                answer.setCharAt(p1, charRight);
                answer.setCharAt(p2, charLeft);
                p1++;
                p2--;
            } else if (isRightVowel) {
                while (!vowels.contains(charLeft)) {
                    p1++;
                    charLeft = answer.charAt(p1);
                }
                if (p2 == p1) {
                    break;
                }
                answer.setCharAt(p1, charRight);
                answer.setCharAt(p2, charLeft);
                p1++;
                p2--;
            } else {
                p1++;
                p2--;
            }
        }

        return answer.toString();
    }

    /**
     * stack solution
     */
    public String reverseVowels3(String s) {
        StringBuilder sb = new StringBuilder(s);
        Deque<Character> stack = new ArrayDeque<>();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (vowels.contains(c)) {
                stack.addLast(c);
                indexes.add(i);
            }
        }
        if (stack.size() > 1) {
            for (Integer index : indexes) {
                sb.setCharAt(index, stack.pollLast());
            }
        }
        return sb.toString();
    }

}
