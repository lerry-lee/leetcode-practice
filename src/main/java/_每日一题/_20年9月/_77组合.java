package _每日一题._20年9月;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lerrylee
 * @version 1.0.0
 * @className _77组合
 * @date 上午11:34 20-9-8
 * @description 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 **/
public class _77组合 {
    /**
     * 解法1：dfs+剪枝
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combine_list = new ArrayList<>();
        if (n < k) return combine_list;
        List<Integer> temp = new ArrayList<>();
        dfs(combine_list, temp, n, 1, k, 0);
        return combine_list;
    }

    public void dfs(List<List<Integer>> combine_list, List<Integer> temp, int n, int ni, int k, int t) {
        if (t >= k) {
            combine_list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = ni; i <= n; i++) {
            if (n - i + 1 + t < k) return;//这里剪枝，如果剩下的数都不够组合成K个了，就不用往下走了
            temp.add(i);
            dfs(combine_list, temp, n, i + 1, k, t + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
