package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P47_Return_difference_between_2_sets {
    class Solution {
        
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map1 = new HashMap<>();
            HashMap<Integer, Integer> map2 = new HashMap<>();

            for (int i : nums1) {
                if (map2.containsKey(i)) {
                    map2.put(i, 1);
                } else {
                    map2.put(i, 1);
                }
            }

            for (int i : nums2) {
                if (map1.containsKey(i)) {
                    map1.put(i, 1);
                } else {
                    map1.put(i, 1);
                }
            }
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> a1 = new ArrayList<>();
            List<Integer> a2 = new ArrayList<>();
            HashMap<Integer, Integer> dup = new HashMap<>();
            for (int i : nums1) {
                if (!map1.containsKey(i) && !dup.containsKey(i)) {
                    a1.add(i);
                    dup.put(i, 1);
                } else {
                    dup.put(i, 1);
                }
            }
            ans.add(a1);
            dup = new HashMap<>();

            for (int i : nums2) {
                if (!map2.containsKey(i) && !dup.containsKey(i)) {
                    a2.add(i);
                    dup.put(i, 1);
                } else {
                    dup.put(i, 1);
                }
            }
            ans.add(a2);

            return ans;
        }
    }
}
