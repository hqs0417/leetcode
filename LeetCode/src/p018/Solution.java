package p018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * 未做除去重复
 */
public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums.length <4){
			return result;
		}
		//sort
		Arrays.sort(nums);
		//choose two numbers, then choose another two from the rest
		//two pointers
		HashSet<String> unique = new HashSet<String>();
		int n = nums.length;
		for(int a = 0; a < n - 3; a++) {
			for(int b = a + 1; b < n - 2; b++) {
				int c = b + 1;
				int d = n - 1;
				while(c < d) {
					if(nums[a] + nums[b] + nums[c] + nums[d] < target) {
						++c;
					} else if(nums[a] + nums[b] + nums[c] + nums[d] > target) {
						--d;
					} else {
						String str = nums[a] + nums[b] + nums[c] + nums[d] + "";
						if(!unique.contains(str)) {
							List<Integer> quadruplet = new ArrayList<Integer>();
							quadruplet.add(nums[a]);
							quadruplet.add(nums[b]);
							quadruplet.add(nums[c]);
							quadruplet.add(nums[d]);
							result.add(quadruplet);
							unique.add(str);
						}
						c++;
						d--;
					}
				}
			}
		}
		
		return result;
    }
	
	
	public static void main(String[] args) {
		
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		Solution solution = new Solution();
		System.out.println(solution.fourSum(nums, target));
	}
}
