package Binary_Trees.Binary_Search_Trees;

public class Largest_BST_in_BT {

    class TreeNode<Integer> {
	    public int data;
	    public TreeNode<Integer> left;
	    public TreeNode<Integer> right;

	    TreeNode(int data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}

    class NodeValue{
	int max, min, maxSize;


	NodeValue(int min, int max, int maxSize){
		this.max = max;
		this.min = min;
		this.maxSize = maxSize;
	}
}

	static NodeValue largestBSTHelper(TreeNode root){
		if(root==null){
			return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		NodeValue left = largestBSTHelper(root.left);
		NodeValue right = largestBSTHelper(root.right);

		if(left.max < root.data && right.min > root.data){
			return new NodeValue(Math.min(root.data,left.min), Math.max(root.data, right.max),left.maxSize+right.maxSize+1);
		}

		return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
	}
	public static int largestBST(TreeNode<Integer> root) {
		// Write your code here.
		return largestBSTHelper(root).maxSize;
	}
}
}
}



