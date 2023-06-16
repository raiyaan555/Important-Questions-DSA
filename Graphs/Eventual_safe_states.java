package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Eventual_safe_states {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int visit[] = new int[n];
        int pathVisit[] = new int[n];
        int check[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (visit[i] == 0) {
                dfs(i, visit, pathVisit, check, graph);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (check[i] == 1)
                ans.add(i);
        }
        return ans;

    }

    public boolean dfs(int i, int visit[], int pathVisit[], int check[], int[][] graph) {
        visit[i] = 1;
        pathVisit[i] = 1;
        check[i] = 0;
        // Traverse for the adjacent node
        for (int e : graph[i]) {
            // when the node is not visited
            if (visit[e] == 0) {
                if (dfs(e, visit, pathVisit, check, graph)) {
                    return true;
                }
            }
            // if the node has previously visited
            // but it has to be on the same path.
            else if (pathVisit[e] == 1)
                return true;
        }
        check[i] = 1;
        pathVisit[i] = 0;
        return false;
    }

}
