package Searching_and_Sorting;

public class Unique_Paths {

    // brute force time complexity is exponential and space also exponential

    public int  paths(int i,int j,int m,int n){
        if(i>=n ||j>=m) return 0;
        if(i==n-1 && j==m-1) return 1;
         return (paths(i+1, j,m,n) + paths(i,j+1,m,n));
    }
    public int uniquePaths(int m, int n) {
        return paths(0,0,m,n);
    }

    // this is the better solution using dynamic programming but we can make it even better the time complexity of this one is O(n*m)  and space complexity is O(n*m);

    public int  paths(int i,int j,int m,int n, int[][] dp){
        if(i>=n ||j>=m) return 0;
        if(i==n-1 && j==m-1) return 1;

        if(dp[i][j]!=-1) return dp[i][j];
         else return dp[i][j] = (paths(i+1, j,m,n,dp) + paths(i,j+1,m,n,dp));
    }
    public int uniquePaths2(int m, int n) {

        int[][] dp = new int[n][m];
        for(int i=0; i<n;i++){
        for(int j =0; j<m;j++){
            dp[i][j] = -1;
        }
    }
        return paths(0,0,m,n,dp);
    }

    /*
    this is the third and best solution this uses combination principles i.e is n+m-2 C n-1 or n+m-2 C m-1 
    will give you the answer also time complexity is linear and space also linear; the double is necessary for the right answer
    */ 
    public int uniquePaths3(int m, int n) {

        int N = m+n-2;
        int r = m-1;
        double ans = 1;

        for(int i =1; i<=r;i++){
            ans = ans *(N-r+i)/i;
        }
        return (int)ans;
    }
}
