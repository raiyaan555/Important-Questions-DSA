package Dynamic_Programming;

public class Build_Array_Where_you_can_find_max_k_comparasions {
    public class Solution {
        public int numOfArrays(int n, int m, int k) {
            final int mod = 1000000007;
    
            int[][] dp = new int[m+1][k+1];
            int[][] prefix = new int[m+1][k+1];
            int[][] prevDp = new int[m+1][k+1];
            int[][] prevPrefix = new int[m+1][k+1];
    
            for (int j = 1; j <= m; j++) {
                prevDp[j][1] = 1;
                prevPrefix[j][1] = j;
            }
    
            for (int i = 2; i <= n; i++) {
                for (int maxNum = 1; maxNum <= m; maxNum++) {
                    for (int cost = 1; cost <= k; cost++) {
                        dp[maxNum][cost] = (int)(((long)maxNum * prevDp[maxNum][cost]) % mod);
    
                        if (maxNum > 1 && cost > 1) {
                            dp[maxNum][cost] = (dp[maxNum][cost] + prevPrefix[maxNum - 1][cost - 1]) % mod;
                        }
    
                        prefix[maxNum][cost] = (prefix[maxNum - 1][cost] + dp[maxNum][cost]) % mod;
                    }
                }
    
                for (int j = 1; j <= m; j++) {
                    System.arraycopy(dp[j], 0, prevDp[j], 0, k+1);
                    System.arraycopy(prefix[j], 0, prevPrefix[j], 0, k+1);
                }
            }
    
            return prefix[m][k];
        }
    }
}
