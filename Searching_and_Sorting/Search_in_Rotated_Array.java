package Searching_and_Sorting;

public class Search_in_Rotated_Array {
    class Solution {
        public int search(int[] arr, int target) {
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] == target)
                    return mid;
                if (arr[start] <= arr[mid]) {
                    if (target < arr[mid] && target >= arr[start]) {
                        end = mid - 1;
                    } else
                        start = mid + 1;
                } else {
                    if (target > arr[mid] && target <= arr[end]) {
                        start = mid + 1;
                    } else
                        end = mid - 1;
                }
            }
            return -1;
        }
    }
}
