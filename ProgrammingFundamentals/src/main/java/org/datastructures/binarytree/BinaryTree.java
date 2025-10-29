package org.datastructures.binarytree;

public class BinaryTree {

     private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;
    public BinaryTree(int data){
        root = new Node(data);
    }

    //Transversal methods

    //LEFT -> ROOT -> RIGHT
    public void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void preOrder(Node node){
        if(node == null) return;
        System.out.print(node.data + " ");
        inOrder(node.left);
        inOrder(node.right);
    }

    public void postOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        inOrder(node.right);
        System.out.print(node.data + " ");
    }

    static void main() {
        BinaryTree tree = new BinaryTree(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(20);

        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(7);

        tree.root.right.right = new Node(30);


        System.out.print("InOrder: ");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.print("preorder: ");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.print("postorder: ");
        tree.postOrder(tree.root);
        System.out.println();

    }
}
