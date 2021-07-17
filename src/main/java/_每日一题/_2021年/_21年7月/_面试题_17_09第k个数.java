package _每日一题._2021年._21年7月;

/**
 * @ClassName: _面试题_17_09第k个数
 * @Author: lerry_li
 * @CreateDate: 2021/07/17
 * @Description
 */
public class _面试题_17_09第k个数 {
    /**
     * 解法1：三指针+dp(参考丑数解法)
     */
    public int getKthMagicNumber(int k) {
        //三指针定义，指向下标0，即第一个丑数
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        //dp数组，长度为k，刚好放k个丑数
        int[] dp = new int[k];
        //初始化dp[0]=1，第一个丑数为1
        dp[0] = 1;
        //状态转移
        for (int i = 1; i < k; i++) {
            //计算三指针所指的数字*倍率的值
            int n3 = dp[p3] * 3, n5 = dp[p5] * 5, n7 = dp[p7] * 7;
            //三者求最小，同时也是下一个“丑数”
            dp[i] = min3(n3, n5, n7);
            //判断是哪一个丑数被选中了，其对应的指针p需要右移一位
            if (dp[i] == n3) p3++;
            if (dp[i] == n5) p5++;
            if (dp[i] == n7) p7++;
        }
        return dp[k - 1];
    }

    private int min3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
