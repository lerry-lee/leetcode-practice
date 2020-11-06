package DailyExercises._20年8月;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/08/23 09:44
 * @description 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1:
 *
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 */
public class _201数字范围按位与 {
    /**
     * 方法一：移位 时间复杂度O(logn) 空间复杂度O(1)
     *
     * 我们的目的是求出两个给定数字(边界m和n)的二进制字符串的公共前缀，这里给出的第一个方法是采用位移操作。
     *
     * 我们的想法是将两个数字不断向右移动，直到数字相等，即数字被缩减为它们的公共前缀。然后，通过将公共前缀向左移动，将零添加到公共前缀的右边以获得最终结果。
     *
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shift=0;
        while(m<n){
            m=m>>1;
            n=n>>1;
            shift+=1;
        }
        return m<<shift;
    }
    /**
     * 方法二：Brian Kernighan 算法
     * 思路与算法
     *
     * 还有一个位移相关的算法叫做「Brian Kernighan 算法」，它用于清除二进制串中最右边的 11。
     *
     * Brian Kernighan 算法的关键在于我们每次对 \textit{number}number 和 \textit{number}-1number−1 之间进行按位与运算后，\textit{number}
     * number 中最右边的 11 会被抹去变成 00。
     *
     */
}
