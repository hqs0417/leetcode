package cn.edu.pku.unicorn.leetcode.p089;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by v_zhengkun on 2016/3/29.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.grayCode(0));
        System.out.println(solution.grayCode(1));
    }
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        int count = (int) Math.pow(2, n);
        for (int i = 0; i < count; i++) {
            list.add((i) ^ (i >> 1));
        }
        return list;
    }
}
