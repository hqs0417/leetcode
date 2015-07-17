package p001;

import java.util.Arrays;
import java.util.HashMap;
public class Solution {
	public static void main(String[] args) {
		int [] numbers = {2, 7, 9, 0};
		int []indices = twoSum1(numbers, 9);
		System.out.print(Arrays.toString(indices));
	}
	
	/**
	 * 暴力求解
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] numbers, int target) {
		int [] indices = new int[]{0,0};
		for(int i = 0; i < numbers.length; i++ ) {
			for(int j = i; j < numbers.length; j++) {
				if(numbers[i] + numbers[j] == target) {
					indices[0] = i + 1;
					indices[1] = j + 1;
				}
			}
		}
		
		return indices;
	}
	/**
	 * 使用HashMap
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum1(int[] numbers, int target) {
		int [] indices = new int[]{0,0};
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i);
		}
		for (int i = 0; i < numbers.length; i++) {
			int gap = target - numbers[i];
			if(map.containsKey(gap) && map.get(gap) > i) {
				indices[0] = i + 1;
				indices[1] = map.get(gap) + 1;
			}
		}
		return indices;
	}
	
	/**
	 * 如果数组是有序的可以使用
	 * 使用双指针
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum2(int[] nums, int target) {
		int[] indices = {0, 0};
		int i = 0, j = nums.length - 1;
		while( i < j ) {
			if(nums[i] + nums[j] == target) {
				indices[0] = i;
				indices[1] = j;
				break;
			} else if(nums[i] + nums[j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return indices;
	}
	

}
