
package Graphs;

import java.util.*;

class No_of_provinces {
    // dfs traversal function
    private void dfs(int node, boolean vis[], int adj[][]) {
        vis[node] = true;
        for(int i=0; i<adj[node].length; i++){
            if( i != node && adj[node][i] == 1 && vis[i] == false ) dfs(i, vis, adj);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        boolean vis[] = new boolean[isConnected.length];
        int count = 0;

        for(int i = 0; i<isConnected.length;i++){
            if(!vis[i]){
                count++;
                dfs(i,vis,isConnected);
            }
        }
        return count;
    }

    

    
};