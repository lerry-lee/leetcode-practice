package _每日一题._2020年._20年9月;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lerrylee
 * @version 1.0.0
 * @className _216组合总和3
 * @date 上午9:12 20-9-11
 * @description 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 **/
public class _216组合总和3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k < 1 || k > n || k * 9 < n) return res;
        dfs(1, n, k, res, new ArrayList<>());
        return res;
    }

    public void dfs(int t, int target, int k, List<List<Integer>> res, List<Integer> comb) {
        if (k == 0 && target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = t; i <= 9; i++) {
            if (target < i || target < k * i) return;
            comb.add(i);
            dfs(i + 1, target - i, k - 1, res, comb);
            comb.remove(comb.size() - 1);
        }
    }
}
