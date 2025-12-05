package org.datastructures.binarytree;

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
        } else if(currentNode.value <= value){//O(N/2)
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {//O(N/2)
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }
    void insert(int value){
        insert(root, value);
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
    }
}
