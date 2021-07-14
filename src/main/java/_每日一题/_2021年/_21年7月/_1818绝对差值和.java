package _每日一题._2021年._21年7月;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

/**
 * @ClassName: _1818绝对差值和
 * @Author: lerry_li
 * @CreateDate: 2021/07/14
 * @Description
 * 解法1：暴力
 * 解法2：treeset优化搜索
 * 解法3：二分优化搜索
 */
public class _1818绝对差值和 {

    public static void main(String[] args) {
        _1818绝对差值和 instance = new _1818绝对差值和();
        int[] nums1 = {1, 7, 5};
        int[] nums2 = {2, 3, 5};
        System.out.println(instance.minAbsoluteSumDiff(nums1, nums2));
    }

    /**
     * 解法1：暴力 时间O(N^2) 空间O(1)
     */
    public int minAbsoluteSumDiff1(int[] nums1, int[] nums2) {
        //特判
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return 0;
        //枚举每个元素被替换的情况，找最大的差值
        int maxDif = 0;
        int n = nums1.length;
        //求和
        long res = 0;
        for (int i = 0; i < n; i++) {
            int dif = Math.abs(nums1[i] - nums2[i]);
            res += dif;
            if (dif == 0) continue;
            int temp = dif;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                temp = Math.min(temp, Math.abs(nums1[j] - nums2[i]));
            }
            maxDif = Math.max(maxDif, dif - temp);
        }
        return (int) ((res - maxDif) % 1000000007);
    }

    /**
     * 解法2：treeset优化搜索 时间O(NlogN) 空间O(NlogN)
     */
    public int minAbsoluteSumDiff2(int[] nums1, int[] nums2) {
        //特判
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return 0;
        //枚举每个元素被替换的情况，找最大的差值
        int maxDif = 0;
        int n = nums1.length;
        //求和
        long res = 0;
        //treeset
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums1) treeSet.add(num);
        for (int i = 0; i < n; i++) {
            int dif = Math.abs(nums1[i] - nums2[i]);
            res += dif;
            if (dif == 0) continue;
            int temp = dif;
            if (treeSet.ceiling(nums2[i]) != null) {
                temp = Math.min(temp, Math.abs(treeSet.ceiling(nums2[i]) - nums2[i]));
            }
            if (treeSet.floor(nums2[i]) != null) {
                temp = Math.min(temp, Math.abs(treeSet.floor(nums2[i]) - nums2[i]));
            }
            maxDif = Math.max(maxDif, dif - temp);
        }
        return (int) ((res - maxDif) % 1000000007);
    }

    /**
     * 解法3：二分优化搜索 时间O(NlogN) 空间O(NlogN)
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        //特判
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return 0;
        //枚举每个元素被替换的情况，找最大的差值
        int maxDif = 0;
        int n = nums1.length;
        //copy nums1 排序
        nums1_copy = new int[n];
        for (int i = 0; i < n; i++) nums1_copy[i] = nums1[i];
        Arrays.sort(nums1_copy);
        //求和
        long res = 0;
        for (int i = 0; i < n; i++) {
            int dif = Math.abs(nums1[i] - nums2[i]);
            res += dif;
            if (dif == 0) continue;
            int temp = findNearliest(nums2[i], dif);
            maxDif = Math.max(maxDif, dif - temp);
        }
        return (int) ((res - maxDif) % 1000000007);
    }

    private int findNearliest(int target, int temp) {
        int l = 0, r = nums1_copy.length - 1;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (nums1_copy[mid] == target) return 0;
            else if (nums1_copy[mid] < target) l = mid;
            else r = mid;
        }
        int min = Math.min(Math.abs(nums1_copy[l] - target), Math.abs(nums1_copy[r] - target));
        return Math.min(temp, min);
    }

    int[] nums1_copy;
}
