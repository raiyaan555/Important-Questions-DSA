package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Eventual_safe_states {
    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int pathVis[], int[] check) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for (int i : adj.get(node)) {

            if (vis[i] == 0) {
                if (dfsCheck(i, adj, vis, pathVis, check)) {
                    return true;
                }

            } else if (pathVis[i] == 1) {
                return true;
            }

        }

        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    List<Integer> eventualSafeNodes(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        int check[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (check[i] == 1)
                safeNodes.add(i);
        }

        return safeNodes;
    }

}
