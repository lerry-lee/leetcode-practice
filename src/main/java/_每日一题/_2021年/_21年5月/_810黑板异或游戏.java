package _每日一题._2021年._21年5月;

/**
 * @ClassName: _810黑板异或游戏
 * @Author: lerry_li
 * @CreateDate: 2021/05/22
 * @Description
 * 解法1：数学推导
 */
public class _810黑板异或游戏 {
    /**
     * 解法1：数学推导 时间O(N) 空间O(1)
     * 思路：
     *      1.数组长度为偶数时，先手的Alice必赢
     *      2.数组长度为奇数时，只有数组所有元素异或值为0时，先手的Alice才赢
     * 重点：只要证明推论1，则推论2显然成立。
     * 如何证明推论1？
     *      假设偶数个数组元素异或值为S，若S为0，则Alice赢，下面讨论S不为0的情况：
     *      1）S不为0，说明偶数个元素里，至少有2个元素不同，则Alice每次选择其中1个；
     *      2）接着Bob选，若Bob选任意一个，剩余元素的异或值都为0，则Alice胜；若Bob选完，游戏仍然继续，则
     *      3）数组元素又变成了奇数，而且S不为0，回到步骤1），依次类推，因此Alice必胜。
     */
    public boolean xorGame(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length % 2 == 0) return true;
        int xor = 0;
        for (int num : nums) xor ^= num;
        return xor == 0;
    }

}
