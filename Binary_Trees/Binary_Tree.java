package Binary_Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Binary_Tree {

    static Scanner sc = new Scanner(System.in);

    static Node createTree() {

        Node root = null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        root = new Node(data);

        System.out.println("Enter left for " + data);
        root.left = createTree();

        System.out.println("Enter right for " + data);
        root.right = createTree();

        return root;

    }

    // recursive approach to solve inOrder time complexity is going to O(N) and space will be O(N)

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //  recursive approach to solve Preorder time complexity is again O(N) and spce will be O(N)

    static void PreOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        inOrder(root.left);
        inOrder(root.right);
    }

    // recursive approach to solve Postorder time complexity is again O(N) and spce will be O(N)

    static void PostOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        inOrder(root.right);
        System.out.print(root.data + " ");

    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }

        return size(root.left) + size(root.right) + 1;
    }

    public static int maxValue(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(maxValue(root.left), maxValue(root.right)));
    }

    public static int minValue(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        return Math.min(root.data, Math.min(minValue(root.left), minValue(root.right)));
    }

    static void printLevelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr == null) {
                if (q.isEmpty()) {
                    return;
                }
                q.add(null);
                System.out.println();
                continue;
            }

            System.out.print(curr.data);

            if (curr.left != null) {
                q.add(curr.left);
            }

            if (curr.right != null) {
                q.add(curr.right);
            }

        }

    }

    static void printLeftViewUntil(Node root, ArrayList<Node> list, int level) {
        if (root == null) {
            return;
        }

        if (list.get(level) == null) {
            list.set(level, root);
        }

        printLeftViewUntil(root.left, list, level + 1);
        printLeftViewUntil(root.right, list, level + 1);

    }

    public static void leftView(Node root) {
        ArrayList<Node> list = new ArrayList<>();

        printLeftViewUntil(root, list, 0);

        for (Node curr : list) {
            System.out.print(curr.data + " ");
        }
    }

    public static ArrayList<Integer> topView(Node root) {
        Queue<Pair> q = new ArrayDeque<>();

        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            if (!map.containsKey(curr.ind)) {
                map.put(curr.ind, curr.root.data);
            }

            if (curr.root.left != null) {
                q.add(new Pair(curr.ind - 1, curr.root.left));
            }

            if (curr.root.right != null) {
                q.add(new Pair(curr.ind + 1, curr.root.right));
            }

        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            ans.add(entry.getValue());

        return ans;

    }

    public static ArrayList<Integer> bottomView(Node root) {
        Queue<Pair> q = new ArrayDeque<>();

        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(0, root));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            map.put(curr.ind, curr.root.data);

            if (curr.root.left != null) {
                q.add(new Pair(curr.ind - 1, curr.root.left));
            }

            if (curr.root.right != null) {
                q.add(new Pair(curr.ind + 1, curr.root.right));
            }

        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            ans.add(entry.getValue());

        return ans;

    }

    Node prev = null, head = null;

    void convertToDLL(Node root) {
        if (root == null) {
            return;
        }
        convertToDLL(root.left);
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;
        convertToDLL(root.right);

    }

    static int diameter(Node root) {
        if (root == null) {
            return 0;
        }

        int dleft = diameter(root.left);
        int dright = diameter(root.right);

        int curr = height(root.left) + height(root.right) + 1;

        return Math.max(curr, Math.max(dleft, dright));

    }

    static int ans = 0;

    static int heightmodifiedDiameter(Node root) {
        if (root == null) {
            return 0;
        }
        ans = Math.max(ans, 1 + height(root.left) + height(root.right));

        return Math.max(height(root.left), height(root.right)) + 1;

    }

    // lowest common ancestor

    Node lowestCommonAncestor(Node root, int n1, int n2) {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;

        Node left = lowestCommonAncestor(root.left, n1, n2);
        Node right = lowestCommonAncestor(root.right, n1, n2);

        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }

    // BST

    boolean search(Node root, int x) {
        if (root == null) {
            return false;
        }
        if (root.data == x) {
            return true;
        }

        if (root.data > x) {
            return search(root.left, x);
        }
        return search(root.right, x);

    }

    // insert the values in a bst

    Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (root.data > key) {
            root.left = insert(root.left, key);
        } else if (root.data < key) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    Node insertIteratively(Nood root, int key) {
        Node newNode = new Node(key);
        Node curr = root;
        Node parent = null;

        while (curr != null) {
            parent = curr;

            if (key < curr.data) {
                curr = curr.left;
            }

            else
                curr = curr.right;
        }

        if (parent == null) {
            parent = newNode;
        }

        else if (key < parent.data)
            parent.left = newNode;

        else
            parent.right = newNode;

        return root;
    }

    // deletion

    public static Node deleteNode(Node root, int key){
        if(root==null){
            return root;
        }

        if(key<root.data){
            root.left = deleteNode(root.left, key);
        }else if(key>root.data){
            root.right = deleteNode(root.right, key)
        }else{
            if(root.left ==null)
            return  root.right;

            else if(root.right==null)
            return root.left;


            root.data = minValue(root.right);

            root.right = deleteNode(root.right, root.data);

        }

        return root;
    }

    public static void main(String[] args) {

        Node root = createTree();
        inOrder(root);
        System.out.println();
        PreOrder(root);
        System.out.println();
        PostOrder(root);
        System.out.println();
        System.out.println(height(root));

        System.out.println(size(root));

        printLevelOrder(root);
        printLeftViewUntil(root, null, 0);

    }

    // check for bst

    boolean isBST(Node root) {
        return isBSTUntil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    boolean isBSTUntil(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data < min || node.data > max) {
            return false;
        }

        return (isBSTUntil(node.left, min, node.data-1)) 
        && 
        isBSTUntil(node.right, node.data+1, max);
    }


    boolean isBSTinOrder(Node node){
        if(node!=null){
            if(!isBST(node.left)){
                return false;
            }

            if(prev != null && node.data <=prev.data){
                return false;
            }

            prev = node;

            return isBST(node.right);
        }
        return true;
    }

    // floor

    int findFloor(Node root, int key){
        int ans = Integer.MAX_VALUE;

        while(root!=null){
            if(root.data==key){
                return root.data;
            }

            if(root.data >key){
                root = root.left;
            }else{
                ans=root.data;
                root = root.right;
            }
        }

        return ans;

    }

    // ceil

    int findCeil(Node root, int key){
        int ans = Integer.MIN_VALUE;

        while(root!=null){
            if(root.data==key){
                return root.data;
            }

            if(root.data>key){
                ans = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ans;
    }



    // Two sum in bst

    int isPairPresent(Node root, int target){
        Set<Integer> set = new HashSet<>();

        boolean ans =  util(root, target, set);

        return ans ? 1:0;

        
    }

    public boolean util(Node root, int sum, Set<Integer> set){
        if(root ==null){
            return false;
        }

        if(util(root.left, sum, set)==true){
            return true;
        }

        if(set.contains(sum-root.data)){
            return true;
        }
        set.add(root.data);

        return util(root.right, sum,set);
    }

}

// print vertically 


static ArrayList <Integer> verticalOrder(Node root){
    Queue<Pair> q = new ArrayDeque<>();

    Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

    q.add(new Pair(0, root));

    while(!q.isEmpty()){
        Pair curr = q.poll();

        if(map.containsKey(curr.ind)){
            map.get(curr.ind).add(curr.root.data);
        }else{

            
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(curr.root.data);
            map.put(curr.ind, temp);
        }

        if(curr.root.left !=null){
            q.add(new Pair(curr.ind-1, curr.root.left));
        }

        if(curr.root.right!=null){
            q.add(new Pair(curr.ind+1, curr.root.right));
        }
    }

    ArrayList<Integer> ans = new ArrayList<>();
    for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet())
    {
        ans.addAll(entry.getValue());
    }
    return ans;
}


class Node {
    Node left;
    Node right;

    int data;

    Node(int data) {
        this.data = data;
    }
}
