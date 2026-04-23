package org.datastructures.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    static class BinaryNode {
        public int value;
        public int height;
        public BinaryNode left;
        public BinaryNode right;
    }

    BinaryNode root;

    //Creation of binary tree = O(1)
    BinarySearchTree(){
        this.root = null;
    }

    //insert a node in binary search
    private BinaryNode insert(BinaryNode currentNode, int value){//O(LOG N)
        if(currentNode == null){
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            System.out.println("New Node inserted successfully");
            return newNode;
        } else if(value <= currentNode.value){//O(N/2)
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {//O(N/2)
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }
    void insert(int value){
        root = insert(root, value);
    }

    public void preOrder(BinaryNode node){
        if(node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(BinaryNode node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder(BinaryNode node){
        if(node == null) return;
        inOrder(node.left);
        inOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void levelOrder(BinaryNode root){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryNode currentNode = queue.remove();
            System.out.print(currentNode.value + " ");
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }

            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
    }

    public BinaryNode search(BinaryNode node, int value){
        if(node == null) {
            System.out.println("Value not found in the BT");
            return null;
        }
        else if(node.value == value){
            System.out.println("Value " + value + " found in the BT");
            return node;
        }
        else if(node.value < value) return search(node.left, value);
        else return search(node.right, value);
    }

    private BinaryNode minimumNode(BinaryNode root){
        if(root.left == null){
            return root;
        }else{
            return minimumNode(root.left);
        }
    }

    public BinaryNode deleteNode(BinaryNode root, int value){
        if(root == null){
            System.out.println("Value not found for delete");
            return null;
        }

        if(value < root.value){
            root.left = deleteNode(root.left, value);
        }
        else if(value > root.value){
            root.right = deleteNode(root.right, value);
        }
        else {
            if(root.left != null && root.right != null){
                //BinaryNode tempNode = root;
                BinaryNode minNodeForRight = minimumNode(root.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value);
            }
            else if(root.left != null){
                root = root.left;
            }
            else if(root.right != null){
                root = root.right;
            }
            else {
                root = null;
            }
        }
        return root;
    }

    public void deleteBST(){
        this.root = null;
        System.out.println("BST deleted successfully");
    }

    static void main() {
        BinarySearchTree newBST = new BinarySearchTree();
        newBST.insert(70);
        newBST.insert(50);
        newBST.insert(90);
        newBST.insert(30);
        newBST.insert(60);
        newBST.insert(80);
        newBST.insert(100);
        newBST.insert(20);
        newBST.insert(40);


        newBST.preOrder(newBST.root);
        System.out.println();
        newBST.inOrder(newBST.root);
        System.out.println();
        newBST.postOrder(newBST.root);
        System.out.println();
        newBST.levelOrder(newBST.root);
        System.out.println();
        newBST.search(newBST.root, 45);
        System.out.println();
        newBST.deleteNode(newBST.root, 40);
        System.out.println();
        newBST.levelOrder(newBST.root);
        newBST.deleteBST();
    }
}
