package _每日一题._20年9月;

import java.util.*;

/**
 * @ClassName : _47全排列2
 * @CreateTime : 2020/09/18 10
 * @Author : lerry_li
 * @Descrpition : 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class _47全排列2 {
    /**
     * 避免重复：
     *    1）使用hashset存打头的元素，遇到重复的直接跳过
     *    2）if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
     */
    /* ----------------------------------------------------------------------------- */

    /**
     * 解法1：标记法
     * 使用visited[]数组标记元素是否访问过，可保证全排列完全按照顺序来
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(res, new ArrayList<>(), visited, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> temp, boolean[] visited, int[] nums, int t) {

        if (t == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            //因为是先排完序的，所以判断打头的元素是否重复时，直接和前一个数比较，相同则略过（!visited[i-1]表示前一个数未被访问，如果被访问了说明不是打头的元素）
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            dfs(res, temp, visited, nums, t + 1);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }

    /**
     * 解法2：交换法
     * 使用元素交换，轮流使元素打头
     */
    public List<List<Integer>> permuteUnique_swap(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        dfs_swap(res, nums, 0);
        return res;
    }

    public void dfs_swap(List<List<Integer>> res, int[] nums, int t) {
        Set<Integer> hashSet = new HashSet<>();
        if (t == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            res.add(temp);
            return;
        }
        for (int i = t; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) continue;
            hashSet.add(nums[i]);
            swap(nums, i, t);
            dfs_swap(res, nums, t + 1);
            swap(nums, i, t);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
