package _腾讯推荐._数组与字符串;

import java.util.Arrays;

/**
 * @ClassName : _最接近的三数之和
 * @CreateTime : 2020/09/17 11
 * @Author : lerry_li
 * @Descrpition : 最接近的三数之和
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class _最接近的三数之和 {
    /**
     * 解法1：转化成求两数之和，排序+双指针
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int min_dif = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int res_target = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    System.out.println(nums[i] + " " + nums[l] + " " + nums[r]);
                    return target;
                }
                int temp_dif = Math.abs(sum - target);
                if (temp_dif < min_dif) {
                    min_dif = temp_dif;
                    System.out.println(nums[i] + " " + nums[l] + " " + nums[r] + " :" + sum);
                    res_target = sum;
                    if (sum > target) r--;
                    else l++;
                } else if (sum > target) r--;
                else l++;
            }
        }
        return res_target;
    }

}
