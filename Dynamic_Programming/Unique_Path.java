package Dynamic_Programming;

import java.util.Arrays;

public class Unique_Path {


    // Memoization

    public int paths(int i, int j, int m, int n, int[][] dp) {
        if (i >= n || j >= m)
            return 0;
        if (i == n - 1 && j == m - 1)
            return 1;

        if (dp[i][j] != -1)
            return dp[i][j];
        else
            return dp[i][j] = (paths(i + 1, j, m, n, dp) + paths(i, j + 1, m, n, dp));
    }

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return paths(0, 0, m, n, dp);
    }



    // Tabulation

    
static int countWaysUtil2(int m, int n, int[][] dp) {
 
 for(int i=0; i<m ;i++){
      for(int j=0; j<n; j++){
          
          //base condition
          if(i==0 && j==0){
              dp[i][j]=1;
              continue;
          }
          
          int up=0;
          int left = 0;
          
          if(i>0) 
            up = dp[i-1][j];
          if(j>0)
            left = dp[i][j-1];
            
          dp[i][j] = up+left;
      }
  }
  
  return dp[m-1][n-1];

}

static int countWays2(int m, int n){
    int dp[][]=new int[m][n];
    for (int[] row : dp)
        Arrays.fill(row, -1);
    return countWaysUtil2(m,n,dp);
    
}


public static void main(String args[]) {

  int m=3;
  int n=2;
  
  System.out.println(countWays2(m,n));
}

    // Optimal
    
    public int uniquePaths3(int m, int n) {
    int prev[]=new int[n];
    for(int i=0; i<m; i++){
        int temp[]=new int[n];
        for(int j=0; j<n; j++){
            if(i==0 && j==0){
                temp[j]=1;
                continue;
            }
            
            int up=0;
            int left =0;
            
            if(i>0)
                up = prev[j];
            if(j>0)
                left = temp[j-1];
                
            temp[j] = up + left;
        }
        prev = temp;
    }
    
    return prev[n-1];
    }
}

