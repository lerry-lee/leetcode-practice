package DailyExercises._20年9月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lerrylee
 * @version 1.0.0
 * @className _40组合总和2
 * @date 上午11:04 20-9-10
 * @description 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 **/
public class _40组合总和2 {

    /**
     * 解法1：排序+dfs+剪枝
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        dfs(res, new ArrayList<Integer>(), target, candidates, candidates.length, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> comb, int target, int[] candidates, int n, int t) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = t; i < n; i++) {
            if (target - candidates[i] < 0) return;
            if (i != t && candidates[i] == candidates[i - 1]) continue;
            comb.add(candidates[i]);
            dfs(res, comb, target - candidates[i], candidates, n, i + 1);
            comb.remove(comb.size() - 1);
        }
    }

}
