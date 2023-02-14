package Binary_Trees;

import java.util.Scanner;

public class Binary_Tree {

    static Scanner sc = new Scanner(System.in);
    
    static Node createTree(){


        Node root = null;
        System.out.println("Enter data: ");
        int data  =sc.nextInt();


        if(data==-1){
            return null;
        }

        root = new Node(data);

        System.out.println("Enter left for " + data);
        root.left = createTree();


        System.out.println("Enter right for " + data);
        root.right = createTree();




        return root;

    }

    static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    static void PreOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        inOrder(root.left);
        inOrder(root.right);
    }

    static void PostOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        inOrder(root.right);
        System.out.print(root.data+" ");
        
    }

    public static int height(Node root){
        if(root==null){
            return 0;
        }

        return Math.max(height(root.left),height(root.right))+1;
    }


    public static int size(Node root){
        if(root==null){
            return 0;
        }

        return size(root.left)+size(root.right)+1;
    }


    public static int maxValue(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(maxValue(root.left), maxValue(root.right)));
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


    }
}

class Node {
    Node left;
    Node right;

    int data;

    Node(int data) {
        this.data = data;
    }
}
