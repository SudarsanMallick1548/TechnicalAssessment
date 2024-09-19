package com.sudarsan.binarytree;

/**
 * @Sudarsan Mallick BinaryTree Class:- Class to represent the binary tree.
 */
public class BinaryTree {
	TreeNode root;

	public BinaryTree() {
		root = null;
	}

	/**
	 * Method to find the maximum value in the binary tree
	 * 
	 * @param node
	 * @return findMax(TreeNode node): Recursively traverses the binary tree,
	 *         comparing values at each node, and returns the maximum value.
	 */
	public int findMax(TreeNode node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		// Find the maximum in the left and right subtrees
		int leftMax = findMax(node.left);
		int rightMax = findMax(node.right);

		// Return the maximum among node's value, leftMax, and rightMax
		return Math.max(node.value, Math.max(leftMax, rightMax));
	}

	/**
	 * Method to calculate the depth of the binary tree
	 * 
	 * @param node
	 * @return calculateDepth(TreeNode node): Recursively calculates the depth of
	 *         both subtrees and returns the maximum of the two plus one to account
	 *         for the current node.
	 */
	public int calculateDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}

		// Calculate the depth of the left and right subtrees
		int leftDepth = calculateDepth(node.left);
		int rightDepth = calculateDepth(node.right);

		// Return the greater of the two depths plus one for the current node
		return Math.max(leftDepth, rightDepth) + 1;
	}

	/** Helper method to get the maximum value of the tree
	 * 
	 * @return
	 * Helper method findMax() is provided to invoke these functionalities starting from the root node.
	 */
	public int findMax() {
		return findMax(root);
	}

	/**
	 * Helper method to get the depth of the tree
	 * 
	 * @return Helper method getDepth() are provided to invoke these functionalities
	 *         starting from the root node.
	 */
	public int getDepth() {
		return calculateDepth(root);
	}
}
