package cn.edu.pku.unicorn.leetcode.p231;



public class Solution {
	
	/**
	 * 统计该数的二进制表示中有多少个1
	 * 如果只有1个1
	 * 则说明该数字是2的次方
	 * @author Unicorn
	 *
	 */
	public boolean isPowerOfTwo(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n & 0x01;
			n >>= 1;
		}
        return sum == 1;
    }
	
	/**
	 * 所有2的次方的数字二进制形式为1000...000
	 * 减一后变为0111...111
	 * 两者相与为0
	 * @param n
	 * @return
	 */
	public boolean isPowerofTwo1(int n) {
		return (n > 0) && (n & (n-1)) == 0;
	}
	public static void main(String[] args) {
		
	}
}
