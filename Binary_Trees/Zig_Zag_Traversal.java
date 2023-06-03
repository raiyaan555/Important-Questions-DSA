package Binary_Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Zig_Zag_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean flag = true;

        if(root==null){
            return ans;
        }
        q.add(root);

        while(!q.isEmpty()){
            int sz = q.size();
            List<Integer> subArr = new ArrayList<>();
            for(int i = 0; i<sz;i++){
                if (q.peek().left != null) q.add(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                if (flag == true) subArr.add(q.poll().val);
                else subArr.add(0, q.poll().val);
            }
            flag = !flag;
            ans.add(subArr);
        }
        return ans;
        
    }
}
