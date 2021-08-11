package _每日一题._2021年._21年8月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _446等差数列划分2_子序列
 * @Author: lerry_li
 * @CreateDate: 2021/08/11
 * @Description
 */
public class _446等差数列划分2_子序列 {
    /**
     * 解法1：dp+哈希表 时间O(N^2) 空间O(N^2)
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }

        Map<Long, Integer>[] dp = new HashMap[len];
        for (int i = 0; i < len; i++) {
            dp[i] = new HashMap<>();
        }

        int res = 0;
        //枚举等差数列的末尾元素
        for (int i = 1; i < len; i++) {
            //枚举前面的dp[j]
            for (int j = 0; j < i; j++) {
                //计算i-j的差
                long diff = (long) nums[i] - nums[j];
                //如果越界，直接跳过
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }
                //加入哈希表
                //如果dp[i]+j 又构成了等差数列，则继续累加，否则就是0
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + dp[j].getOrDefault(diff, 0) + 1);
                if (dp[j].containsKey(diff)) {
                    res += dp[j].get(diff);
                }
            }
        }
        return res;
    }
}
