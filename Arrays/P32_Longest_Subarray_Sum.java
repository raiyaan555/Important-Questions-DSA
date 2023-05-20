package Arrays;

import java.util.HashMap;

// this runs for all the above cases - + or 0

public class P32_Longest_Subarray_Sum {
    int maxLen(int arr[], int N)
    {
        HashMap<Integer, Integer> hm=new HashMap<>();
        int sum=0;
        int res=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(!hm.containsKey(sum)){
                hm.put(sum,i);
            }
            else res=Math.max(res, i-hm.get(sum));
            if(sum==0) res=Math.max(sum, i+1);
        }
        return res;
    }
}
