package _每日一题._2021年._21年1月;

/**
 * @ClassName: _724寻找数组的中心索引
 * @Author: lerry_li
 * @CreateTime: 2021/01/28
 * @Description
 */
public class _724寻找数组的中心索引 {
    /**
     * 解法1：先求和再一次便利  时间(N) 空间(1)
     */
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        int rightSum = totalSum;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                leftSum += nums[i - 1];
            }
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _724寻找数组的中心索引 instance = new _724寻找数组的中心索引();
        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums1 = {1, 2, 3};
        System.out.println(instance.pivotIndex(nums));
        System.out.println(instance.pivotIndex(nums1));
    }
}
