package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Accounts_Merge {
    class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
                size.add(1);
            }
        }

        public int findUPar(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int ulp = findUPar(parent.get(node));
            parent.set(node, ulp);
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v)
                return;
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                int rankU = rank.get(ulp_u);
                rank.set(ulp_u, rankU + 1);
            }
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if (ulp_u == ulp_v)
                return;
            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            DisjointSet ds = new DisjointSet(accounts.size());

            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < accounts.size(); i++) {
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    if (map.containsKey(accounts.get(i).get(j)) == false) {
                        map.put(accounts.get(i).get(j), i);
                    } else {
                        ds.unionBySize(i, map.get(accounts.get(i).get(j)));
                    }
                }
            }

            List<String>[] mergedMail = new ArrayList[accounts.size()];

            for (int i = 0; i < accounts.size(); i++) {
                mergedMail[i] = new ArrayList<>();
            }

            for (Map.Entry<String, Integer> it : map.entrySet()) {
                String mail = it.getKey();
                int node = ds.findUPar(it.getValue());
                mergedMail[node].add(mail);
            }

            List<List<String>> ans = new ArrayList<>();

            for (int i = 0; i < accounts.size(); i++) {
                if (mergedMail[i].size() == 0)
                    continue;
                Collections.sort(mergedMail[i]);
                List<String> temp = new ArrayList<>();
                temp.add(accounts.get(i).get(0));

                for (String j : mergedMail[i]) {
                    temp.add(j);
                }
                ans.add(temp);

            }
            return ans;

        }
    }
}
