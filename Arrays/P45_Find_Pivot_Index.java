package Arrays;

public class P45_Find_Pivot_Index {
    class Solution {
        public int pivotIndex(int[] nums) {
            int[] prefixSum = new int[nums.length+1];
            prefixSum[0] = 0;
    
            for(int i = 1; i<=nums.length;i++){
                prefixSum[i] = prefixSum[i-1]+nums[i-1];        
            }
            for(int i = 0; i<=nums.length;i++){
                System.out.print(prefixSum[i]+" ");        
            }
    
            int sum = prefixSum[nums.length];
            for(int i =0;i<nums.length;i++){
                sum -= nums[i];
                if(sum==prefixSum[i]) return i;
            }
    
            return -1;
        }
    }
}
