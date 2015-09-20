package cn.edu.pku.unicorn.leetcode.p201;

/**
 * [m, n]范围的按位与的结果为m和n的公共“左边首部”
 * bin	dec
 * 101	5
 * 110	6
 * 111	7
 * --------
 * 100	4
 * 
 * @author Unicorn
 *
 */
public class Solution {
	public int rangeBitwiseAnd(int m, int n) {
		int p = 0;
		while( m != n) {
			m >>= 1;
			n >>= 1;
			p++;
		}
		return m << p;
    }
	
	public static void main(String[] args) {
		//System.out.println(Integer.MAX_VALUE);
		Solution solution = new Solution();
		System.out.println(solution.rangeBitwiseAnd(0, Integer.MAX_VALUE));
		
	}
}
