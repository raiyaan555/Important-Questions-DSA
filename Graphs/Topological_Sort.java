package Graphs;

import java.util.ArrayList;
import java.util.Stack;

// time complexity is O(V+E) and space is stack space O(N);
public class Topological_Sort {
    private static void dfs(int node, int vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){

        vis[node]=1;

        for(int i: adj.get(node)){
            if(vis[i]==0){
                dfs(i, vis, st, adj);
            }
        st.push(node);
    }
}

    static int[] topSort(int V, ArrayList<ArrayList<Integer>> adj){

        int vis[] = new int[V];

        Stack<Integer> st = new Stack<Integer>();

        for(int i =0; i<V;i++){
            if(vis[i]==0){
                dfs(i, vis, st, adj);
            }
        }


        int ans[] = new int[V];
        int i = 0; 

        while(!st.isEmpty()){
            ans[i++]=st.peek();
            st.pop();
        }
        return ans;
        }   
     }