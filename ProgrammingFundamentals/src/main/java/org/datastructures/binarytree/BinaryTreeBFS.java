package org.datastructures.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeBFS {
    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // 1. Identify how many nodes are on the current level
            int levelSize = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>();
            // 2. Iterate ONLY through nodes belonging to this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelNodes.add(currentNode.val);
                // 3. Add children to the queue for the NEXT level
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // 4. Add the finished level to our result
            result.add(currentLevelNodes);
        }

        return result;
    }

    public static void main(String[] args) {
        // 1. Create the nodes
        // Structure:
        //      1
        //     / \
        //    2   3
        //   / \   \
        //  4   5   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // 2. Initialize the solver
        BinaryTreeBFS solver = new BinaryTreeBFS();

        // 3. Execute the BFS
        List<List<Integer>> result = solver.levelOrder(root);

        // 4. Print the levels
        System.out.println("Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
