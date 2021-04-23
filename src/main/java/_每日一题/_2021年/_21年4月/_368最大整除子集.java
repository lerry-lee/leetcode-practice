package _每日一题._2021年._21年4月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _368最大整除子集
 * @Author: lerry_li
 * @CreateDate: 2021/04/23
 * @Description
 * 解法1：动态规划
 */
public class _368最大整除子集 {

    public static void main(String[] args) {
        _368最大整除子集 instance = new _368最大整除子集();
        System.out.println(instance.largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(instance.largestDivisibleSubset(new int[]{1, 2, 3, 4, 8}));
    }

    /**
     * 解法1：动态规划 时间O(N^2) 空间O(N)
     * 状态定义：
     *      dp[i]表示以nums[i]为最大元素的最大整除子集的大小（因此nums[]必须升序）
     * 状态转移：
     *      对于当前元素 nums[i] ，枚举dp[j](j∈[0,i-1])，当nums[i]%nums[j]==0时，考虑更新dp[i]
     * 初始化：
     *      dp[i]=1，每个元素本身可以为一个子集，因此子集大小初始化为1
     * tips：
     *      dp[]数组记录的只是最大整除子集的大小，并没有记录是哪些元素，可以考虑如下方式找到这些元素
     *      (1)遍历dp[]，找到最大值dp[i]赋值给maxLen，然后将当前i对应的元素nums[i]加入到结果集中，然后maxLen-1，重复（1）直到dp[i]=1
     *      (2)用一个prev[]数组记录每个元素的前驱元素的下标
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        //1.动态规划求dp[]和prev[]
        //升序排列
        Arrays.sort(nums);
        //初始化dp[]和prev[]
        int len = nums.length;
        int[] dp = new int[len];
        int[] prev = new int[len];
        Arrays.fill(prev, -1);
        Arrays.fill(dp, 1);
        //状态转移
        for (int i = 1; i < len; i++) {
            //记录以nums[i]为最大元素的子集最大长度
            int maxLen = 0;
            //记录nums[i]的前驱元素的下标
            int prevJ = -1;
            //枚举dp[j],j∈[0,i-1]
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (maxLen < dp[j] + 1) {
                        prevJ = j;
                        maxLen = dp[j] + 1;
                    }
                }
            }
            //若prevJ未更新，则dp[i]=1，不需要更新
            if (prevJ != -1) {
                dp[i] = maxLen;
                prev[i] = prevJ;
            }
        }
        //2.遍历dp[]和prev[]找到最大子集
        int pathI = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                pathI = i;
            }
        }
        while (pathI != -1) {
            res.add(nums[pathI]);
            pathI = prev[pathI];
        }

        return res;
    }
}
