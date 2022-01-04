package easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ConcatenationOfArray {
    public static void main(String[] args) {
        assert Arrays.equals(
                new ConcatenationOfArray().getConcatenation(new int[]{1, 2, 1}),
                new int[]{1, 2, 1, 1, 2, 1}
        );
        assert Arrays.equals(
                new ConcatenationOfArray().getConcatenation2(new int[]{1, 2, 1}),
                new int[]{1, 2, 1, 1, 2, 1}
        );
    }

    public int[] getConcatenation(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length * 2];
        for (int i = 0; i < length; i++) {
            ans[i] = nums[i];
            ans[i + length] = nums[i];
        }
        return ans;
    }

    public int[] getConcatenation2(int[] nums) {
        return IntStream.concat(IntStream.of(nums), IntStream.of(nums)).toArray();
    }
}
