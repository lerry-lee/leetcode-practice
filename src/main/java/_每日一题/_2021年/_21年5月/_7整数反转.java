package _每日一题._2021年._21年5月;

/**
 * @ClassName: _7整数反转
 * @Author: lerry_li
 * @CreateDate: 2021/05/10
 * @Description
 * 解法1：按位(判断溢出)
 */
public class _7整数反转 {

    public static void main(String[] args) {
        _7整数反转 instance = new _7整数反转();
        System.out.println(instance.reverse(123));//321
        System.out.println(instance.reverse(-123));//-321
        System.out.println(instance.reverse(120));//21
        System.out.println(instance.reverse(Integer.MAX_VALUE));//0
    }

    /**
     * 解法1：按位(判断溢出) 时间O(logN) 空间O(1)
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res;
    }
}
