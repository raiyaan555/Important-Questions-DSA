package Arrays;

public class P39_Peak_Index_Mountain_Range {
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int lo = 0;
            int hi = arr.length - 1;
            int mid;
            while (lo < hi) {
                mid = (hi + lo) / 2;
                if (arr[mid] < arr[mid + 1]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }
    }
}
