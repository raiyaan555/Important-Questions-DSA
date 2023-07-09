package Dynamic_Programming;

public class O_1_Knapsack_Problem {
    static int findValue(int i, int W, int[] wt,  int[] val, int[][] dp){
        if(i==0){
            if(wt[i]<=W) return val[i];
            else return 0;
        }

        if(dp[i][W]!=-1) return dp[i][W];

        int notTake = 0+findValue(i-1,W,wt,val,dp);
        int take = (int)-1e9;

        if(wt[i]<=W) take = val[i]+findValue(i-1,W-wt[i],wt,val,dp);

        return dp[i][W] = Math.max(take,notTake);
    }
    static int knapsack(int[] wt, int[] val, int n, int W) {
int prev[]=new int[W+1];
    
    //Base Condition
    
    for(int i=wt[0]; i<=W; i++){
        prev[i] = val[0];
    }
    
    for(int ind =1; ind<n; ind++){
        for(int cap=W; cap>=0; cap--){
            
            int notTaken = 0 + prev[cap];
            
            int taken = Integer.MIN_VALUE;
            if(wt[ind] <= cap)
                taken = val[ind] + prev[cap - wt[ind]];
                
            prev[cap] = Math.max(notTaken, taken);
        }
    }
    
    return prev[W];
    }
}
