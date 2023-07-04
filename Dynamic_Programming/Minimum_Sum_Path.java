package Dynamic_Programming;

public class Minimum_Sum_Path {
    public int minPathSum(int[][] matrix) {
        int n = matrix.length;
  int m = matrix[0].length;
         int prev[] = new int[m];
    for(int i=0; i<n ; i++){
        int temp[] = new int[m];
        for(int j=0; j<m; j++){
            if(i==0 && j==0) temp[j] = matrix[i][j];
            else{
                
                int up = matrix[i][j];
                if(i>0) up += prev[j];
                else up += (int)Math.pow(10,9);
                
                int left = matrix[i][j];
                if(j>0) left+=temp[j-1];
                else left += (int)Math.pow(10,9);
                
                temp[j] = Math.min(up,left);
            }
        }
        prev=temp;
    }
    
    return prev[m-1];
    }

    int helper(int i, int j,  int[][] grid,  int[][] dp){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return (int)1e9;

        if(dp[i][j]!=-1) return dp[i][j];


        int up  = grid[i][j]+helper(i-1, j, grid, dp);
        int left = grid[i][j]+helper(i, j-1, grid, dp);

        return dp[i][j] = Math.min(up,left);
    }
}
