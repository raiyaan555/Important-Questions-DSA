package Dynamic_Programming;

import java.util.ArrayList;
import java.util.Arrays;

public class Maximum_sum_of_non_adjacent_elements {
    public class Solution {

        // memo

	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int dp[] = new int[nums.size()+1];

		Arrays.fill(dp,-1);

		return helper(nums, dp, nums.size()-1);
	}



	static int helper(ArrayList<Integer> nums, int[] dp, int n){
		if(n==0) return nums.get(n);
		if(n<0) return 0;

		if(dp[n]!=-1) return dp[n];
		
		int pick = nums.get(n)+helper(nums, dp,n-2);
		int notPick = 0+helper(nums, dp,n-1);

		return dp[n] = Math.max(pick,notPick);


		
	}

    
// tabulation

static int solveUtil(int n, int[] arr, int[] dp){
dp[0]= arr[0];

for(int i=1 ;i<n; i++){
    int pick = arr[i];
    if(i>1)
        pick += dp[i-2];
    int nonPick = 0+ dp[i-1];

    dp[i]= Math.max(pick, nonPick);
}


return dp[n-1];

}

static int solve(int n, int[] arr){
int dp[]=new int[n];
Arrays.fill(dp,-1);
return solveUtil(n, arr, dp);
}




public static void main(String args[]) {

int arr[]={2,1,4,9};
int n=arr.length;
System.out.println(solve(n,arr));
}
}

// optimal

static int solve(int n, int[] arr){

   int prev = arr[0];
    int prev2 =0;

    for(int i=1; i<n; i++){
        int pick = arr[i];
        if(i>1)
            pick += prev2;
        int nonPick = 0 + prev;

        int cur_i = Math.max(pick, nonPick);
        prev2 = prev;
        prev= cur_i;

    }
    return prev;
}
}


