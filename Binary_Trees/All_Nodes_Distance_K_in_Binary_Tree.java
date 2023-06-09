package Binary_Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class All_Nodes_Distance_K_in_Binary_Tree {
    public void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track, TreeNode target){
        Queue<TreeNode> q  = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                parent_track.put(curr.left, curr);
                q.offer(curr.left);
            }

            if(curr.right!=null){
                parent_track.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parent_track = new HashMap<>();
        markParents(root,parent_track,target);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q  = new LinkedList<TreeNode>();
        q.offer(target);
        visited.put(target,true);
        int curr_level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(curr_level == k) break;
            curr_level++;
            for(int i = 0; i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }

                 if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }

                if(parent_track.get(curr)!=null && visited.get(parent_track.get(curr))==null){
                    q.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr),true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            result.add(curr.val);
        }
        return result;
        
    }
}
