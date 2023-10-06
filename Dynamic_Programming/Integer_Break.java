package Dynamic_Programming;

import java.util.Arrays;

public class Integer_Break {
    class Solution {
    public int integerBreak(int n) {
        int dp[][] =  new int[n+1][n];
        for(int[] i:dp)
        Arrays.fill(i,-1);
        return helper(n,n-1,dp);
    }

    public int helper(int n, int i,int dp[][]){
        if(n == 0 || i == 0) return 1;
        if(dp[n][i] != -1) return dp[n][i];
        if(i>n)return dp[n][i] = helper(n,i-1,dp);
        return dp[n][i] = Math.max((i * helper(n - i, i,dp)), helper(n , i - 1,dp));
    }
}
}
