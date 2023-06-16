package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Detect_cycle_in_directed_graph {

    //mark visit as 1 and mark visit as 2

     class Pair{
        int first;
        int second;
        
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean vis[] = new boolean[V];
        for(int i = 0; i<V;i++){
            if(vis[i]==false){
                if(checkForCycle(i,V,adj,vis))return true;
            }
        }
        return false;
    }
    
    boolean checkForCycle(int i, int V,  ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[i] = true;
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(i, -1));
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.poll();
            
            for(int adjNode : adj.get(node)){
                if(vis[adjNode]==false){
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, node));
                }
                // if parent is not adj node then only visited because there is a cycle
                else if (parent!=adjNode){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int vis[] = new int[V];
        int pathVis[] = new int[V];
        
        for(int i = 0; i<V;i++){
            if(vis[i]==0){
                if(dfs(i,adj,vis,pathVis)){
                    return true;
                }
            }
        }
        return false;
        
    }
    
    boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int vis[], int[] pathVis)
    {
    vis[node] = 1;
    pathVis[node] = 1;
    
    
    for(int i: adj.get(node)){
        if(vis[i]==0)
        {
            if(dfs(i,adj,vis,pathVis)){
                return true;
            }
        }else if(pathVis[i]==1){
            return true;
        }
    }
    
    pathVis[node]=0;
    return false;
    
}
}
