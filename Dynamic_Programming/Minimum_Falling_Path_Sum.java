package Dynamic_Programming;

public class Minimum_Falling_Path_Sum {
    public int minFallingPathSum(int[][] matrix) {
      int n = matrix.length;
    int m = matrix[0].length;
    
    int prev[] = new int[m];
    int curr[] = new int[m];
    
    // Initializing first row - base condition
    for(int j=0; j<m; j++){
        prev[j] = matrix[0][j];
    }
    
    for(int i=1; i<n; i++){
        for(int j=0;j<m;j++){
            
            int up = matrix[i][j] + prev[j];
            
            int leftDiagonal= matrix[i][j];
            if(j-1>=0) leftDiagonal += prev[j-1];
            else leftDiagonal += (int)Math.pow(10,9);
            
            int rightDiagonal = matrix[i][j];
            if(j+1<m) rightDiagonal += prev[j+1];
            else rightDiagonal += (int)Math.pow(10,9);
            
            curr[j] = Math.min(up, Math.min(leftDiagonal,rightDiagonal));
            
        }
        prev = curr;
    }
    
    int maxi = Integer.MAX_VALUE;
    
    for(int j=0; j<m;j++){
        maxi = Math.min(maxi,prev[j]);
    }
    
    return maxi;

    }

    int getMaxUtil(int i, int j, int m, int[][] matrix,int[][] dp){
        

        if(j<0 || j>=m)
        return (int)Math.pow(10,9);
    if(i==0)
        return matrix[0][j];
    
    if(dp[i][j]!=-1) return dp[i][j];
    
    int up = matrix[i][j] + getMaxUtil(i-1,j,m,matrix,dp);
    int leftDiagonal = matrix[i][j] + getMaxUtil(i-1,j-1,m,matrix,dp);
    int rightDiagonal = matrix[i][j] + getMaxUtil(i-1,j+1,m,matrix,dp);
    
    return dp[i][j]= Math.min(up,Math.min(leftDiagonal,rightDiagonal));
    



    }
}
