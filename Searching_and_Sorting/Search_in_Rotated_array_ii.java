package Searching_and_Sorting;

public class Search_in_Rotated_array_ii {
    class Solution {
        public boolean binarySearch(int lowerLimit, int upperLimit, int[] arr, int target) {
            while (lowerLimit <= upperLimit) {
                int mid = lowerLimit + (upperLimit - lowerLimit) / 2;
                if (arr[mid] == target) {
                    return true;
                } else if (arr[mid] > target) {
                    upperLimit = mid - 1;
                } else {
                    lowerLimit = mid + 1;
                }
            }
            return false;
        }

        public boolean search(int[] nums, int target) {
            int pivot = 0;

            for (int i = 0; i < nums.length; i++) {
                if (i != 0) {
                    if (nums[i - 1] > nums[i]) {
                        pivot = i;
                        break;
                    }
                }
            }
            if (nums[pivot] == target)
                return true;
            int left = 0;
            int right = nums.length - 1;
            if (pivot == 0)
                return binarySearch(left, right, nums, target);
            else
                return binarySearch(left, pivot - 1, nums, target) || binarySearch(pivot + 1, right, nums, target);
        }
    }
}
