package Dynamic_Programming;

public class Partition_2_sets_with_min_abs_difference {
    public class Solution {
        public int solve(int[] A) {
            int n = A.length;

            int totSum = 0;

            for (int i = 0; i < A.length; i++) {
                totSum += A[i];
            }

            int k = totSum;

            boolean dp[][] = new boolean[n][k + 1];

            for (int i = 0; i < n; i++) {
                dp[i][0] = true;
            }

            if (A[0] <= k)
                dp[0][A[0]] = true;

            for (int ind = 1; ind < n; ind++) {
                for (int target = 1; target <= k; target++) {

                    boolean notTaken = dp[ind - 1][target];

                    boolean taken = false;
                    if (A[ind] <= target)
                        taken = dp[ind - 1][target - A[ind]];

                    dp[ind][target] = notTaken || taken;
                }
            }

            int ans = (int) 1e9;

            for (int i = 0; i <= totSum / 2; i++) {
                if (dp[n - 1][i] == true) {
                    ans = Math.min(ans, Math.abs((totSum - i) - i));
                }
            }
            return ans;
        }
    }

}
