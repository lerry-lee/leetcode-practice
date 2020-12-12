package _每日一题._20年11月;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _279完全平方数
 * @Signature: Created by lerry_li on 2020/11/11
 * @Description: 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 */
public class _279完全平方数 {
    /**
     * 解法1：动态规划+枚举完全平方数 时间O(N*M) 空间O(N) M为小于等于N的完全平方数的个数
     * 状态定义：dp[i]表示和为i的完全平方数的最少的个数
     * 状态转移：
     * 1)若当前数字i为完全平方数，则dp[i]=1；
     * 2)若当前数字i不是完全平方数：
     * ①枚举小于i的所有完全平方数，设dp[i]=i（全由1组成）;
     * ②设当前完全平方数为j；
     * ③dp[i]=Math.min(dp[i],dp[j]+dp[i-j]);
     * 初始化：
     * dp[0]=0，不管第0个元素，从1开始计算
     * 返回dp[n]
     */
    public int numSquares(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        List<Integer> squareNumbers = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            int result = cal(i);
            if (result == 0) {
                dp[i] = 1;
                squareNumbers.add(i);
            } else {
                int temp = i;
                for (int j = squareNumbers.size() - 1; j >= 0; j--) {
                    temp = Math.min(temp, dp[squareNumbers.get(j)] + dp[i - squareNumbers.get(j)]);
                }
                dp[i] = temp;
            }
        }

        return dp[n];
    }

    /**
     * 计算一个数是不是完全平方数，若是返回0，不是返回小于它的最大的完全平方数
     */
    public int cal(int i) {
        int a = (int) Math.sqrt(i);
        int aa = a * a;
        if (i == aa) {
            return 0;
        }
        return aa;
    }

    public static void main(String[] args) {
        _279完全平方数 instance = new _279完全平方数();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i + ": " + instance.cal(i));
//        }
        System.out.println(instance.numSquares(13));
    }
}
