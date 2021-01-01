package _每日一题._2020年._20年7月;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/13 09:11
 * @description 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class _350两个数组的交集2 {
    /**
     * 思路1：排序+双指针遍历，时间复杂度O(mlogm+nlogn) 空间复杂度O(min(m,n))
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        int len1 = nums1.length, len2 = nums2.length;
        int n = Math.min(len1, len2);
        int[] intersection = new int[n];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, end = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                intersection[end] = nums1[i];
                i++;
                j++;
                end++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else j++;
        }
        return Arrays.copyOfRange(intersection, 0, end);
    }

    /**
     * 思路2：哈希表 时间复杂度O(m+n) 空间复杂度O(min(m,n))
     * （1）建立短数组的哈希表，key为元素，value为出现次数
     * （2）遍历长数组，如果元素在哈希表中value>0，则加入交集，否则不加入
     */
    public int[] intersect_hash(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
