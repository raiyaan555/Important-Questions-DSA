package Strings;

public class P14_Count_Palindromic_Subsequences {

    public static boolean isPalindrome(String s) {
        if(s.length()==1){
            return true;
        }
        String s1 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            s1 = s1 + s.charAt(i);
        }
        if (s1.equalsIgnoreCase(s)) {
            return true;
        } else
            return false;
    }

    static long countPS(String str) {
         long count =0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if(isPalindrome(str.substring(i,j))){
                    count++;
                    System.out.println(str.substring(i,j));
                    System.out.println(isPalindrome(str.substring(i,j)));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPS("aab"));
        
        
        
    }

}
