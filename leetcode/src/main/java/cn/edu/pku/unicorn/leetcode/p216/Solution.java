package cn.edu.pku.unicorn.leetcode.p216;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by v_zhengkun on 2016/3/30.
 * 216. Combination Sum III
 * TODO review
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum3(3, 7));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        helper(result, new ArrayList<Integer>(),candidates, n,k,0);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int layer, int startIdx){
        if(layer<0) return;
        if(target>0){
            for(int i=startIdx; i<candidates.length && candidates[i]<=target;i++){
                current.add(candidates[i]);
                helper(result,current,candidates,target-candidates[i],layer-1,i+1);
                current.remove(current.size()-1);
            }
        } else if (target == 0 && layer == 0){
            result.add(new ArrayList<Integer>(current));
        }
    }
}
