package _每日一题._2022年._5月;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/14
 * @Description
 */
public class _剑指Offer60_n个骰子的点数 {
    /**
     * solution1: violently enumerate
     */
    class Solution {
        public double[] dicesProbability(int n) {
            //check null
            if (n < 1) return new double[]{};
            //total s nums scope of s is [n,n*6]
            int total = n * 6 - (n - 1);
            double[] res = new double[total];
            //iterate [n,n*6]
            for (int i = n; i < n * 6; i++) {
                //Violently enumerate all combinations
            }
            return res;
        }
    }

    /**
     * solution2: dp, time complexity O(N^2), space complexity O(n)
     */
    class Solution2 {
        public double[] dicesProbability(int n) {
            double[] dp = new double[6];
            Arrays.fill(dp, 1.0 / 6.0);
            // 从2个骰子，开始逐渐增加
            for (int i = 2; i <= n; i++) {
                double[] tmp = new double[5 * i + 1];
                // 上一步的dp状态，表示所有可能值s的概率
                for (int j = 0; j < dp.length; j++) {
                    // 增加一个骰子后，可能扔出1~6的点数，dp[j]和该1~6组合
                    for (int k = 0; k < 6; k++) {
                        // 这里记得是加上dp数组值与1/6的乘积，1/6是第k个骰子投出某个值的概率
                        tmp[j + k] += dp[j] / 6.0;
                    }
                }
                dp = tmp;
            }
            return dp;
        }
    }

}
