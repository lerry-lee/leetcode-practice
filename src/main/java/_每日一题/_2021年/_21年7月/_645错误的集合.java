package _每日一题._2021年._21年7月;

import java.util.Arrays;

/**
 * @ClassName: _645错误的集合
 * @Author: lerry_li
 * @CreateDate: 2021/07/04
 * @Description
 * 解法1：计数排序
 */
public class _645错误的集合 {

    public static void main(String[] args) {
        _645错误的集合 instance = new _645错误的集合();
        System.out.println(Arrays.toString(instance.findErrorNums(new int[]{3, 2, 3, 4, 6, 5})));
    }

    /**
     * 解法1：计数排序 时间O(N) 空间O(N)
     */
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};
        int n = nums.length;
        int[] helper = new int[n + 1];
        int duplicate = 0;
        for (int num : nums) {
            helper[num]++;
            if (helper[num] > 1) duplicate = num;
        }
        int miss = 0;
        for (int i = 1; i <= n; i++) {
            if (helper[i] == 0) {
                miss = i;
                break;
            }
        }
        return new int[]{duplicate, miss};
    }
}
