package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_Eventual_Safe_State {
    List<Integer>  eventaulsSafeNodes(int V, List<List<Integer>> adj){
        List<List<Integer>> adjRev = new ArrayList<>();

        for(int i = 0; i<V;i++){
            adjRev.add(new ArrayList<>());
        }

        int indegree[] = new int[V];

        for(int i = 0; i<V;i++){
        for(int j : adj.get(i)){
            // the reverse of the graph we store as we reverse the indegree and the outdegree
            adjRev.get(j).add(i);
            indegree[j]++;
        }
    }

    Queue<Integer> q = new LinkedList<>();
    List<Integer> safeNodes = new ArrayList<>();

    for(int  i = 0; i<V;i++){
        if(indegree[i]==0){
            q.add(i);
        }
    }

    while(!q.isEmpty()){
        int node = q.peek();
        q.remove();
        safeNodes.add(node);
        for(int i: adjRev.get(node)){
            indegree[i]--;
            if(indegree[i]==0) q.add(i);
        }
    }
    Collections.sort(safeNodes);
    return safeNodes;
    }


     public List<Integer> eventualSafeNodes(int[][] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        ArrayList<Integer>[] a = new ArrayList[graph.length];

        for(int i=0;i<a.length;i++){
            a[i] = new ArrayList<>();
        }

        int[] outDegree = new int[graph.length];
        int i=0;
        for(int[] x:graph){
            for(int y:x){
                a[y].add(i);
            }
            outDegree[i] = x.length;
            if(x.length==0){
                queue.add(i);
            }
            i++;
        }

        boolean[] isSafe = new boolean[a.length];
        ArrayList<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            int curr = queue.remove();
            isSafe[curr] = true;
            for(int x:a[curr]){
                if(--outDegree[x]==0){
                    queue.add(x);
                }
            }
        }
 
        for(i=0;i<a.length;i++){
            if(isSafe[i]){
                ans.add(i);
            }
        }
        return ans;   
    }
}
