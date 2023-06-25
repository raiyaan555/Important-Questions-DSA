package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Cheapest_Flights_Within_K_Stops {
    class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    class Triplets {
        int stops, node, cost;

        Triplets(int stops, int node, int cost) {
            this.stops = stops;
            this.node = node;
            this.cost = cost;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int m = flights.length;

        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Triplets> q = new LinkedList<>();
        q.add(new Triplets(0, src, 0));
        int[] dist = new int[n];

        Arrays.fill(dist, (int) 1e9);

        dist[src] = 0;

        while (!q.isEmpty()) {
            int stops = q.peek().stops;
            int node = q.peek().node;
            int cost = q.peek().cost;
            q.remove();

            if (stops > k)
                continue;

            for (Pair iter : adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW;
                    q.add(new Triplets(stops + 1, adjNode, cost + edW));
                }
            }
        }
        if (dist[dst] == (int) 1e9)
            return -1;
        return dist[dst];
    }
}
