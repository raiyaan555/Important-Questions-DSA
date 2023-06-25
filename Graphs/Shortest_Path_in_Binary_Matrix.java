package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Shortest_Path_in_Binary_Matrix {
    class Triplets {
        int distance;
        int row;
        int column;

        Triplets(int distance, int row, int column) {
            this.distance = distance;
            this.row = row;
            this.column = column;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dist[i][j] = (int) 1e9;
            }
        }

        Queue<Triplets> q = new LinkedList<>();

        if (grid[0][0] != 0)
            return -1;
        if (grid[0].length == 1 && grid.length == 1)
            return 1;

        q.offer(new Triplets(1, 0, 0));

        dist[0][0] = 0;

        int[] delrow = { -1, 0, 1 };
        int[] delcol = { -1, 0, 1 };

        while (!q.isEmpty()) {
            int distance = q.peek().distance;
            int row = q.peek().row;
            int column = q.peek().column;
            q.remove();

            for (int i = 0; i < delrow.length; i++) {
                for (int j = 0; j < delcol.length; j++) {
                    int nrow = row + delrow[i];
                    int ncol = column + delcol[j];

                    if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == 0
                            && distance + 1 < dist[nrow][ncol]) {
                        dist[nrow][ncol] = distance + 1;
                        if (nrow == grid.length - 1 && ncol == grid[0].length - 1)
                            return distance + 1;
                        q.offer(new Triplets(distance + 1, nrow, ncol));
                    }
                }
            }
        }
        return -1;

    }
}
