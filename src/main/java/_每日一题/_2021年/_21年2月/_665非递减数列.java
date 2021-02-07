package _每日一题._2021年._21年2月;

/**
 * @ClassName: _665非递减数列
 * @Author: lerry_li
 * @CreateTime: 2021/02/07
 * @Description
 */
public class _665非递减数列 {
    /**
     * 解法1：硬解 时间O(N) 空间O(1)
     * 思路：
     * 遍历数组，遇到下降的地方时：即nums[i]<nums[i-1]
     * （1）下降的这个点的两侧不能是递减的
     * （2）下降的这个点的前一个点的两侧不能是递减的
     * 两点同时不满足才可以
     */
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int down = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                down++;
                if((i<nums.length-1&&nums[i+1]<nums[i-1])&&(i>=2&&nums[i]<nums[i-2])){
                    return false;
                }
            }
        }
        return down <= 1;
    }

    public static void main(String[] args) {
        _665非递减数列 instance=new _665非递减数列();
        int[] nums={4,2,3};
        int[] nums1={4,2,1};
        int[] nums2={3,4,2,3};
        System.out.println(instance.checkPossibility(nums));
        System.out.println(instance.checkPossibility(nums1));
        System.out.println(instance.checkPossibility(nums2));
    }
}
