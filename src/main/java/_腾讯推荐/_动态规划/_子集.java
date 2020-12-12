package _腾讯推荐._动态规划;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: _子集
 * @Signature: Created by lerry_li on 2020/11/04
 * @Description: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 */
public class _子集 {
    /**
     * 解法1：回溯 时间O(2^N) 空间O(2^N)
     * 每个元素都可以加入子集，或者不加入子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    List<List<Integer>> res;

    public void dfs(int[] nums, int t, List<Integer> temp) {
        if (t >= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[t]);
        dfs(nums, t + 1, temp);
        temp.remove(temp.size() - 1);
        dfs(nums, t + 1, temp);
    }

    /**
     * 解法2：动态规划
     * 状态定义：dp[i]表示数组元素为第0~第i个时的所有子集
     * 状态转移：
     * dp[i]=dp[i-1]+dp[i-1]每个子集的末尾追加第i个元素
     * 初始化：
     * dp[0]={},{nums[i]}   #数组元素只有nums[0]时的子集有2个
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res2 = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res2;
        }
        res2.add(new ArrayList<>());
        res2.add(Collections.singletonList(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            int size = res2.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(res2.get(j));
                temp.add(nums[i]);
                res2.add(temp);
            }
        }
        return res2;
    }

    public static void main(String[] args) {
        _子集 instance = new _子集();
        int[] nums = {1, 2, 3};
        System.out.println(instance.subsets2(nums));
    }
}
