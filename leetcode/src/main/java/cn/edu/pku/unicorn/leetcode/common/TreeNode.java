package cn.edu.pku.unicorn.leetcode.common;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	{
		left = right = null;
	}
	public TreeNode(int x) {
		this.val = x;
	}
	public TreeNode(int x, TreeNode left,TreeNode right) {
		this.val = x;
		this.left = left;
		this.right = right;
	}
	
}
