package com.sudarsan.binarytree;
/**
 * @Sudarsan Mallick BinaryTreeMain Class:- Class to represent the binary tree main & example testing scenarios .
 */
public class BinaryTreeMain {
	public static void main(String[] args) {
        // Create the binary tree from the example
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(5);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(10);
        tree.root.left.right = new TreeNode(11);

        // Find the maximum value in the binary tree
        int max = tree.findMax();
        System.out.println("Maximum value in the binary tree: " + max);

        // Calculate the depth of the binary tree
        int depth = tree.getDepth();
        System.out.println("Depth of the binary tree: " + depth);
    }
}
