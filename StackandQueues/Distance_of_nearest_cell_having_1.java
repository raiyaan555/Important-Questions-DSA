package StackandQueues;

import java.util.LinkedList;
import java.util.Queue;

public class Distance_of_nearest_cell_having_1 {
    class Pair {
        int row;
        int column;

        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public int[][] nearest(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;

        int[][] ans = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                    ans[i][j] = 0;
                } else {
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] drow = { -1, 0, 1, 0 };
        int[] dcol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().column;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int newRow = r + drow[i];

                int newCol = c + dcol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && ans[newRow][newCol] == Integer.MAX_VALUE) {
                    q.add(new Pair(newRow, newCol));
                    ans[newRow][newCol] = ans[r][c] + 1;
                }
            }
        }

        return ans;

    }
}
