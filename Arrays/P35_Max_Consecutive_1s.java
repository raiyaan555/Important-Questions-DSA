package Arrays;

import java.util.HashMap;

public class P35_Max_Consecutive_1s {
    public int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int ans = 0;

        for(int i:nums){
            if(i==1){
                max +=1;
               
            }else{
                max = 0;
            }
             ans = Math.max(max,ans);

        }
        return ans;

        
        
    }
}