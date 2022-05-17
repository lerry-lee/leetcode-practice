package _每日一题._2022年._5月;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/17
 */
public class _135_分发糖果 {
    /**
     * 解法1：贪心+左右遍历 时间O(N) 空间O(N)
     * 思路：
     *      初始化每个孩子1个糖果(至少)，然后
     *      1. 从左遍历，使其满足左规则。（左规则是指，每个孩子和左边相邻孩子比较，需要满足条件）
     *      2. 从右遍历，使其满足右规则；（右规则是指，每个孩子和右边相邻孩子比较，需要满足条件）
     *      3. 对于每个孩子，取左右规则的最大值，就是满足条件的糖果数量
     */
    class Solution {
        public int candy(int[] ratings) {
            // check empty
            if (ratings == null || ratings.length == 0) {
                return 0;
            }
            int n = ratings.length;
            // Each child is given at least 1 candy
            int[] left = new int[n];// 左规则
            int[] right = new int[n];// 右规则
            Arrays.fill(left, 1);
            Arrays.fill(right, 1);
            // 从左向右遍历，每次比较当前孩子和左边相邻孩子的评分，如果当前更高，使其比他左边相邻的孩子多分一个糖果
            for (int i = 1; i < n; i++) {
                // if cur mark is bigger than next, cur will get candy+1
                if (ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                }
            }
            // 从右向左遍历，每次比较当前孩子和右边相邻孩子的评分，如果当前更高，使其比他右边相邻的孩子多分一个糖果
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    right[i] = right[i + 1] + 1;
                }
            }
            // 最后统计每个孩子分得的糖果，取left和right的最大值，这样可以同时满足左规则和右规则
            int res = 0;
            for (int i = 0; i < n; i++) {
                res += Math.max(left[i], right[i]);
            }
            return res;
        }
    }
}
