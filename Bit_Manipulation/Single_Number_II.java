package Bit_Manipulation;

public class Single_Number_II {
    class Solution {
        public int singleNumber(int[] nums) {

            int ones = 0;
            int twos = 0;

            for (int i : nums) {
                ones = ones ^ i & (~twos);
                twos = twos ^ i & (~ones);
            }

            return ones;

        }
    }
}
