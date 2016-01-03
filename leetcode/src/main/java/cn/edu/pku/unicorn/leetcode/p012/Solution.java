package cn.edu.pku.unicorn.leetcode.p012;

/**
 * Integer to Roman
 * 整数转换为罗马数字
 * I  II III IV V VI VII VIII IX X
 * XI XII XIII XIV XV
 * 1 	4	5	9	10	40	50	90	100	400	500	900	1000
 * I	IV	V	IX	X	XL	L	LC	C	CD	D	CM	M
 * 罗马数字的计算是所有位相加
 *
 * @author Unicorn
 */
public class Solution {

    public String intToRoman(int num) {
        final int[] radix = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder romanSb = new StringBuilder();
        for (int i = 0; num > 0; i++) {
            int count = num / radix[i];//出去基数所得整数
            num = num % radix[i];
            for (; count > 0; count--) {
                romanSb.append(symbol[i]);
            }
        }
        return romanSb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(4999));
    }
}
