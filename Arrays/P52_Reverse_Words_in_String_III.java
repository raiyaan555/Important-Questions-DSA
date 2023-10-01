package Arrays;

public class P52_Reverse_Words_in_String_III {
    class Solution {
        public String reverseWord(String s){
            StringBuilder ans = new StringBuilder();
            for(int i =s.length()-1; i>=0;i--){
               ans.append(s.charAt(i));
            }
            return ans.toString();
        }
        public String reverseWords(String s) {
            String w  ="";
            String ans ="";
            s = s+" ";
            for(int i =0; i<s.length();i++){
                char c = s.charAt(i);
                if(c!=32){
                    w = w+c;
                }else if(c==32){
                    if(i==s.length()-1){
                         ans += reverseWord(w);
                    }else
                    ans += reverseWord(w)+" ";
                    w = "";
                }
            }
            return ans;
        }
    }
}
