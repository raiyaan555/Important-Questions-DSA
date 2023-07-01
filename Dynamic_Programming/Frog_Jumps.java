package Dynamic_Programming;

import java.util.Arrays;

public class Frog_Jumps {

    // memoization

static int solve(int ind,int[] height,int[] dp){
    if(ind==0) return 0;
    if(dp[ind]!=-1) return dp[ind];
    int jumpTwo = Integer.MAX_VALUE;
    int jumpOne= solve(ind-1, height,dp)+ Math.abs(height[ind]-height[ind-1]);
    if(ind>1)
        jumpTwo = solve(ind-2, height,dp)+ Math.abs(height[ind]-height[ind-2]);
    
    return dp[ind]=Math.min(jumpOne, jumpTwo);
}

// tabulation


static int solve2(int ind, int[] height, int[] dp){
    dp[0] = 0;
   

    for(int i = 1; i<=ind; i++){
        int jumpOne = dp[i-1] + Math.abs(height[ind]-height[ind-1]);
         int jumpTwo = Integer.MAX_VALUE;
        if(i>1) {
            jumpTwo = dp[i-2] + Math.abs(height[ind]-height[ind-2]);
        }

        dp[i] = Math.min(jumpOne, jumpTwo);
    }
    return dp[ind];
}


// space optimization

static int solve3(int ind, int[] height){
    int prev2 = 0;
    int prev  =0;
    
    for(int i = 1; i<=ind; i++){
        int jumpOne = prev + Math.abs(height[ind]-height[ind-1]);
         int jumpTwo = Integer.MAX_VALUE;
        if(i>1) {
            jumpTwo = prev2 + Math.abs(height[ind]-height[ind-2]);
        }

       int curr = Math.min(jumpOne, jumpTwo);
       prev2 = prev;
       prev  =curr;
    }
    return prev;
}

public static void main(String args[]) {

  int height[]={30,10,60 , 10 , 60 , 50};
  int n=height.length;
  int dp[]=new int[n];
  Arrays.fill(dp,-1);
  System.out.println(solve3(n-1,height));
}
}

