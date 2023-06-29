package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class Strongly_Connected_Components_Kosarajus_Algo {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>(); // To store the nodes in decreasing order of finish time

        for (int i = 0; i < V; i++) {
            if (vis[i] == false)
                dfs(i, vis, st, adj);
        }

        ArrayList<ArrayList<Integer>> Transpose = new ArrayList<>(); // Reversing connections
        for (int i = 0; i < V; i++) {
            Transpose.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < V; i++) {

            vis[i] = false; // very important

            for (int neighbor : adj.get(i)) {
                Transpose.get(neighbor).add(i);
            }
        }

        int scc = 0;

        while (!st.isEmpty()) {
            int x = st.pop();

            if (vis[x] == false) {
                scc++; // Number of times dfs2 will be called = scc
                dfs2(x, vis, Transpose);
            }
        }

        return scc;
    }

    private void dfs(int node, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (vis[neighbor] == false)
                dfs(neighbor, vis, st, adj);
        }

        st.push(node); // greatest finish time will be popped first
    }

    private void dfs2(int node, boolean[] vis, ArrayList<ArrayList<Integer>> Transpose) {
        vis[node] = true;

        for (int neighbor : Transpose.get(node)) {
            if (vis[neighbor] == false)
                dfs2(neighbor, vis, Transpose);
        }
    }

}
