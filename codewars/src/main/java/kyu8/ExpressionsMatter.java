package kyu8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ExpressionsMatter {
    public static void main(String[] args) {
        assert 6 == expressionsMatter(2, 1, 2);
    }

    private static final List<Function<Integer[], Integer>> functions = new ArrayList<>() {{
        add(ExpressionsMatter::firstFunc);
        add(ExpressionsMatter::secondFunc);
        add(ExpressionsMatter::thirdFunc);
        add(ExpressionsMatter::fourthFunc);
    }};

    public static int expressionsMatter(int a, int b, int c) {
        Integer[] arr = new Integer[]{a, b, c};
        return functions.stream().mapToInt(f -> f.apply(arr))
                .max()
                .orElse(-1);
    }

    private static int firstFunc(Integer[] arr) {
        return arr[0] + arr[1] + arr[2];
    }

    private static int secondFunc(Integer[] arr) {
        return arr[0] * arr[1] * arr[2];
    }

    private static int thirdFunc(Integer[] arr) {
        return (arr[0] + arr[1]) * arr[2];
    }

    private static int fourthFunc(Integer[] arr) {
        return arr[0] * (arr[1] + arr[2]);
    }
}
