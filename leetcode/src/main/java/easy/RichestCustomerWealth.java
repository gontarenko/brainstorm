package easy;

import java.util.Arrays;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = new int[][]{{1, 2, 3}, {3, 2, 1}};
        assert new RichestCustomerWealth().maximumWealth(accounts) == 6;
        assert new RichestCustomerWealth().maximumWealth2(accounts) == 6;
    }

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int tmp = 0;
            for (int i : account) {
                tmp += i;
            }
            if (tmp > max)
                max = tmp;
        }
        return max;
    }

    public int maximumWealth2(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(x -> Arrays.stream(x).sum())
                .max()
                .orElse(0);
    }
}
