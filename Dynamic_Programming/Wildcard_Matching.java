package Dynamic_Programming;

import java.util.Arrays;

public class Wildcard_Matching {
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int[] row : dp) {
                Arrays.fill(row, -1);
            }

            return f(s, p, m - 1, n - 1, dp);
        }

        public boolean f(String s1, String s2, int m, int n, int[][] dp) {
            if (m < 0 && n < 0)
                return true;
            if (n < 0 && m >= 0)
                return false;
            if (n >= 0 && m < 0) {
                for (int i = 0; i <= n; i++) {
                    if (s2.charAt(i) != '*')
                        return false;
                }
                return true;
            }
            if (dp[m][n] != -1)
                return dp[m][n] == 1 ? true : false;
            if (s1.charAt(m) == s2.charAt(n) || s2.charAt(n) == '?') {
                boolean ans = f(s1, s2, m - 1, n - 1, dp);
                dp[m][n] = ans == true ? 1 : 0;
                return ans;
            }
            if (s2.charAt(n) == '*') {
                boolean ans = f(s1, s2, m, n - 1, dp) || f(s1, s2, m - 1, n, dp);
                dp[m][n] = ans == true ? 1 : 0;
                return ans;

            }
            dp[m][n] = 0;
            return false;
        }
    }
}
