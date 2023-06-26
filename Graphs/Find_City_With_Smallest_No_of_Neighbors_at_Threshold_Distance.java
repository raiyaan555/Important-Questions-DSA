package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Find_City_With_Smallest_No_of_Neighbors_at_Threshold_Distance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int costs[][] = getCosts(edges, n);
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (costs[i][k] != Integer.MAX_VALUE && costs[k][j] != Integer.MAX_VALUE) {
                        costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                    }
                }
            }
        }
        List<List<Integer>> connectedCities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            connectedCities.add(new ArrayList<>());
        }
        int minCitiesIndex = Integer.MAX_VALUE;
        int minSize = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i != j && costs[i][j] != Integer.MAX_VALUE && costs[i][j] <= distanceThreshold) {
                    connectedCities.get(i).add(j);
                }
            }
            int currSize = connectedCities.get(i).size();

            if (currSize <= minSize) {
                minSize = currSize;
                minCitiesIndex = i;
            }
        }

        return minCitiesIndex;
    }

    private int[][] getCosts(int[][] edges, int n) {
        int costs[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    costs[i][j] = 0;
                else
                    costs[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            costs[u][v] = cost;
            costs[v][u] = cost;
        }

        return costs;
    }
}
