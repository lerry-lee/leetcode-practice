package _腾讯推荐._回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _全排列
 * @Signature: Created by lerry_li on 2020/10/29
 * @Description:
 */
public class _全排列 {
    /**
     * 解法1：回溯（交换法）
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(res, nums, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, int[] nums, int t) {
        if (t == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
            return;
        }
        for (int i = t; i < nums.length; i++) {
            swap(nums, i, t);
            dfs(res, nums, t + 1);
            swap(nums, i, t);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 解法2：回溯（boolean记录法）
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        dfs2(res, nums, visited, new ArrayList<>());
        return res;
    }

    public void dfs2(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            temp.add(nums[i]);
            visited[i] = true;
            dfs2(res, nums, visited, temp);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
