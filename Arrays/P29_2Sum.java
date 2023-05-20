package Arrays;

import java.util.HashMap;

public class P29_2Sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] a = new int[2];

        for(int i = 0; i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(target-nums[i], i);
            }else{
                a[0] = map.get(nums[i]);
                a[1] = i;
            }
        }
        return a;
    }
}
