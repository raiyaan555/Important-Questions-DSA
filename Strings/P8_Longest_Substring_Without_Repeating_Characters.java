package Strings;

import java.util.*;

public class P8_Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0;
        int j = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            ans = Math.max(ans, j - i + 1);
            j++;

        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }
}
