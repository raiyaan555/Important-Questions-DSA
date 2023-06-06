package Binary_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Max_Width_Binary_Tree {
    class Pair{
        TreeNode node;
        int num;

        Pair(TreeNode n, int a){
            node = n;
            num = a;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans = 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root,0));


        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num;

            int first = 0, last = 0;
            for(int i = 0; i<size;i++){
                int curr_id = q.peek().num-min;
                TreeNode node = q.peek().node;
                q.poll();
                if(i==0) first = curr_id;
                if(i==size-1)last = curr_id;
                if(node.left!=null) q.offer(new Pair(node.left, curr_id*2+1));
                if(node.right!=null)q.offer(new Pair(node.right, curr_id*2+2));

            }
            ans = Math.max(ans, last-first+1);

        }

        return ans;


    }
}
