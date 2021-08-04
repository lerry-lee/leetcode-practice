package _每日一题._2021年._21年8月;

import java.util.Arrays;

/**
 * @ClassName: _581最短无序连续子数组
 * @Author: lerry_li
 * @CreateDate: 2021/08/03
 * @Description
 */
public class _581最短无序连续子数组 {

    public static void main(String[] args) {
        _581最短无序连续子数组 instance=new _581最短无序连续子数组();
        System.out.println(instance.findUnsortedSubarray2(new int[]{2,6,4,8,10,9,15}));
    }

    /**
     * 解法1：排序+比较 时间O(NlogN) 空间O(N)
     */
    public int findUnsortedSubarray(int[] nums) {
        //特判
        if (nums == null || nums.length <= 1) return 0;
        int n = nums.length;
        int[] numsCP = new int[n];
        //copy数组，排序，然后比较相同的
        System.arraycopy(nums, 0, numsCP, 0, n);
        Arrays.sort(numsCP);
        int cnt = 0;
        int i = 0, j = n - 1;
        while (i <= j) {
            if (nums[i] == numsCP[i]) {
                i++;
                cnt++;
            } else break;
        }
        while (i <= j) {
            if (nums[j] == numsCP[j]) {
                j--;
                cnt++;
            } else break;
        }
        return n - cnt;
    }

    /**
     * 解法2：双指针一次遍历 时间O(n) 空间O(1) todo
     */
    public int findUnsortedSubarray2(int[] nums) {
        //特判
        if (nums == null || nums.length <= 1) return 0;
        int n=nums.length;
        return 0;
    }
}
