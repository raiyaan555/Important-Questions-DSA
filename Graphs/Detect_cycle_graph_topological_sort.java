package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Detect_cycle_graph_topological_sort {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here

        int indegree[] = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int temp = q.remove();
            cnt++;

            for (int it : adj.get(temp)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (cnt == V)
            return false;
        return true;

    }

}
