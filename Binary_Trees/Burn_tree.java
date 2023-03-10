package Binary_Trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Burn_tree {

    // Tree node class

    // function to print the sequence of burning nodes
    public static int search(TreeNode root,
            int num,
            Map<Integer, Set<Integer>> levelOrderMap) {
        if (root != null) {
            // Condition to check whether target
            // node is found or not in a tree
            if (root.val == num) {

                levelOrderStoredInMap(root.left, 1,
                        levelOrderMap);
                levelOrderStoredInMap(root.right, 1,
                        levelOrderMap);
                // Return statements to prevent
                // further function calls
                return 1;
            }
            int k = search(root.left, num, levelOrderMap);
            if (k > 0) {
                // store root in map with k
                storeRootAtK(root, k, levelOrderMap);
                // store level order for other branch
                levelOrderStoredInMap(root.right, k + 1,
                        levelOrderMap);
                return k + 1;
            }
            k = search(root.right, num, levelOrderMap);
            if (k > 0) {
                // store root in map with k
                storeRootAtK(root, k, levelOrderMap);
                // store level order for other branch
                levelOrderStoredInMap(root.left, k + 1,
                        levelOrderMap);
                return k + 1;
            }
        }
        return -1; // Base condition
    }

    public static void levelOrderStoredInMap(
            TreeNode root, int k,
            Map<Integer, Set<Integer>> levelOrderMap) {
        if (root != null) {
            storeRootAtK(root, k, levelOrderMap);
            levelOrderStoredInMap(root.left, k + 1,
                    levelOrderMap);
            levelOrderStoredInMap(root.right, k + 1,
                    levelOrderMap);
        }
    }

    private static void storeRootAtK(TreeNode root, int k,
            Map<Integer, Set<Integer>> levelOrderMap) {
        if (levelOrderMap.containsKey(k)) {
            levelOrderMap.get(k).add(root.val);
        } else {
            Set<Integer> set = new HashSet<>();
            set.add(root.val);
            levelOrderMap.put(k, set);
        }
    }

    // Driver Code
    public static void main(String[] args) {

        /*
         * 12
         * / \
         * 13 10
         * / \
         * 14 15
         * / \ / \
         * 21 24 22 23
         * 
         * Let us create Binary Tree as shown
         * above
         */

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(13);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);
        TreeNode left = root.right.left;
        TreeNode right = root.right.right;
        left.left = new TreeNode(21);
        left.right = new TreeNode(24);
        right.left = new TreeNode(22);
        right.right = new TreeNode(23);

        // Utility map to store the sequence of burning
        // nodes
        Map<Integer, Set<Integer>> levelOrderMap = new HashMap<>();

        // search node and store the level order from that
        // node in map
        search(root, 14, levelOrderMap);

        // will print the sequence of burning nodes
        System.out.println(14);
        for (Integer level : levelOrderMap.keySet()) {
            for (Integer val : levelOrderMap.get(level)) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}




