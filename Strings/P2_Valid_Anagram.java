package Strings;


import java.util.HashMap;

public class P2_Valid_Anagram {
    public static boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        int n = s.length();
        int m = t.length();

        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0;i<m;i++)
        {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) - 1);
        }

        for(int a : map.values())
        {
            if(a != 0)
                return false;
        }
        return true;
    }
    

    public static void main(String[] args) {
        String s = "cat";
        String t = "tac";
        System.out.println(isAnagram(s, t));
    }
}
