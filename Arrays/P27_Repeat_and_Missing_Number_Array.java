package Arrays;
import java.util.*;

class P27_Repeat_and_Missing_Number_Array{
    // optimal solution is in the order of 
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int[] repeatedNumber(final int[] A) {
            int[]ans = new int[2];
            long n = A.length;
            
            long Sn = ((n)*(n+1))/2;
            long S2n = (n*(n+1)*(2*n+1))/6;
            
            long S =0, S2 = 0;
            
            for(int i: A){
                S += i;
                S2 += (long)i*(long)i;
            } 
            
            long val1 = S-Sn;
            long val2 = S2-S2n;
            val2 = val2/val1;
            long x = (val1+val2)/2;
            long y = val1-x;
            
            ans[0] = (int)x;
            ans[1] = (int)y;
            return ans;
            
        }
    }
    
}