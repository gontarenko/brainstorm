package easy;

public class Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfitDummy(int[] prices) {
         int maxProfit = 0;
        for (int buyIndex = 0; buyIndex < prices.length - 1; buyIndex++) {
            for (int sellIndex = buyIndex + 1; sellIndex < prices.length; sellIndex++) {
                int profit = prices[sellIndex] - prices[buyIndex];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price < buy) {
                buy = price;
            } else if (price - buy > maxProfit) {
                maxProfit = price - buy;
            }
        }

        return maxProfit;
    }
}
