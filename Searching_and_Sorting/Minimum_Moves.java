package Searching_and_Sorting;

import java.util.*;

public class Minimum_Moves {
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        // int sum;
        int ans = 0;

        // if(nums.length%2==0){

        // sum = (nums[nums.length/2]+nums[(nums.length/2) +1])/2;

        // }else{
        // sum = nums[nums.length/2];
        // }

        while (start < end) {

            ans += nums[end] - nums[start];

            end--;
            start++;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 6};

        System.out.println(minMoves2(nums));
    }
}
