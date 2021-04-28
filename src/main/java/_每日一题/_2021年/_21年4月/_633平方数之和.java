package _每日一题._2021年._21年4月;

/**
 * @ClassName: _633平方数之和
 * @Author: lerry_li
 * @CreateDate: 2021/04/28
 * @Description
 * 解法1：双指针
 */
public class _633平方数之和 {

    public static void main(String[] args) {
        _633平方数之和 instance=new _633平方数之和();
        System.out.println(instance.judgeSquareSum(5));//t
        System.out.println(instance.judgeSquareSum(4));//t
        System.out.println(instance.judgeSquareSum(3));//f
    }

    /**
     * 解法1：双指针 时间O(根号下c) 空间O(1)
     */
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        if (c <= 2) {
            return true;
        }
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int sum = a * a + b * b;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                a++;
            } else {
                b--;
            }
        }
        return false;
    }
}
