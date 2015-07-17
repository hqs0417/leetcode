package p020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
        	if(!stack.isEmpty()) {
        		if(map.get(s.charAt(i)) == stack.peek() ) {//
        			stack.pop();
        		} else {
        			stack.push(s.charAt(i));
        		}
        	} else {
        		stack.push(s.charAt(i));
        	}
        	
        }
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isValid("([)]"));
	}
}
