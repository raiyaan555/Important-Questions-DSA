package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Searching_and_Sorting.Check_if_reversing_sub_array_make_the_array_sorted;


public class Bipartite_graph {
    private boolean check(int j, int V, ArrayList<ArrayList<Integer>> adj, int[] color){
        Queue<Integer> q = new LinkedList<>();
    
        q.add(j);
        color[j]=0;
    
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
        
    
        for(int i: adj.get(node)){
            if(color[i]==-1){
                color[i]=1-color[node];
                q.add(i);
            }
    
            else if(color[i]==color[node]){
                return false;
            }
        }
       
    }
        return true;
    
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj){
        int color[] = new int [V];
        for(int i = 0; i<V;i++){
            color[i] = -1;
        }
        for(int i =0; i<V;i++){
            if(color[i]==-1){
                if(!check(i,V,adj,color)){
                    return false;
                }
            }
        }
        return true;
    }
}
