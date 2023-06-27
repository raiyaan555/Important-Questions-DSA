package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Disjoint_Set_Rank {

    static List<Integer> rank = new ArrayList<>();
    static List<Integer> parent = new ArrayList<>();

    Disjoint_Set_Rank(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    int findUParent(int node) {
        if (node == parent.get(node))
            return node;

        int uParent = findUParent(parent.get(node));
        parent.set(node, uParent);
        return parent.get(node);
    }

    void findParent(int u, int v) {
        int uParent = findUParent(u);
        int vParent = findUParent(v);

        if (uParent == vParent) {
            return;
        }

        if (rank.get(uParent) < rank.get(vParent)) {
            parent.set(uParent, vParent);
        } else if (rank.get(vParent) < rank.get(uParent)) {
            parent.set(vParent, uParent);
        } else {
            parent.set(uParent, vParent);
            rank.set(uParent, rank.get(uParent) + 1);
        }
    }

    public static void main(String[] args) {
        Disjoint_Set_Rank ds = new Disjoint_Set_Rank(7);
        ds.findParent(1, 2);
        ds.findParent(2, 3);
        ds.findParent(4, 5);
        ds.findParent(6, 7);
        ds.findParent(5, 6);

        // if 3 and 7 same or not
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.findParent(3, 7);
        if (ds.findUParent(3) == ds.findUParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }

}
