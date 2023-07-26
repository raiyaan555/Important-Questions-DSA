package Dynamic_Programming;

import java.util.Arrays;

public class Buy_Sell_Stocks_III {
    class Solution {
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];

            for (int[] i : dp) {
                Arrays.fill(i, -1);
            }

            return f(0, 0, prices, dp);
        }

        int f(int i, int buy, int[] prices, int[][] dp) {
            if (i == prices.length)
                return 0;

            if (dp[i][buy] != -1)
                return dp[i][buy];
            int profit = 0;

            // we can buy the stock
            if (buy == 0) {
                profit = Math.max(-prices[i] + f(i + 1, 1, prices, dp), 0 + f(i + 1, 0, prices, dp));
            } else if (buy == 1) {
                // we can sell the stock
                profit = Math.max(prices[i] + f(i + 1, 0, prices, dp), 0 + f(i + 1, 1, prices, dp));
            }
            return dp[i][buy] = profit;
        }
    }
}
