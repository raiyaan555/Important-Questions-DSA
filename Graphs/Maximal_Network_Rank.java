package Graphs;

import java.util.HashMap;
import java.util.HashSet;

public class Maximal_Network_Rank {

    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            // question is asking for the maximum indegree sum between two nodes
            // build the graph with adjacency lists and hashmap, then look for the pair
            // with the largest sum

            HashMap<Integer, HashSet<Integer>> adjList = new HashMap<>();
            for (int i = 0; i < n; i++) {
                adjList.put(i, new HashSet<Integer>());
            }
            int m = roads.length;
            for (int i = 0; i < m; i++) {
                adjList.get(roads[i][0]).add(roads[i][1]);
                adjList.get(roads[i][1]).add(roads[i][0]);
            }

            // naive approach - n^2 (optimal as the graph can be completely connected)
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    int tmp = 0;
                    if (adjList.get(i).contains(j))
                        tmp--;
                    tmp += adjList.get(i).size() + adjList.get(j).size();
                    max = Math.max(tmp, max);
                }
            }
            return max;
        }
    }

}
