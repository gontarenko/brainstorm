package easy;

import java.util.Arrays;

public class MaximumNumberOfWordsFoundInSentences {
    public static void main(String[] args) {
        String[] input = new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        int output = 6;
        assert new MaximumNumberOfWordsFoundInSentences().mostWordsFound(input) == output;
        assert new MaximumNumberOfWordsFoundInSentences().mostWordsFound2(input) == output;
    }

    public int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for (String sentence : sentences) {
            int length = sentence.split(" ").length;
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    public int mostWordsFound2(String[] sentences) {
        return Arrays.stream(sentences)
                .mapToInt(x -> x.split(" ").length)
                .max()
                .orElse(-1);
    }

}
