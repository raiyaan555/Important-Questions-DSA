package Searching_and_Sorting;

import java.util.Arrays;

public class Min_Max_Difference_Pairs {
    class Solution {
        public boolean isValid(int mid, int[] nums, int p) {
            int i = 0;
            int counter = 0;

            while (i < nums.length - 1) {
                if (Math.abs(nums[i] - nums[i + 1]) <= mid) {
                    counter++;
                    i += 2;
                } else {
                    i += 1;
                }
                if (p == counter)
                    return true;
            }
            return false;
        }

        public int minimizeMax(int[] nums, int p) {
            if (p == 0)
                return 0;
            Arrays.sort(nums);

            int left = 0;
            int right = (int) 1e9;
            int ans = Integer.MAX_VALUE;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (isValid(mid, nums, p)) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }
}
