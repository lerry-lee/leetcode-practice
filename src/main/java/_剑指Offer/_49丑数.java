package _剑指Offer;

/**
 * @ClassName: _49丑数
 * @Author: lerry_li
 * @CreateDate: 2021/04/28
 * @Description
 * 解法1：朴素
 * 解法2：三指针+动态规划
 */
public class _49丑数 {

    public static void main(String[] args) {
        _49丑数 instance = new _49丑数();
        System.out.println(instance.nthUglyNumber(10));//12
        System.out.println(instance.nthUglyNumber(9));//10
    }

    /**
     * 解法1：朴素 时间O(NP) P是判断丑数的计算复杂度 空间O(1)
     */
    public int nthUglyNumber2(int n) {
        if (n == 1) {
            return 1;
        }
        int cur = 1;
        while (true) {
            if (check(cur)) {
                n--;
            }
            if (n == 0) {
                break;
            }
            cur++;
        }
        return cur;
    }

    /**
     * 解法2：三指针+动态规划 时间O(n) 空间O(N)
     */
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int f2 = 0, f3 = 0, f5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int t2 = dp[f2] * 2, t3 = dp[f3] * 3, t5 = dp[f5] * 5;
            dp[i] = Math.min(Math.min(t2, t3), t5);
            if (t2 == dp[i]) f2++;
            if (t3 == dp[i]) f3++;
            if (t5 == dp[i]) f5++;
        }
        return dp[n - 1];
    }

    private boolean check(int cur) {
        while (cur % 5 == 0) {
            cur /= 5;
        }
        while (cur % 3 == 0) {
            cur /= 3;
        }
        while (cur % 2 == 0) {
            cur /= 2;
        }
        return cur == 1;
    }

}
