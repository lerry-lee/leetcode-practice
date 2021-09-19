package _每日一题._2021年._21年9月;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/19
 */
public class _650只有两个键的键盘 {

    public static void main(String[] args) {
        _650只有两个键的键盘 instance = new _650只有两个键的键盘();
        System.out.println(instance.minSteps(6));
    }

    /**
     * 解法1：dp 时间O(N^2) 空间O(N^2)
     */
    public int minSteps(int n) {
        if (n == 1) return 0;
        //dp[i]表示屏幕输出i个'A'时所需要的最小操作步数
        //返回dp[n]
        int[] dp = new int[n + 1];
        //初始化
        dp[1] = 0;
        dp[2] = 2;
        //状态转移
        for (int i = 3; i <= n; i++) {
            //对于第i个情况，找比i小的最大的因子，然后从它可以经过复制+若干次粘贴得到
            int biggestDivisor = getBiggestDivisor(i);
            dp[i] = dp[biggestDivisor] + i / biggestDivisor;
        }
        return dp[n];
    }

    private int getBiggestDivisor(int i) {
        for (int j = i / 2; j > 1; j--) {
            if (i % j == 0) return j;
        }
        return 1;
    }

    /**
     * 解法2：分解质因数 时间O(根号下n) 空间O(1)
     * 思路：
     *      1、如果n为一个质数，那么结果就是n,因为只能一个个粘贴。
     *      2、如果n为一个合数，那么他的结果就是分解因式的结果之和，
     */
    public int minSteps2(int n) {
        int ans = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ans += i;
                n /= i;
            }
        }

        if (n != 1) return n;
        return ans;
    }
}
