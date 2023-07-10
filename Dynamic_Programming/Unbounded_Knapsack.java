package Dynamic_Programming;

public class Unbounded_Knapsack {
    class Solution{
        static int f(int N, int W, int val[], int wt[], int dp[][]){
            if(N==0){
                return (int)(W/wt[N])*val[N];
            }
            if(dp[N][W]!=-1) return dp[N][W];
            
            int notTake = f(N-1,W,val,wt,dp);
            int take = (int)-1e9;
            if(wt[N]<=W) take = val[N]+f(N,W-wt[N],val,wt,dp);
            
            return dp[N][W] = Math.max(take,notTake);
        }
        static int knapSack(int N, int W, int val[], int wt[])
        {
           int[]prev = new int[W+1];
        //   int[]curr = new int[W+1];
           
           for(int w = 0;w<=W;w++){
               prev[w] = (int)(w/wt[0])*val[0];
           }
           
           for(int i = 1; i<N;i++){
               for(int w = 0; w<=W;w++){
                int notTake = prev[w];
                int take = (int)-1e9;
                if(wt[i]<=w) take = val[i]+prev[w-wt[i]];
                
                prev[w] = Math.max(take,notTake);
               }
            //   prev = curr;
           }
           
           return prev[W];
        }
    }
}
