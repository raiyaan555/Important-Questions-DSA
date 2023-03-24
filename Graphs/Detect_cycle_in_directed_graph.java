package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Detect_cycle_in_directed_graph {

    boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){

        int[] indegree = new int[V];

        for(int i=0; i<V;i++){
            for(int j : adj.get(i)){
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int topo[] = new int[V];

        int c = 0; 
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            c++;

            

            for(int j: adj.get(node)){
                indegree[j]--;
                if(indegree[j]==0){
                    q.add(j);
                }
            }
        }
        if(c!=V) return false;

        return true;
    }
}
