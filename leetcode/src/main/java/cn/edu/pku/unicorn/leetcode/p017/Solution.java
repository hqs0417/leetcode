package p017;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归求解
 * @author Unicorn
 *
 */
class Solution{
	public static final String[] keyboard ={" ", "","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public List<String> letterCombinations(String digits) {
		
		List<String> result = new ArrayList<String>();
		if(digits == null || digits.length() == 0 ) {
			return result;
		}
		letterCombinationCore(digits, 0, "", result);
		
		return result;
		
    }
	
	/**
	 * 
	 * @param digits 输入的手机键盘数字字符串
	 * @param curr 当前处理的键盘数字的下标
	 * @param path 
	 * @param result 结果
	 */
	public void letterCombinationCore(String digits, int curr, String path, List<String> result) {
		if(curr == digits.length()) {
			result.add(path);
			return;
		}
		String key = keyboard[digits.charAt(curr) - '0'];
		for(int i = 0; i < key.length(); i++) {
			letterCombinationCore(digits, curr + 1, path + key.charAt(i), result);
		}
	}
	
	public static void main(String[] args) {
		String digits = "234678";
		Solution solution = new Solution();
		System.out.println(solution.letterCombinations(digits));
	}
}