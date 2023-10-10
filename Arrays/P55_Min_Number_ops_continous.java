package Arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P55_Min_Number_ops_continous {
    class Solution {
        public int minOperations(int[] nums) {
        Arrays.sort(nums); // Sort the array
        
        int n = nums.length;
        int maxNumsInWindow = 0;
        
        Deque<Integer> numsInWindow = new ArrayDeque<>();
        for (int num : nums) {
            // Advance the window
            while (numsInWindow.size() > 0 && num - numsInWindow.peekFirst() >= n) {
                numsInWindow.poll();
            }
            
            // Add the new number to the window (if it's not a duplicate)
            if(numsInWindow.size() == 0 || ! numsInWindow.peekLast().equals(num)) {
                numsInWindow.offer(num);            
            }
            
            maxNumsInWindow = Math.max(maxNumsInWindow, numsInWindow.size());
        }
        
        return n - maxNumsInWindow;
    }
}
}
