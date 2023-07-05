package Arrays;

import java.util.HashMap;

public class P37_Continous_SubArray_Sum {
    public boolean checkSubarraySum(int[] nums, int k) {
//      If we keep on adding the array and modulo k, if the same value repeats, it means numbers between those 2 indices accounted for being a multiple of k.
        HashMap<Long,Integer> map = new HashMap<>();
        long sum = 0;
        for(int i = 0; i < nums.length ; i++){
            sum += nums[i]%k;
            sum = sum%k;
            if(sum == 0 && i!= 0){
                return true;
            }
//             We need the first occurence. If it is later occurence, we will not put it.
            if(map.containsKey(sum)){
                int j = map.get(sum);
                if(i-j >= 2){
                return true;
                }
            }else{
            map.put(sum,i);
            }
        }
        return false;
    }
}
