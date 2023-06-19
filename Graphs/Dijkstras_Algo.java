package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstras_Algo {
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[S] = 0;

        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        minHeap.offer(new Node(S, 0));

        while (!minHeap.isEmpty()) {
            Node currNode = minHeap.poll();
            int currVertex = currNode.vertex;

            for (ArrayList<Integer> neighbor : adj.get(currVertex)) {
                int nextVertex = neighbor.get(0);
                int weight = neighbor.get(1);

                if (distances[currVertex] + weight < distances[nextVertex]) {
                    distances[nextVertex] = distances[currVertex] + weight;
                    minHeap.offer(new Node(nextVertex, distances[nextVertex]));
                }
            }
        }
        return distances;
    }
}
