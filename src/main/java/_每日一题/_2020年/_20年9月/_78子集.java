package _每日一题._2020年._20年9月;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : _78子集
 * @CreateTime : 2020/09/20 09
 * @Author : lerry_li
 * @Descrpition : 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 **/
public class _78子集 {
    /**
     * 解法1：递归
     * 思路；数组中每个元素都可以加入/不加入子集，因此加入/不加入子集各自进入递归即可
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfs(res, nums, 0, new ArrayList<>());
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, int t, List<Integer> subset) {
        if (t == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        //加入
        subset.add(nums[t]);
        dfs(res, nums, t + 1, subset);
        //不加入
        subset.remove(subset.size() - 1);
        dfs(res, nums, t + 1, subset);

    }
}
