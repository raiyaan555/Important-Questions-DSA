public class Coin_Change {
    public int f(int i, int T, int[]coins, int[][] dp){
        if(i==0){
            if(T%coins[i]==0){
                return T/coins[i];
            }else{
                return (int)1e9;
            }
        }
        if(dp[i][T]!=-1) return dp[i][T];

        int notTake = 0+f(i-1,T,coins,dp);
        int take = (int)1e9;
        if(coins[i]<=T){
            take = 1+f(i,T-coins[i],coins,dp);
        }

        return dp[i][T] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
         int prev[]=new int[amount+1]; 
         int cur[] =new int[amount+1];

         for(int i=0; i<=amount; i++){
            if(i%coins[0] == 0)  
                prev[i] = i/coins[0];
            else prev[i] = (int)1e9;
        }

        for(int i = 1; i<coins.length;i++){
            for(int T =0;T<=amount;T++){
                 int notTake = 0+prev[T];
                 int take = (int)1e9;
                 if(coins[i]<=T){
                    take = 1+cur[T-coins[i]];
                }
                cur[T] = Math.min(take, notTake);
            }
            prev = cur;
        }
       
        int ans = prev[amount];
        if(ans >=(int)1e9) return -1;
        return ans;
        
    }
}
