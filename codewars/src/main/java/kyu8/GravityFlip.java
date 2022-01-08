package kyu8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class GravityFlip {
    public static void main(String[] args) {
        assert Arrays.equals(
                new int[]{1, 2, 2, 3},
                GravityFlip.flip('R', new int[]{3, 2, 1, 2})
        );
        assert Arrays.equals(
                new int[]{5, 5, 4, 3, 1},
                GravityFlip.flip('L', new int[]{1, 4, 5, 3, 5})
        );
    }

    public static int[] flip(char dir, int[] arr) {
        return IntStream.of(arr)
                .boxed()
                .sorted(dir == 'R' ? Comparator.naturalOrder() : Comparator.reverseOrder())
                .mapToInt(x -> x)
                .toArray();
    }
}
