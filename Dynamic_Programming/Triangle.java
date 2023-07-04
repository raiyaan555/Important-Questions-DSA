package Dynamic_Programming;

import java.util.List;

public class Triangle {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int front[] = new int[n];
            int curr[] = new int[n];
            for (int j = 0; j < n; j++) {
                front[j] = triangle.get(n - 1).get(j);
            }

            for (int i = n - 2; i >= 0; i--) {
                for (int j = i; j >= 0; j--) {

                    int down = triangle.get(i).get(j) + front[j];
                    int diagonal = triangle.get(i).get(j) + front[j + 1];

                    curr[j] = Math.min(down, diagonal);
                }
                front = curr;
            }

            return front[0];
        }

        int helper(List<List<Integer>> triangle, int dp[][], int i, int j) {

            if (dp[i][j] != -1)
                return dp[i][j];
            if (i == triangle.size() - 1)
                return triangle.get(i).get(j);

            int down = triangle.get(i).get(j) + helper(triangle, dp, i + 1, j);
            int diag = triangle.get(i).get(j) + helper(triangle, dp, i + 1, j + 1);

            return dp[i][j] = Math.min(down, diag);
        }
    }
}
