package Backtracking;
import java.util.*;

public class Combinational_Sum {

    public void findAnswer(int i, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){


        if(i == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[i]<=target){
            ds.add(arr[i]);
            findAnswer(i, arr, target-arr[i], ans, ds);
            ds.remove(ds.size()-1);
        }
        findAnswer(i+1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findAnswer(0, candidates, target, ans, new ArrayList<>());
        return ans;

    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 8}; int x = 8;
        Combinational_Sum s = new Combinational_Sum();
        System.out.println(s.combinationSum(arr,x));
    }
}
