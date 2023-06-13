package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// time complexity is equal to the O(n)+O(2E) and space is o(3N)
public class BFS {
    
    public ArrayList<Integer> bfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();

        boolean vis[] = new boolean[v];

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;


        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);


            for(Integer i:adj.get(node)){
                if(vis[i]==false){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }
}
