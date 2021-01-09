package _每日一题._2021年._21年1月;

import _工具类.CommonMethod;

/**
 * @ClassName: _189旋转数组
 * @Author: lerry_li
 * @CreateDate: 2021/01/09
 * @Description
 */
public class _189旋转数组 {
    /**
     * 解法1：借助辅助数组，遍历原数组，计算其旋转后的下标，放置新数组中 时间O(N) 空间O(N)
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return;
        }
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[(i + k) % n] = nums[i];
        }
//        CommonMethod.display(res);
        System.arraycopy(res, 0, nums, 0, n);
    }

    /**
     * 解法2：借助辅助数组，找到旋转后的第一个元素，顺次赋值，放置新数组中 时间O(N) 空间O(N)
     */
    public void rotate2(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return;
        }
        int n = nums.length;
        int[] res = new int[n];
        int idx = 0;
        k %= n;
        int origin_idx = n - k;
        while (idx < n) {
            res[idx] = nums[origin_idx % n];
            idx++;
            origin_idx++;
        }
        CommonMethod.display(res);
        System.arraycopy(res, 0, nums, 0, n);
    }

    /**
     * 解法3：3次翻转数组 时间O(N) 空间O(1)
     * 思路；
     *      该方法基于如下的事实：当我们将数组的元素向右移动k次后，
     *      尾部k%n个元素会移动至数组头部，剩余的从开头开始的元素向后移动k%n个位置。
     *
     *      例如：愿数组[1,2,3,4,5,6,7],k=3
     *      1.全部翻转,[7,6,5,4,3,2,1]
     *      2.翻转[0,k%n-1]区间内的元素，即：翻转[7,6,5]，得到[5,6,7,4,3,2,1]
     *      3.翻转[k%n,n-1]区间内的元素，即：翻转[4,3,2,1]，得到[5,6,7,1,2,3,4]
     */
    public void rotate3(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return;
        }
        int n = nums.length;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k % n - 1);
        reverse(nums, k % n, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 解法4：交换 时间O(N) 空间O(1)
     */
    public void rotate4(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int count = 0;         // 记录交换位置的次数，n个同学一共需要换n次
        int i = 0;
        while (count < len) {
            int curr_num_idx = i;       // 从0位置开始换位子
            int curr_num = nums[curr_num_idx];
            do {
                int be_replaced_num_idx = (curr_num_idx + k) % len;
                int be_replaced_num = nums[be_replaced_num_idx];    // 来到角落...
                nums[be_replaced_num_idx] = curr_num;
                curr_num = be_replaced_num;
                curr_num_idx = be_replaced_num_idx;
                count++;
            } while (i != curr_num_idx);     // 循环暂停，回到起始位置，角落无人
            i++;
        }

    }

    public static void main(String[] args) {
        _189旋转数组 instance = new _189旋转数组();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int[] nums1 = {-1, -100, 3, 99};
        instance.rotate3(nums, 3);
        instance.rotate3(nums1, 2);
    }
}
