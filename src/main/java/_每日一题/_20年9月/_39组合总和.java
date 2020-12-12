package _每日一题._20年9月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lerrylee
 * @version 1.0.0
 * @className _39组合总和
 * @date 下午2:25 20-9-9
 * @description 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 **/
public class _39组合总和 {
    /**
     * 解法1：dfs+剪枝
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(new ArrayList<Integer>(), candidates, target, candidates.length, 0);
        return res;
    }

    public void dfs(List<Integer> temp, int[] candidates, int target, int n, int t) {
        if (target < 0) return;
        if (target == 0) {
            if (!res.contains(temp)) res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = t; i < n; i++) {
            if (target - candidates[i] < 0) return;
            temp.add(candidates[i]);
            dfs(temp, candidates, target - candidates[i], n, i);
            temp.remove(temp.size() - 1);
        }
    }
}
