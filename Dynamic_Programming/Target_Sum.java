package Dynamic_Programming;

import java.util.Arrays;

public class Target_Sum {
    class Solution {
    public int f(int i, int T, int[] nums , int[][]dp){
        if(i==0){
            if(T==0 && nums[0]==0)
            return 2;
        if(T==0 || T== nums[0])
            return 1;
        return 0;
        }

        if(dp[i][T]!=-1) return dp[i][T];

        int notTake = f(i-1,T,nums,dp);
        int take = 0;
        if(nums[i]<=T){
            take = f(i-1,T-nums[i],nums,dp);
        }

        return dp[i][T] = (take+notTake);
    }
    public int findTargetSumWays(int[] nums, int target) {
       

         int totSum = 0;

         for(int i=0; i<nums.length;i++){
            totSum += nums[i];
         }

          if(totSum-target<0) return 0;
          if((totSum-target)%2==1) return 0;

          int s2 = (totSum-target)/2;
    
          int dp[][]=new int[nums.length][s2+1];
          for(int row[]: dp)
          Arrays.fill(row,-1);

        return f(nums.length-1, s2, nums, dp);

    }
}
}
