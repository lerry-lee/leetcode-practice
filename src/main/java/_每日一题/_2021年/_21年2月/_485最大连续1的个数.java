package _每日一题._2021年._21年2月;

/**
 * @ClassName: _485最大连续1的个数
 * @Author: lerry_li
 * @CreateTime: 2021/02/15
 * @Description
 */
public class _485最大连续1的个数 {
    /**
     * 解法1：一次遍历 时间O(N) 空间O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] == 1) {
                    temp=1;
                    res = 1;
                }
                continue;
            }
            if (nums[i] == 0) {
                temp = 0;
            } else {
                temp++;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
