package Arrays;

import java.util.HashMap;

public class P33_Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int i = 0; 
        int j = 0; 
        HashMap<Character,Integer> map = new HashMap<>();
 
 
 
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i,map.get(s.charAt(j))+1);
            }
            map.put(s.charAt(j), j);
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
     }
}
