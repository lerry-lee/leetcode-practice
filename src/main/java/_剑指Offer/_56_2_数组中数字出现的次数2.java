package _剑指Offer;

import java.util.Arrays;

/**
 * @ClassName: _56_2_数组中数字出现的次数2
 * @Author: lerry_li
 * @CreateDate: 2021/06/10
 * @Description
 * 解法1：排序
 * 解法2：按位统计
 */
public class _56_2_数组中数字出现的次数2 {
    /**
     * 解法1：排序 时间O(NlogN) 空间O(1)
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) cnt++;
            else {
                if (cnt == 1) break;
                prev = nums[i];
                cnt = 1;
            }
        }
        return prev;
    }

    /**
     * 解法2：按位统计 时间O(N) 空间O(1)
     * 思路：
     *      统计所有数字的每个二进制位中1出现的次数，并对3求余数，结果为只出现一次的数字的该二进制位
     */
    public int singleNumber2(int[] nums) {
        int[] digitCount = new int[32];
        //统计
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                digitCount[i] += num & 1;
                num >>= 1;
            }
        }
        //求余，组装数字
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            res += digitCount[i] % 3;
        }
        return res;
    }
}
