package Dynamic_Programming;

import java.util.Arrays;

public class Climbing_Steps {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
       return helperFunc(n,dp);
    }
    int helperFunc(int n, int[] dp){
        if(n==0) return 1;
        if(n==1) return 1;

        if(dp[n]!=-1) return dp[n];

        return dp[n] = helperFunc(n-1,dp)+helperFunc(n-2,dp);
    }
}
