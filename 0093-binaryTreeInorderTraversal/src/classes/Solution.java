package classes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	
	/*
	 * An inorder traversal first visits the left child (including its entire subtree), 
	 * then visits the node, and finally visits the right child (including its entire subtree). 
	 * The binary search tree makes use of this traversal to print all nodes in ascending order of value.
	 */
	
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
    	return list;
    }
}