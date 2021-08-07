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
        _581最短无序连续子数组 instance = new _581最短无序连续子数组();
        System.out.println(instance.findUnsortedSubarray2(new int[]{2, 6, 4, 8, 10, 9, 15}));
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
     * 解法2：双指针一次遍历 时间O(n) 空间O(1)
     * 思路：
     *      将数组分为三部分numsA,numsB,numsC
     *      numsA,numsC是有序的，numsB是无序的
     *      且numsA的最大值<numsB的最小值，numsC的最小值大于numsB的最大值
     *      由于numsA有序，则numsA的最大值取numsA最右边的元素
     *      由于numsC有序，则numsC的最小值取numsC最左边的元素
     */
    public int findUnsortedSubarray2(int[] nums) {
        //特判
        if (nums == null || nums.length <= 1) return 0;
        int n = nums.length;

        int l = 0; // l 标记从前往后找到第一个出现降序的下标，nums[l] > nums[l + 1]
        while (l+1 < n && nums[l] <= nums[l + 1]) {
            l++;
        }

        // 若l == n - 1, 说明 nums 为升序序列
        if (l == n - 1) {
            return 0;
        }

        int r = n - 1; // r 标记从后往前找到第一个出现升序的下标，nums[r] < nums[r - 1]
        while (r-1 >= 0 && nums[r] >= nums[r - 1]) {
            r--;
        }

        /* 在子区间 [l, r] 中找到最小值 min 和最大值 max*/
        int min = nums[l];
        int max = nums[r];
        for (int i = l; i <= r; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        /* 从 l 开始向前查找 min 在 nums 中的最终位置 l */
        while (l - 1 >= 0 && nums[l - 1] > min) {
            l--;
        }

        /* 从 r 开始向后查找 max 在 nums 中的最终位置 r*/
        while (r + 1 < n && nums[r + 1] < max) {
            r++;
        }

        /* 确定无序子数组的最小值和最大值的最终位置后，[l, r] 中的元素就是原数组 nums 待排序的子数组*/
        return r - l + 1;
    }
}
