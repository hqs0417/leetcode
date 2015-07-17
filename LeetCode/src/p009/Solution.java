package p009;

public class Solution {
    public boolean isPalindrome(int x) {
    	if(x < 0) {
    		return false;
    	}
    	
    	int d = 1;//divisor
    	while(x / d >= 10) {
    		d *= 10;
    	}
    	int l, r ;
    	while(x > 9) {
    		l = x / d;
    		x = x % d;
    		r = x % 10;
    		if(l != r) {
    			return false;
    		}
    		x /= 10;
    		d /= 100;
    	}
    	return true;
    }
    
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome(1000021));
	}
}
