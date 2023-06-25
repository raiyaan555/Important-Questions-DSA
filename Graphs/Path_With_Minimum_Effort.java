package Graphs;

import java.util.PriorityQueue;

public class Path_With_Minimum_Effort {
    class Triplet {
        int difference;
        int row;
        int column;

        Triplet(int difference, int row, int column) {
            this.difference = difference;
            this.row = row;
            this.column = column;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int dist[][] = new int[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                dist[i][j] = (int) 1e9;
            }
        }

        dist[0][0] = 0;

        PriorityQueue<Triplet> pq = new PriorityQueue<Triplet>((x, y) -> x.difference - y.difference);

        pq.add(new Triplet(0, 0, 0));

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {
            int diff = pq.peek().difference;
            int row = pq.peek().row;
            int col = pq.peek().column;

            pq.remove();

            if (row == heights.length - 1 && col == heights[0].length - 1)
                return diff;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if (newRow >= 0 && newRow < heights.length && newCol >= 0 && newCol < heights[0].length) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[newRow][newCol]), diff);
                    if (newEffort < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newEffort;
                        pq.add(new Triplet(newEffort, newRow, newCol));
                    }
                }
            }

        }

        return 0;

    }
}
