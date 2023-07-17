package Binary_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Vertical_Traversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Triple {
        TreeNode node;
        int vertical;
        int level;

        Triple(TreeNode node, int level, int vertical) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }

    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();

            // map<vertical,map<level,pq<int>>>

            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
            Queue<Triple> q = new LinkedList<>();

            // Insert Values into the q <node, vertical, level>
            q.offer(new Triple(root, 0, 0));

            while (!q.isEmpty()) {
                Triple triple = q.poll();
                TreeNode node = triple.node;
                int x = triple.vertical;
                int y = triple.level;

                // Check for the vertical to be 0 and put map

                if (!map.containsKey(x)) {
                    map.put(x, new TreeMap<>());
                }

                // Check for the level to be 0 and put pq
                if (!map.get(x).containsKey(y)) {
                    map.get(x).put(y, new PriorityQueue<>());
                }

                // offer node here and put values of node

                map.get(x).get(y).offer(node.val);

                // left check and right check and commute accordingly

                if (node.left != null) {
                    q.offer(new Triple(node.left, y + 1, x - 1));
                }
                if (node.right != null) {
                    q.offer(new Triple(node.right, y + 1, x + 1));
                }
            }
            // go inside the map to get the values

            for (TreeMap<Integer, PriorityQueue<Integer>> i : map.values()) {
                // add a new arraylist
                ans.add(new ArrayList<>());
                for (PriorityQueue<Integer> j : i.values()) {
                    while (!j.isEmpty()) {
                        // while you add the arraylist we need to keep adding the values associated with
                        // the given pq so we add at the end of the new arraylist.
                        ans.get(ans.size() - 1).add(j.poll());
                    }
                }
            }

            return ans;
        }
    }
}

class TreeNode {

    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}
