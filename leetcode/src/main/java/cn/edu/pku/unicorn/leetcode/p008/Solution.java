package cn.edu.pku.unicorn.leetcode.p008;




public class Solution {	
	public static void main(String[] args) {
		System.out.println(myAtoi("21342134fd"));
	}
	public static int myAtoi(String s) {
		int i = 0;
		boolean sign = true;//符号
		int num = 0;//为当前字符转换为的数字值
		long sum = 0;//结果
		boolean flag = false;//表示是否出现过符号或者数字，即有效字符
		if (s.length() == 0)
			return 0;
		while (i < s.length()) {
			if (s.charAt(i) == '+' && !flag) {
				sign = true;//将符号设置为正
				flag = true;//表示已经出现有效字符
			} else if (s.charAt(i) == '-' && !flag) {
				sign = false;//将符号设置为负
				flag = true;//已经出现有效字符
			} else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {//出现数字
				num = s.charAt(i) - '0';//计算值
				flag = true;
			} else if (s.charAt(i) == ' ' && !flag) {//没有出现有效字符的情况下出现空格，则跳过
				;
			} else //其他情况终止处理
				break;

			i++;
			sum = sum * 10 + num;
			if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
				return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		}
		return sign ? (int) sum : (int) -sum;
	}
}
