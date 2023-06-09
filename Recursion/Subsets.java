package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        getSubsets(0, nums, new ArrayList(), ans);

        return ans;
    }

    void getSubsets(int index, int[] nums, List<Integer> temp, List<List<Integer>> ans) {

        ans.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            getSubsets(i + 1, nums, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}
