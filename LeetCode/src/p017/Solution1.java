package p017;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public static final String[] keyboard ={" ", "","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		for(int i = 0; i < digits.length(); i++) {
			String key = keyboard[digits.charAt(i) - '0'];
			
		}
		
		
		return result;
		
	}
}
