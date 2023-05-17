package Arrays;
import java.util.*;

class P27_Repeat_and_Missing_Number_Array{
    public static int findDuplicate(int[] nums){
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
    
    public static int findMissing(int[] A){
        

        int sum = 0, actualSum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i =0; i<A.length;i++){
            if(A[i]>=max){
                max = A[i];
            }
            if(A[i]<=min){
                min = A[i];
            }
        }
        for(int i = min; i<=max;i++){
            sum += i;
        }
        
        for(int i = 0; i<A.length;i++){
            actualSum +=A[i];
        }
        int a = findDuplicate(A);
        return Math.abs(sum-(Math.abs(actualSum-a)));
    }
    
    public int[] repeatedNumber(final int[] A) {
        
        int[] ans = new int[2];
        
        ans[0] = findDuplicate(A);
        ans[1] = findMissing(A);
        
        return ans;
    }
}