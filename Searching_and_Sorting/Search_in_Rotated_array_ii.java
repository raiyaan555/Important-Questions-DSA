package Searching_and_Sorting;

public class Search_in_Rotated_array_ii {
    class Solution {

        // better approach

        public boolean search2(int[] nums, int target) {
            // if(nums.length==1){
            // if (target==nums[0]) return true; else return false;
            // }

            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return true;
                }

                // lets assume the right side is sorted and left side is not sorted
                if (nums[mid] < nums[left] || nums[mid] < nums[right]) {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else
                        right = mid - 1;
                }

                // lets assume the left side is sorted and the right side is not sorted

                else if (nums[mid] > nums[left] || nums[mid] > nums[right]) {
                    if (target < nums[mid] && target >= nums[left]) {
                        right = mid - 1;
                    } else
                        left = mid + 1;
                }
                // If we get here, that means nums[left] == nums[mid] == nums[right], then
                // shifting out
                // any of the two sides won't change the result but can help remove duplicate
                // from
                // consideration, here we just use right-- but left++ works too
                else {
                    right--;
                }
            }
            return false;
        }
        

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
