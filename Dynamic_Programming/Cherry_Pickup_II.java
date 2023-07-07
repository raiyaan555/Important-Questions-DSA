package Dynamic_Programming;

import java.util.Arrays;

public class Cherry_Pickup_II {
    class Solution {
        public int cherryPickup(int[][] grid) {
            int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];

            for (int[][] i : dp) {
                for (int[] j : i) {
                    Arrays.fill(j, -1);
                }
            }

            return helper(0, 0, grid[0].length - 1, dp, grid);
        }

        int helper(int i, int j1, int j2, int[][][] dp, int[][] grid) {
            if (j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) {
                return (int) -1e8;
            }
            if (i == grid.length - 1) {
                if (j1 == j2)
                    return grid[i][j1];
                else
                    return grid[i][j1] + grid[i][j2];
            }

            if (dp[i][j1][j2] != -1)
                return dp[i][j1][j2];

            int max = (int) -1e8;

            for (int k = -1; k <= 1; k++) {
                for (int k1 = -1; k1 <= 1; k1++) {
                    if (j1 == j2) {
                        max = Math.max(max, grid[i][j1] + helper(i + 1, j1 + k, j2 + k1, dp, grid));
                    } else {
                        max = Math.max(max, grid[i][j1] + grid[i][j2] + helper(i + 1, j1 + k, j2 + k1, dp, grid));
                    }
                }
            }
            return dp[i][j1][j2] = max;
        }
    }

    static int maximumChocolates(int n, int m, int[][] grid) {
        int[][] front = new int[m][m];
        int[][] cur = new int[m][m];

        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = grid[n - 1][j1];
                else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        // Outer Nested Loops for travering DP Array
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {

                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {

                            int ans;

                            if (j1 == j2)
                                ans = grid[i][j1];
                            else
                                ans = grid[i][j1] + grid[i][j2];

                            if ((j1 + di < 0 || j1 + di >= m) ||
                                    (j2 + dj < 0 || j2 + dj >= m))

                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += front[j1 + di][j2 + dj];

                            maxi = Math.max(ans, maxi);
                        }
                    }
                    cur[j1][j2] = maxi;
                }
            }

            for (int a = 0; a < m; a++) {
                front[a] = (int[]) (cur[a].clone());
            }
        }

        return front[0][m - 1];
    }
}
