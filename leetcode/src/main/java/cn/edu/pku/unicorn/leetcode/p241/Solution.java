package cn.edu.pku.unicorn.leetcode.p241;

import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by v_zhengkun on 2016/4/3.
 * Different Ways to Add Parentheses
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        int val = 0, idx = 0;
        while (idx < input.length() && Character.isDigit(input.charAt(idx))) {
            val *= 10;
            val += input.charAt(idx++) - '0';
        }
        if (idx == input.length()) {
            res.add(val);
            return res;
        }

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        res.add(compute(left.get(j), right.get(k), input.charAt(i)));
                    }
                }
            }
        }
        return res;
    }

    private int compute(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return 0;
    }
}
