package kyu8;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MultipleOfIndex {
    public static void main(String[] args) {
        assert Arrays.equals(
                new int[]{-6, 32, 25},
                multipleOfIndex(new int[]{22, -6, 32, 82, 9, 25})
        );
    }

    public static int[] multipleOfIndex(int[] array) {
        AtomicInteger i = new AtomicInteger(1);
        return Arrays.stream(array)
                .skip(1)
                .filter(x -> x % i.getAndIncrement() == 0)
                .toArray();
    }
}
