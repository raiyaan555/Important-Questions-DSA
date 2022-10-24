package Strings;

public class P11_Longest_Palindromic_Substring {
    public static String longestPalindrome(String s) {

        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0, end = 0;

        for (int j = 0; j<s.length();j++){
            for(int i =0; i+j<s.length();i++){
                dp[i][i+j] = s.charAt(i) == s.charAt(i+j) && (j < 2 || dp[i+1][i+j-1]);

                if (dp[i][i+j] && j > end - start) {
                    start = i;
                    end = i + j;
                }
            }
        }
        return s.substring(start, end+1);
        
    }

    public static void main(String[] args) {
       
        System.out.println(longestPalindrome("cbbd"));

    }
}

