package _每日一题._2021年._21年7月;

import java.util.Arrays;

/**
 * @ClassName: _1838最高频元素的频数
 * @Author: lerry_li
 * @CreateDate: 2021/07/19
 * @Description
 * 解法1：排序+滑动窗口
 */
public class _1838最高频元素的频数 {
    /**
     * 解法1：排序+滑动窗口 时间o(nLOGn) 空间O(k)
     */
    public int maxFrequency(int[] nums, int k) {
        //特判
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        //滑动窗口内的元素和右边界元素的差值和
        int difSum = 0;
        //最大频数，至少是1
        int maxFreq = 1;
        //窗口[l,r)
        int l = 0, r = 1;
        while (r < nums.length) {
            //滑动窗口右移
            //每次右移，差值除了最右边的元素和其左边一个的差值，前面每个元素都要多出来这一段
            difSum += (nums[r] - nums[r - 1]) * (r - l);
            //若difSum超过k了，滑动窗口左移
            while (difSum > k) {
                difSum -= nums[r] - nums[l];
                l++;
            }
            //更新最大频数
            maxFreq = Math.max(maxFreq, r - l+1);
            r++;
        }
        return maxFreq;
    }
}
