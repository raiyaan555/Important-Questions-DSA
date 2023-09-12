package Heap_and_Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Minimum_deletions_to_make_character_frequencies_Unique {
    class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        // System.out.println(map);
        // map contains all the chars along with the desired frequency

        HashSet<Integer> set = new HashSet<>();
        int count=0;

        for(Map.Entry<Character,Integer> i: map.entrySet()){
            int value = i.getValue();
            if(set.contains(value)){
                while(value!=0 && set.contains(value)){
                    value--;
                    count++;
                }
            }
            set.add(value);
        }
        // System.out.println(set);
        return count;
    }
}
}
