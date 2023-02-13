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

        System.out.println("Enter left for" + data);
        root.left = createTree();


        System.out.println("Enter right for" + data);
        root.right = createTree();




        return root;

    }
    public static void main(String[] args) {

        System.out.println(createTree());

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
