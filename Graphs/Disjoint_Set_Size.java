package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Disjoint_Set_Size {
    static List<Integer> size = new ArrayList<>();
    static List<Integer> parent = new ArrayList<>();

    Disjoint_Set_Size(int n) {
        for (int i = 0; i <= n; i++) {
            size.add(1);
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

        if (size.get(vParent) < size.get(uParent)) {
            parent.set(vParent, size.get(vParent) + size.get(uParent));
        } else {
            parent.set(uParent, vParent);
            size.set(uParent, size.get(vParent) + size.get(uParent));
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
