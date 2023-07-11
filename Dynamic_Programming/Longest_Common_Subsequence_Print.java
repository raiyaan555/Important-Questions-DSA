package Dynamic_Programming;

public class Longest_Common_Subsequence_Print {

    static void lcs(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = 0 + Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        int len = dp[n][m];
        int i = n;
        int j = m;

        int index = len - 1;
        String str = "";
        for (int k = 1; k <= len; k++) {
            str += "$"; // dummy string
        }
        StringBuilder ss = new StringBuilder(s1);
        StringBuilder str2 = new StringBuilder(str);
        while (i > 0 && j > 0) {
            if (ss.charAt(i - 1) == s2.charAt(j - 1)) {
                str2.setCharAt(index, ss.charAt(i - 1));
                index--;
                i--;
                j--;
            } else if (ss.charAt(i - 1) > s2.charAt(j - 1)) {
                i--;
            } else
                j--;
        }
        System.out.println(str2);
    }

    public static void main(String args[]) {

        String s1 = "abcde";
        String s2 = "bdgek";

        System.out.print("The Longest Common Subsequence is ");
        lcs(s1, s2);
    }
}
