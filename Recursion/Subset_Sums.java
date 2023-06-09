package Recursion;

import java.util.ArrayList;

public class Subset_Sums {
    void getSubsetSum(int index, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> ans) {

        if (index == N) {
            ans.add(sum);
            return;
        }

        getSubsetSum(index + 1, sum + arr.get(index), arr, N, ans);
        getSubsetSum(index + 1, sum, arr, N, ans);

    }

    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        // code here

        ArrayList<Integer> ans = new ArrayList<>();
        getSubsetSum(0, 0, arr, N, ans);
        return ans;

    }
}
