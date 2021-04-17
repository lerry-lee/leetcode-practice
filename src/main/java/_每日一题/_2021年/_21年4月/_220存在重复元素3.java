package _每日一题._2021年._21年4月;

import java.util.TreeSet;

/**
 * @ClassName: _220存在重复元素3
 * @Author: lerry_li
 * @CreateTime: 2021/04/17
 * @Description
 * 解法1：滑动窗口+有序集合(二分查找)
 */
public class _220存在重复元素3 {

    public static void main(String[] args) {
        _220存在重复元素3 instance = new _220存在重复元素3();
        System.out.println(instance.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));//true
        System.out.println(instance.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));//true
        System.out.println(instance.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));//false
        System.out.println(instance.containsNearbyAlmostDuplicate(new int[]{-2147483648, 2147483647}, 1, 1));//false
    }

    /**
     * 解法1：滑动窗口+有序集合(二分查找)
     * 时间复杂度：TreeSet 基于红黑树，查找和插入都是 O(logk) 复杂度。整体复杂度为 O(nlogk)
     * 空间复杂度：O(k)
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> ts = new TreeSet<>();
        int left = 0, right = 0;
        while (right < n) {
            Long cur = (long) nums[right];
            // 从 ts 中找到小于等于 cur 的最大值（小于等于 cur 的最接近 cur 的数）
            Long cur_left = ts.floor(cur);
            // 从 ts 中找到大于等于 cur 的最小值（大于等于 cur 的最接近 cur 的数）
            Long cur_right = ts.ceiling(cur);
            if (cur_left != null && cur - cur_left <= t) return true;
            if (cur_right != null && cur_right - cur <= t) return true;
            ts.add(cur);
            if (right - left >= k) {
                ts.remove((long) nums[left]);
                left++;
            }
            right++;
        }
        return false;
    }

}
