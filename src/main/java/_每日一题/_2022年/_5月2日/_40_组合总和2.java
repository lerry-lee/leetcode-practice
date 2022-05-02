package _每日一题._2022年._5月2日;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _40_组合总和2 {

    public static void main(String[] args) {
        _40_组合总和2 instance = new _40_组合总和2();
        int[] arr = new int[]{3, 1, 3, 5, 1, 1};
        int tar = 8;
        instance.new Solution().combinationSum2(arr, tar);
    }

    /**
     * 解法1：回溯
     */
    class Solution {
        List<List<Integer>> res;
        int target;
        int[] candidates;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            res = new ArrayList<>();
            if (candidates == null || candidates.length == 0) return res;
            this.target = target;
            this.candidates = candidates;
            Arrays.sort(this.candidates);
            dfs(0, new ArrayList(), 0);
            return res;
        }

        private void dfs(int t, List<Integer> path, int sum) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }
            if (t == candidates.length) return;

            for (int i = t; i < candidates.length; i++) {
                if (i > t && candidates[i] == candidates[i-1]) continue;
                if (candidates[i] + sum > target) {
                    return;
                }
                path.add(candidates[i]);
                dfs(i + 1, path, sum + candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }
}
