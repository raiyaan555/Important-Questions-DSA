package Arrays;

import java.util.HashMap;

public class P38_Longest_Arithmetic_Subsequence_of_Given_Difference {
    public int longestSubsequence(int[] arr, int diff) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans =1;
        for(int i: arr){
           int preValue = map.getOrDefault(i-diff,0);
           map.put(i,preValue+1);
           ans = Math.max(ans,preValue+1);
        }
        return ans;
        
    }
}
