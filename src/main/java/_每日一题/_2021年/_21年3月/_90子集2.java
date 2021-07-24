package _每日一题._2021年._21年3月;

import java.util.*;

/**
 * @ClassName: _90子集2
 * @Author: lerry_li
 * @CreateDate: 2021/04/01
 * @Description
 */
public class _90子集2 {
    /**
     * 解法1：回溯+去重
     * 参考图解
     */
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        //特判
        if (nums == null || nums.length == 0) {
            return res;
        }
        //排序
        Arrays.sort(nums);
        //递归回溯
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    /**
     * 递归回溯，回溯的所有解构成一棵树
     * @param nums 整数数组
     * @param path 记录当前路径
     * @param t 数组下标
     */
    public void dfs(int[] nums, List<Integer> path, int t) {
        //添加当前路径(一个解)到res
        res.add(new ArrayList<>(path));
        for (int i = t; i < nums.length; i++) {
            if (i > t && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        _90子集2 instance = new _90子集2();
        System.out.println(instance.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
