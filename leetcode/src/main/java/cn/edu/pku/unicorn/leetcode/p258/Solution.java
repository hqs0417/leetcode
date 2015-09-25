package cn.edu.pku.unicorn.leetcode.p258;

/**
 * Created by unicorn on 15-9-25.
 */
public class Solution {

    /**
     * 正常思路，逐次进行计算，时间复杂度为O(n)
     * @param num
     * @return
     */
    public int addDigits(int num) {
        while(num >= 10) {
            int sum = 0;
            while(num > 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }

    /**
     * 找到规律，结果每隔9个数字会重复<br/>
     * 时间复杂度为O(1)
     * @param num
     * @return
     */
    public int addDigits1(int num){
        if(num < 10) {
            return num;
        }
        return (num - 10) % 9 + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addDigits1(37));
    }
}