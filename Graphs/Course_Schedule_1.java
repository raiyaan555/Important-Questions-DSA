package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule_1 {
    public boolean isPossible(int V, int[][] prerequistes){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i= 0; i<V;i++){
            adj.add(new ArrayList<>());
        }

        int n = prerequistes.length;

        for(int i = 0; i<n;i++){
            adj.get(prerequistes[i][0]).add(prerequistes[i][1]);
        }


        int indegree[] = new int [V];

        for(int i=0; i<V;i++){
            for(int j: adj.get(i)){
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<Integer>();

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);

            for(int i: adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0)q.add(i);
            }
        }
        if(topo.size()==V) return true;

        return false;
    }
}
