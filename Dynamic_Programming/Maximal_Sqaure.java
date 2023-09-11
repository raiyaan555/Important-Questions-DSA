package Dynamic_Programming;

import java.util.Arrays;

public class Maximal_Sqaure {
    class Solution {
    public int maximalSquare(char[][] matrix) {
      

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int max = helper(i,j,matrix,dp);
                ans = Math.max(ans,max);
            }
        }
        return ans*ans;
    }

    public int helper(int i, int j, char matrix[][], int [][]dp){
        if(i>=matrix.length || j>=matrix[0].length || matrix[i][j]=='0'){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j] = 1+ Math.min(helper(i+1,j+1,matrix,dp),
        Math.min(helper(i+1,j,matrix,dp), helper(i,j+1,matrix,dp)));
    }
}
}
