package _每日一题._2020年._20年12月;

/**
 * @ClassName: _738单调递增的数字
 * @Author: lerry_li
 * @CreateTime: 2020/12/15
 * @Description
 */
public class _738单调递增的数字 {
    /**
     * 解法1：
     * 算法：
     *      1.从高位到低位找到第一个不满足递增的数字i，然后该数字i-1，i右边的数字赋值为9
     *      2.然后判断最高位到数字i是否满足递增，不满足则执行步骤1
     */
    public int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));

    }

    public static void main(String[] args) {
        _738单调递增的数字 instance = new _738单调递增的数字();
        System.out.println(instance.monotoneIncreasingDigits(100));
        System.out.println(instance.monotoneIncreasingDigits(1234));
        System.out.println(instance.monotoneIncreasingDigits(332));

    }
}
