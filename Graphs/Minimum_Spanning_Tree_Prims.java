package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Minimum_Spanning_Tree_Prims {
    static class Node implements Comparable<Node> {
        int v;
        int w;

        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static int spanningTree(int V, int E, int edges[][]) {
        // Code Here.
        int sum = 0;
        PriorityQueue<Node> mh = new PriorityQueue<>();
        boolean[] vis = new boolean[V];
        ArrayList<ArrayList<Node>> a = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < V; i++)
            a.add(new ArrayList<>());

        for (int[] i : edges) {
            a.get(i[0]).add(new Node(i[1], i[2]));
            a.get(i[1]).add(new Node(i[0], i[2]));
        }
        mh.add(new Node(0, 0));

        while (!mh.isEmpty()) {

            Node cur = mh.poll();
            if (vis[cur.v])
                continue;

            vis[cur.v] = true;
            sum += cur.w;

            for (Node n : a.get(cur.v)) {
                if (!vis[n.v])
                    mh.add(new Node(n.v, n.w));
            }

        }

        return sum;
    }
}
