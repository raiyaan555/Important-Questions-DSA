package Binary_Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level_Order_Traversal {
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

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            List<List<Integer>> wrapList = new LinkedList<>();

            if (root == null)
                return wrapList;

            queue.offer(root);

            while (!queue.isEmpty()) {
                int sz = queue.size();
                List<Integer> subArray = new LinkedList<>();
                for (int i = 0; i < sz; i++) {
                    if (queue.peek().left != null)
                        queue.offer(queue.peek().left);

                    if (queue.peek().right != null)
                        queue.offer(queue.peek().right);

                    subArray.add(queue.poll().val);
                }
                wrapList.add(subArray);
            }

            return wrapList;
        }
    }
}
