package Graphs;

import java.util.ArrayList;

// the time complexity is o(N*M)  and the soace is o(N*M);

public class Bipartite_graph_dfs {
    private boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj){

        color[node] = col;

        for(int i: adj.get(node)){
            if(color[i]==-1){
                if(!dfs(i, 1-col, color, adj)){
                    return false;
                }

                else if(color[i]==color[node]){
                    return false;
                }
            }
        }

        return true;

    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj){
        int color[] = new int[V];

        for(int i = 0;i<V; i++){
            color[i] = -1;
        }

        for(int i = 0; i<V;i++){
            if(color[i]==-1){
                if(!dfs(i, 0, color, adj)){
                    return false;
                }
            }
        }
        return true;
    }
}
