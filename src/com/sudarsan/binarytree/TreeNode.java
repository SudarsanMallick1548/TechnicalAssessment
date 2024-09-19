package com.sudarsan.binarytree;
/** @Sudarsan Mallick 
  TreeNode Class:- Represents each node in the tree with a value and two child pointers (left and right).
 */
public class TreeNode {
	int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
