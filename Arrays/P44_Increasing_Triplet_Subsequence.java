package Arrays;

public class P44_Increasing_Triplet_Subsequence {
    class Solution {
        public boolean increasingTriplet(int[] nums) {

            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < min) {
                    min = nums[i];
                }
                if (nums[i] < secondMin && nums[i] > min) {
                    secondMin = nums[i];
                }
                if (nums[i] > secondMin)
                    return true;
            }
            return false;
        }
    }
}
