package Strings;

public class P4_Remove_Consecutive_Characters {
    public static String removeConsecutiveCharacter(String s){
        String s1 = "";
        s1 = s1+s.charAt(0);
        for(int i =1; i<s.length();i++){
           
            if(s.charAt(i)!=s.charAt(i-1)){
                s1 = s1+s.charAt(i);
            }
        }
        return s1;
    }
    public static void main(String[] args) {
        String s = "aaccbbbccdd";
        System.out.println(removeConsecutiveCharacter(s));
    }
}
