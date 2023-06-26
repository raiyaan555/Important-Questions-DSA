package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Bellman_Ford {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int distance[] = new int[V];
        
        Arrays.fill(distance,(int)1e8);
        
        distance[S] =0;
        
        for(int i =0; i<V-1;i++){
            for(ArrayList<Integer> j: edges){
                int u = j.get(0);
                int v = j.get(1);
                int wt = j.get(2);
                
                if(distance[u]!=1e8 && distance[u]+wt<distance[v]){
                    distance[v] = distance[u]+wt;
                }
            }
        }
        
         for(ArrayList<Integer> i: edges){
                int u = i.get(0);
                int v = i.get(1);
                int wt = i.get(2);
                
                if(distance[u]!=1e8 && distance[u]+wt<distance[v]){
                    int[] temp = new int[1];
                    temp[0] =-1;
                    return temp;
                }
            }
            return distance;
    }
}
