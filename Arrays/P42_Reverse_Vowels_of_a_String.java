package Arrays;

import java.util.Stack;

public class P42_Reverse_Vowels_of_a_String {
    class Solution {
    public String reverseVowels(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i<s.length();i++){
            if(Character.toLowerCase(s.charAt(i))=='a'||
            Character.toLowerCase(s.charAt(i))=='e'||
            Character.toLowerCase(s.charAt(i))=='i'||
            Character.toLowerCase(s.charAt(i))=='o'||
            Character.toLowerCase(s.charAt(i))=='u')
            {
                st.push(s.charAt(i));
            }
        }
        String w = "";
        for(int i = 0 ; i<s.length();i++){
            if(Character.toLowerCase(s.charAt(i))=='a'||
            Character.toLowerCase(s.charAt(i))=='e'||
            Character.toLowerCase(s.charAt(i))=='i'||
            Character.toLowerCase(s.charAt(i))=='o'||
            Character.toLowerCase(s.charAt(i))=='u')
            {
                w = w+st.pop();
            }else w = w+s.charAt(i);
        }
        return w;

    }
}
}
