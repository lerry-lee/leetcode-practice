package Tecent._数组与字符串;

/**
 * @author lerrylee
 * @version 1.0
 * @create 2020/09/12 10:07
 * @description 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class _寻找两个正序数组中的中位数 {
    /**
     * 解法1：转化成-->寻找两个正序数组第K小的数
     * tips：两个数组的元素个数之和为奇数时，中位数只有1个；为偶数时，中位数为两个数的平均数
     * 可以分情况讨论，也可以统一为求第(n1+n2+1)/2个数和第(n1+n2)/2+1个数的平均数
     * 如何找第K个数？
     * 首先遍历数组1和数组2分别需要两个指针start1和start2
     * 1）将K/2，数组1和数组2分别找第K/2个数（通过下标访问时需要-1，因为数组下标从0开始）
     * 2）比较两个数的大小（假设分别num1和num2），较小的那个数（假设在数组1中）
     * 那么数组1中的num1之前的数都不会是第k个数（因为数组正序，这部分数都是小于第k个数的）
     * 3）将数组1的num1之前的数（包括num1）丢弃，从num1后开始继续找
     * 此时start1更新，指向num1后一个数的下标
     * 此时k减去丢弃的个数（找第（k-丢弃数）个数字）
     * 4）如果k=1时，那么直接返回数组1和数组2中较小的数即可
     * 注意：下标越界情况、某个数组已经丢弃完的情况
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int k1 = (n1 + n2 + 1) / 2, k2 = (n1 + n2) / 2 + 1;//奇偶统一
        int num1 = findKthNum(nums1, 0, nums2, 0, k1, k1 / 2 - 1);
        int num2 = findKthNum(nums1, 0, nums2, 0, k2, k2 / 2 - 1);
        System.out.println(num1 + " " + num2);
        return (num1 + num2) / 2.0;
    }

    /**
     * 递归查找第K个数字
     *
     * @param nums1  数组1
     * @param start1 数组1的起始访问指针
     * @param nums2  数组2
     * @param start2 数组2的起始访问指针
     * @param k      找第K个数字
     * @param offset 下标偏移量，用于二分查找，将第K个数变成分别在数组1和数组2种找第K/2个数
     * @return 第K个数字
     */
    public int findKthNum(int[] nums1, int start1, int[] nums2, int start2, int k, int offset) {
        //若某个数组在寻找过程中已经丢弃完了，直接返回另一个数组第k个数
        if (start1 == nums1.length) return nums2[start2 + k - 1];
        if (start2 == nums2.length) return nums1[start1 + k - 1];
        //k=1表示找第1个数，直接返回俩数组中下标所对应的值较小的即可,此时偏移量就是0
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        //下标越界情况判断，指针+偏移量不能超过数组长度
        if (start1 + offset >= nums1.length) offset = nums1.length - start1 - 1;
        else if (start2 + offset >= nums2.length) offset = nums2.length - start2 - 1;
        //更新k
        k -= offset + 1;
        //递归查找
        if (nums1[start1 + offset] > nums2[start2 + offset])
            return findKthNum(nums1, start1, nums2, start2 + offset + 1, k, k / 2 - 1);
        else return findKthNum(nums1, start1 + offset + 1, nums2, start2, k, k / 2 - 1);
    }
}
