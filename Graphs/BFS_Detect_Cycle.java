package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Detect_Cycle {

    public boolean checkForCycle(int src, int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[src] = true;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(src, -1));

        while (!q.isEmpty()) {
            int node = q.peek().first;
            int parent = q.peek().second;

            q.remove();

            for (int i : adj.get(node)) {
                if (!vis[i]) {
                    vis[i] = true;
                    q.add(new Pair(i, node));
                } else if (parent != i) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int src, int V, ArrayList<ArrayList<Integer>> adj) {

        boolean vis[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            vis[i] = false;
        }
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (checkForCycle(src, V, adj, vis))
                    return true;
            }
        }
        return false;
    }
}
