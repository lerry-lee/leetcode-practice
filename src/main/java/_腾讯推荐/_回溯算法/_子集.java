package _腾讯推荐._回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _子集
 * @Signature: Created by lerry_li on 2020/10/28
 * @Description:
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
public class _子集 {
    /**
     * 解法1：简单回溯
     * 每个元素都有两个状态，要么选，要么不选
     * 用boolean型的数组visited[i]来记录第i个元素选/不选
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        backtrack(res, nums, 0, visited);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, int t, boolean[] visited) {
        if (t == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    temp.add(nums[i]);
                }
            }
            res.add(temp);
            return;
        }
        visited[t] = true;
        backtrack(res, nums, t + 1, visited);
        visited[t] = false;
        backtrack(res, nums, t + 1, visited);
    }
}
