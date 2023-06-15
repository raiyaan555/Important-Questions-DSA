package Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Level_Sum_of_Binary_Tree {
     public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int ans = Integer.MIN_VALUE;
        int maxLevel = 1;
        int level = 1;

            if (root == null)
                return ans;

            queue.add(root);

            while (!queue.isEmpty()) {
                int sz = queue.size();
                int sum = 0;
                for (int i = 0; i < sz; i++) {
                    if (queue.peek().left != null)
                        queue.offer(queue.peek().left);

                    if (queue.peek().right != null)
                        queue.offer(queue.peek().right);

                    sum+=queue.poll().val;
                }
               if(sum>ans){
                   ans = sum;
                   maxLevel = level;
               }
               level++;
            }
            return maxLevel;
        }
}
