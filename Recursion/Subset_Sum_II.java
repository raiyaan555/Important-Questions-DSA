package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_Sum_II {
    class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        f(0,nums,ans,temp,true);
        return ans;
    }
    public static void f(int i,int arr[], List<List<Integer>> ans,List<Integer> temp, boolean isPick){
        if(i==arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        f(i+1,arr,ans,temp,false);
        if (i >= 1 && arr[i - 1] == arr[i] && isPick == false) {
            return;
        }
        temp.add(arr[i]);
        f(i+1,arr,ans,temp,true);
        temp.remove(temp.size()-1);
        
        
        
        
}
}
}
