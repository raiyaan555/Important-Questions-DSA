
package Graphs;

import java.util.*;

class No_of_provinces {
    // dfs traversal function
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

        // code here

        boolean[] vis = new boolean[V + 1];

        int province = 0;

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= V; i++)

        {

            if (vis[i] != true)

            {

                province++;

                q.add(i);

                while (!q.isEmpty())

                {

                    int node = q.poll();

                    for (int j = 0; j < adj.get(node - 1).size(); j++)

                    {

                        if (adj.get(node - 1).get(j) == 1 && vis[j + 1] != true)

                        {

                            vis[j + 1] = true;

                            q.add(j + 1);

                        }

                    }

                }

            }

        }

        return province;

    }

    public static void main(String[] args) {

        // adjacency matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);

        No_of_provinces ob = new No_of_provinces();
        System.out.println(No_of_provinces.numProvinces(adj, 3));
    }
};