package _剑指Offer;

/**
 * @ClassName: _10_1_斐波那契数列
 * @Author: lerry_li
 * @CreateDate: 2021/04/02
 * @Description
 */
public class _10_1_斐波那契数列 {
    /**
     * 解法1：回溯（带备忘录）
     * 解法2：动态规划（空间优化）
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int cur = 0;
        int fib_prev = 1, fib_prev_prev = 0;
        for (int i = 2; i <= n; i++) {
            cur = (fib_prev + fib_prev_prev)%1000000007;
            fib_prev_prev = fib_prev;
            fib_prev = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        _10_1_斐波那契数列 instance=new _10_1_斐波那契数列();
        System.out.println(instance.fib(48));
    }
}
