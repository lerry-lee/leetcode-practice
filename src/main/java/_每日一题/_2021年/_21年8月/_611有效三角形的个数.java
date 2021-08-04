package _每日一题._2021年._21年8月;

import java.util.Arrays;

/**
 * @ClassName: _611有效三角形的个数
 * @Author: lerry_li
 * @CreateDate: 2021/08/04
 * @Description
 */
public class _611有效三角形的个数 {

    public static void main(String[] args) {
        _611有效三角形的个数 instance=new _611有效三角形的个数();
        System.out.println(instance.triangleNumber(new int[]{2, 2, 3, 4}));
    }

    /**
     * 解法1：排序+二分 时间O(n^2logn) 空间O(1)
     */
    public int triangleNumber(int[] nums) {
        //特判
        if (nums == null || nums.length <= 2) return 0;
        //排序
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //二分查找第一个大于等于i+j的下标k
                int k = bSearch(nums, j + 1, nums[i] + nums[j]);
                if (k == -1) continue;
                res += k - (j+1);
            }
        }
        return res;
    }

    private int bSearch(int[] nums, int start, int tar) {
        if (start >= nums.length) return -1;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == tar) end = mid;
            else if (nums[mid] < tar) start = mid + 1;
            else end = mid;
        }
        if(nums[start]>=tar) return start;
        return start+1;
    }
}
