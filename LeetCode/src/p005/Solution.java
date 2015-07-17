package p005;


public class Solution {
	public static void main(String[] args) {
		String s = "aaaa";
		//System.out.println(isPalindrome(s));
		System.out.println(longestPalindrome2(s));
	}
	
	/**
	 * 暴力求解
	 * 测试所有的字串
	 * 找出最大的回文字串
	 * O(n^3)
	 * @param s
	 * @return
	 */
	public static String longestPalindrome1(String s) {
		String str = s.charAt(0) + "";
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j < s.length(); j++) {
				String sub = s.substring(i, j + 1);
				if(isPalindrome(sub) && sub.length() > str.length()) {
					str = sub;
				}
			}
		}
		return str;
	}
	
	/**
	 * 动态规划
	 * P[i, j] = true 当P[i+1， j -1]==true且P[i]==P[j] <br/>
	 * 时间复杂度O(n^2) <br/>
	 * 空间复杂度O(N^2) <br/>
	 * @param s1 <br/>
	 * @return
	 */
	public static String longestPalindrome2(String s) {
		int m = 0, n = 0;
		boolean [][]P = new boolean[s.length()][s.length()];
		for(int i = 0; i < s.length(); i++) {//初始化，将长度为1和2的字串全部进行测试
			P[i][i] = true;
			if(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
				P[i][i+1] = true;
				m = i;
				n = i + 1;
			}
		}
		
		for(int len = 2; len <= s.length(); len++) {//字串长度
			for(int start = 0; start <= s.length() - len; start ++ ){//字串起始位置
				int end = start + len - 1;//结束位置
				if(s.charAt(start) != s.charAt(end)) {
					P[start][end] = false;
 				} else if(P[start + 1][end-1]) {
					P[start][end] = true;
					if(end - start > n - m) {//保存最长的字串的位置
						m = start;
						n = end;
					}
				}
			}
		}
		
		return s.substring(m, n + 1);
	}
	
	
	/**
	 * <b>中心扩展法</b> <br/>
	 * 从每个字符的中间开始，向两边扩展，找到以当前字符为中心的最长字串<br/>
	 * 注意两种情况 aba  abba <br/>
	 * 找出最大的 <br/>
	 * 时间复杂度O(n^2) <br/>
	 * @param s
	 * @return
	 */
	public static String longestPalindrome3(String s) {
		int m = 0, n = 0;
		//只处理aba
		
		
		//只处理abba
		return null;
	}
	
	/**
	 * Manacher 方法
	 * 只能解决aba类型
	 * 为了解决abba类型，向字符串中添加特殊字符，如'#',字符串变为a#b#b#a
	 * @param s
	 * @return
	 */
	public static String longestPalindrom4(String s) {
		
		return null;
	}
	/**
	 * 工具方法
	 * 判断一个字符串是否是回文串
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		int start  = 0, end = s.length() - 1;
		while(start <= end) {
			if(s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}
}	
