package Dynamic_Programming;

public class Longest_Common_Subsequence {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int dp[][] = new int[text1.length() + 1][text2.length() + 1];

            for (int i = 1; i <= text1.length(); i++) {
                for (int j = 1; j <= text2.length(); j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1))
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
            return dp[text1.length()][text2.length()];

        }

        int f(int i1, int i2, String s1, String s2, int dp[][]) {
            if (i1 == 0 || i2 == 0) {
                return 0;
            }

            if (dp[i1][i2] != -1)
                return dp[i1][i2];

            if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
                return dp[i1][i2] = 1 + f(i1 - 1, i2 - 1, s1, s2, dp);
            else
                return dp[i1][i2] = Math.max(f(i1 - 1, i2, s1, s2, dp), f(i1, i2 - 1, s1, s2, dp));

        }
    }
}
