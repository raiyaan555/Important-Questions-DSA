package Arrays;

public class P51_Monotonic_Array {
    class Solution {
        public boolean isMonotonic(int[] nums) {
            int c1=1,c2=1;
            for(int i=0;i<nums.length-1;i++){
                if(nums[i]>=nums[i+1])
                c1++;
                if(nums[i]<=nums[i+1])
                c2++;
            }
            
    
            if(c1==nums.length||c2==nums.length){
                return true;
            }
            return false;
        }
    }
}
