package easy;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BuildArrayFromPermutation {
    public static void main(String[] args) {
        assert Arrays.equals(
                new BuildArrayFromPermutation().buildArray(new int[]{0, 2, 1, 5, 3, 4}),
                new int[]{0, 1, 2, 4, 5, 3}
        );
        assert Arrays.equals(
                new BuildArrayFromPermutation().streamSolution(new int[]{0, 2, 1, 5, 3, 4}),
                new int[]{0, 1, 2, 4, 5, 3}
        );
    }

    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    public int[] streamSolution(int[] nums) {
        AtomicInteger i = new AtomicInteger();
        return IntStream.generate(() -> nums[nums[i.getAndIncrement()]])
                .limit(nums.length)
                .toArray();
    }
}
