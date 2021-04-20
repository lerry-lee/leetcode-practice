package _剑指Offer;

import java.util.Arrays;

/**
 * @ClassName: _39数组中出现次数超过一半的数字
 * @Author: lerry_li
 * @CreateDate: 2021/04/20
 * @Description
 * 解法1：排序
 * 解法2：摩尔投票法
 */
public class _39数组中出现次数超过一半的数字 {
    /**
     * 解法1：排序 时间O(NlogN) 空间O(1)
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 解法2：摩尔投票法 时间O(N) 空间O(1)
     * 思路：
     *      摩尔投票法找的就是占半数以上的元素，设为x
     *      1）当前元素为x时，投票+1，否则投票-1，最终投票数一定>0
     *      2）当遍历到某个元素i，投票为0时，[0,i]的元素可抵消忽略，后面的[i,N]个元素中，占半数以上的元素也必为x
     */
    public int majorityElement2(int[] nums) {
        //设x为要找的元素
        int x = nums[0];
        //投票数
        int ticket = 0;
        //遍历数组
        for (int num : nums) {
            //若投票数为0，则假设当前元素为x，投票数=1
            if (ticket == 0) {
                x = num;
                ticket=1;
                continue;
            }
            //否则，若遇到x，投票数+1，若遇到其他值，投票数-1
            if (num == x) {
                ticket++;
            } else {
                ticket--;
            }
        }
        //返回x
        return x;
    }
}
