package Arrays;

import java.util.HashSet;

public class P31_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0) return 0;
  
         HashSet <Integer> set = new HashSet<>();
         int cnt = 0, ans = 0;
  
         for(int i: nums){
             set.add(i);
         }
  
         for(int i: nums){
             if(!set.contains(i-1)){
                 int c = i;
                 cnt = 1; 
                 while(set.contains(c+1)){
                     c +=1;
                     cnt +=1;
                 }
  
                 ans = Math.max(cnt,ans);
             }
            
         }
         return ans;
      }
}
