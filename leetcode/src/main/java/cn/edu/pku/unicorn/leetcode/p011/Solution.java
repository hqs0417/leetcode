package cn.edu.pku.unicorn.leetcode.p011;

/**
 * 左右双指针
 * @author Unicorn
 *
 */
public class Solution {
	public int maxArea(int[] height) {
		int i = 0, j = height.length - 1;
		int maxArea = 0;
		while( i < j ) {
			maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
			if(height[i] > height[j]) {
				j--;
			} else {
				i++;
			}
		}
		
		return maxArea;
	}
	public static void main(String[] args) {
		
	}
}
