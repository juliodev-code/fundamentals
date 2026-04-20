package org.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class BasicTree {

    static class TreeNode{
        String data;
        List<TreeNode> children;

        public TreeNode(String data){
            this.data = data;
            this.children = new ArrayList<TreeNode>();
        }

        public void addChild(TreeNode node){
            this.children.add(node);
        }

        public String print(int level){
            String ret;
            ret = "  ".repeat(level) + data + "\n";
            for(TreeNode node : this.children){
                ret += node.print(level + 1);
            }
            return ret;
        }

    }

    static void main() {
        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hot = new TreeNode("Hot");
        TreeNode cold = new TreeNode("Cold");
        TreeNode tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");
        TreeNode wine = new TreeNode("Wine");
        TreeNode beer = new TreeNode("Beer");

        drinks.addChild(hot);
        drinks.addChild(cold);

        hot.addChild(tea);
        hot.addChild(coffee);

        cold.addChild(wine);
        cold.addChild(beer);

        System.out.println(drinks.print(0));
    }
}
