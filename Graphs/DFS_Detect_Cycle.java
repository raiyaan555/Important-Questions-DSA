package Graphs;

import java.util.*;

public class DFS_Detect_Cycle {

    private boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;

        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                if (dfs(i, node, vis, adj) == true)
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;

    }

    private boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, -1, vis, adj) == true)
                    return true;
            }
        }
        return false;
    }
}
