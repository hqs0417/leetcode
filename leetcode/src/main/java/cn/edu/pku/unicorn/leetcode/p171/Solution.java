package cn.edu.pku.unicorn.leetcode.p171;

public class Solution {
    public int titleToNumber(String s) {
        s = s.toUpperCase();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 26 + (s.charAt(i) - 'A' + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        /*
    	for(char c = 'A'; c <= 'Z'; c++){
			System.out.println((int)c);
		}
		*/
        Solution solution = new Solution();

        System.out.println(solution.titleToNumber("AAA"));
    }

}