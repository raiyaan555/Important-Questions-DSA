package Dynamic_Programming;

import java.util.Arrays;

public class Buy_Sell_Stocks_II {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n + 1][2];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        // base condition
        dp[n][0] = dp[n][1] = 0;

        int profit = 0;

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {

                if (buy == 0) {// We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -arr[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) {// We can sell the stock
                    profit = Math.max(0 + dp[ind + 1][1], arr[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
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
