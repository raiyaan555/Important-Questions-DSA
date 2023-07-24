package Dynamic_Programming;

public class Buy_Sell_Stocks_I {
    class Solution {
        public static int maxProfit(int[] arr) {
       
             int min = Integer.MAX_VALUE;
             int sell = 0, profit = 0;
             for(int i: arr){
                 min = Math.min(min,i);
                 sell = i-min;
                 profit = Math.max(sell,profit);
             }
             return profit;
           }
       }
}
