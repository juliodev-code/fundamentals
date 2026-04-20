package org.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLinkedlist {

    static class BinaryNode {
        public String value;
        public BinaryNode left;
        public BinaryNode right;
        public int height;
    }

    BinaryNode root;

    public BinaryTreeLinkedlist(){
        this.root = null;
    }

    public void preOrder(BinaryNode node){
        if(node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderTraversal(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode node = root;

        while (node != null || !stack.isEmpty()) {

            // Traverse to the leftmost node
            while (node != null) {
                System.out.print(node.value + " ");
                stack.push(node);
                node = node.left;
            }

            // Process node
            node = stack.pop();
            node = node.right;
        }
    }

    public void preOrderTraversal_v2(BinaryNode root) {
        if(root == null) return;
        Stack<BinaryNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            BinaryNode node = stack.pop();
            System.out.print(node.value + " ");
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
    }

    public void inOrder(BinaryNode node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void inOrderTraversal(BinaryNode root) {
        Stack<BinaryNode> stack = new Stack<>();
        BinaryNode node = root;

        while (node != null || !stack.isEmpty()) {

            // Traverse to the leftmost node
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            // Process node
            node = stack.pop();
            System.out.print(node.value + " ");

            // Move to right subtree
            node = node.right;
        }
    }

    public void postOrder(BinaryNode node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public void postOrderTraversal(BinaryNode root) {
        Stack<BinaryNode>stack1 = new Stack<BinaryNode>();
        Stack<BinaryNode>stack2 = new Stack<BinaryNode>();

        if(root != null) stack1.push(root);

        while(!stack1.isEmpty()){
            BinaryNode node = stack1.pop();
            stack2.push(node);

            if(node.left != null) stack1.push(node.left);
            if(node.right != null) stack1.push(node.right);
        }

        while(!stack2.isEmpty()){
            BinaryNode node = stack2.pop();
            System.out.print(node.value + " ");
        }

    }

    public void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode removedNode = queue.remove();
            System.out.print(removedNode.value + " ");
            if(removedNode.left != null){
                queue.add(removedNode.left);
            }
            if(removedNode.right != null){
                queue.add(removedNode.right);
            }
        }
    }

    public void search(String value){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.value.equals(value)){
                System.out.println("The value " + value + "was found in tree");
                return;
            }
            else{
                if(presentNode.left != null){
                    queue.add(presentNode.left);
                }
                if(presentNode.right != null){
                    queue.add(presentNode.right);
                }
            }
        }
        System.out.println("The value " + value + "was not found in tree");
    }

    public void insert(String value){
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;
        if(root == null){
            root = newNode;
            System.out.println("Node inserted in root position");
            return;
        }
        Queue<BinaryNode>queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.left == null){
                presentNode.left = newNode;
                System.out.println("Successfully inserted in left side");
                break;
            }
            else if(presentNode.right == null){
                presentNode.right = newNode;
                System.out.println("Successfully inserted in right side");
                break;
            }
            else{
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    public BinaryNode getDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode currentNode = null;
        while(!queue.isEmpty()){
            currentNode = queue.remove();
            if(currentNode.left != null) queue.add(currentNode.left);
            if(currentNode.right != null) queue.add(currentNode.right);
        }

        return currentNode;
    }

    public void deleteNode(String value){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryNode currentNode = queue.remove();
            if(currentNode.value == value){
                currentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("The node was deleted");
                return;
            }
            else {
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
        }

        System.out.println("The value does not exist in BT");
    }

    public void deleteDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode previousNode, currentNode = null;
        while(!queue.isEmpty()){
            previousNode = currentNode;
            currentNode = queue.remove();

            if(currentNode.left == null){
                previousNode.right = null;
                return;
            }
            else if(currentNode.right == null){
                currentNode.left = null;
                return;
            }

            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }
    }

    void deleteBT() {
        root = null;
        System.out.println("BT has been successfully deleted!");
    }

    static void main() {
        BinaryTreeLinkedlist binaryTree = new BinaryTreeLinkedlist();
        binaryTree.insert("N1");
        binaryTree.insert("N2");
        binaryTree.insert("N3");
        binaryTree.insert("N4");
        binaryTree.insert("N5");
        binaryTree.insert("N6");
        //binaryTree.insert("N7");
        //binaryTree.insert("N8");
        //System.out.println("In order:");
        binaryTree.postOrder(binaryTree.root);
        System.out.println();
        //System.out.println("In order transversal:");
        binaryTree.postOrderTraversal(binaryTree.root);
        //binaryTree.deleteDeepestNode();
        //binaryTree.deleteNode("N3");
        //System.out.println();
        //binaryTree.levelOrder();
        //System.out.println("Value:" + binaryTree.getDeepestNode().value);
    }


}
