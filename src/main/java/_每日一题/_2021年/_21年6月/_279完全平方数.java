package _每日一题._2021年._21年6月;

/**
 * @ClassName: _279完全平方数
 * @Author: lerry_li
 * @CreateDate: 2021/06/11
 * @Description
 * 解法1：dp
 * 解法2：四平方和定理
 */
public class _279完全平方数 {

    public static void main(String[] args) {
        _279完全平方数 instance = new _279完全平方数();
        System.out.println(instance.numSquares(12));//3
        System.out.println(instance.numSquares(13));//2
    }

    /**
     * 解法1：dp 时间O(N*sqrt(N)) 空间O(N)
     * tips: 乘法比开方计算要快，因此sqrt()可以用乘法替换
     */
    public int numSquares(int n) {
        //dp[i]表示和为i的完全平方数的最小数量
        //最终目标是求dp[n]
        int[] dp = new int[n + 1];
        //初始化dp[i]=i，即全都由1组成，这是完全平方数最多的情况，也是保底的情况
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        //状态转移
        for (int i = 1; i <= n; i++) {
            //枚举所有选择(所有完全平方数j*j)，j=[1,sqrt(i)]
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 解法2：四平方和定理 时间O(sqrt(N)) 空间O(1)
     * 定理：任意一个正整数都可以被表示为至多四个正整数的平方和
     * 具体参考题解：https://leetcode-cn.com/problems/perfect-squares/solution/wan-quan-ping-fang-shu-by-leetcode-solut-t99c/
     */
    public int numSquares2(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }
}
