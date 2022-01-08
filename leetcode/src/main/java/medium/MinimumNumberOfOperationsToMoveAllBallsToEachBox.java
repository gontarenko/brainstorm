package medium;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public static void main(String[] args) {
        assert Arrays.equals(
                new Solution().minOperations("110"),
                new int[]{1, 1, 3}
        );
        assert Arrays.equals(
                new Solution().minOperations2("110"),
                new int[]{1, 1, 3}
        );
    }

    static class Solution {
        public int[] minOperations(String boxes) {
            char[] boxesArr = boxes.toCharArray();
            int[] ans = new int[boxesArr.length];
            for (int i = 0; i < boxesArr.length; i++) {
                int minOp = 0;
                for (int j = 0; j < boxesArr.length; j++) {
                    if (i == j)
                        continue;
                    if (boxesArr[j] == '1')
                        minOp += Math.abs(i - j);
                }
                ans[i] = minOp;
            }
            return ans;
        }

        public int[] minOperations2(String boxes) {
            char[] boxesArr = boxes.toCharArray();
            return IntStream.range(0, boxesArr.length)
                    .parallel()
                    .map(x -> {
                        int minOp = 0;
                        for (int j = 0; j < boxesArr.length; j++) {
                            if (x == j)
                                continue;
                            if (boxesArr[j] == '1')
                                minOp += Math.abs(x - j);
                        }
                        return minOp;
                    }).toArray();
        }
    }
}
