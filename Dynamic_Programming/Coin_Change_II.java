package Dynamic_Programming;

public class Coin_Change_II {
    public int f(int i, int T, int []a, int dp[][]){
        if(i==0){
            if(T%a[0]==0) return 1;
            return 0;
        }

        if(dp[i][T]!=-1) return dp[i][T];

        int notTake = f(i-1,T,a,dp);
        int take = 0;
        if(a[i]<=T) take = f(i,T-a[i],a,dp);
        

        return dp[i][T] = take+notTake;
    }
    public int change(int amount, int[] coins) {
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];

        for(int t = 0; t<=amount;t++){
            if(t%coins[0]==0) prev[t] = 1;
            else prev[t] = 0;
        }

        for(int i = 1;i<coins.length;i++){
            for(int t = 0; t<=amount;t++){
               int notTake = prev[t];
               int take = 0;
               if(coins[i]<=t) take = curr[t-coins[i]];

               curr[t] = take+notTake; 
            }
            prev = curr;
        }
        return prev[amount];
        
    }
}
