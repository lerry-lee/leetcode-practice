package _腾讯推荐._数组与字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : _三数之和
 * @CreateTime : 2020/09/17 09
 * @Author : lerry_li
 * @Descrpition : 三数之和
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class _三数之和 {

    /**
     * 解法1：转化为求两数之和
     * 求两数之和：排序+头尾指针
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            findTwoNum(res, nums[i], nums, i + 1);
        }
        return res;
    }

    public void findTwoNum(List<List<Integer>> res, int target, int[] nums, int start) {
        int l=start,r=nums.length-1;
        while(l<r){
            if(l>start&&nums[l]==nums[l-1]) l++;
            else if(r<nums.length-1&&nums[r]==nums[r+1]) r--;
            else if(nums[l]+nums[r]+target==0) {
                res.add(Arrays.asList(target, nums[l], nums[r]));
                l++;
                r--;
            }
            else if(nums[l]+nums[r]+target<0) l++;
            else r--;
        }
    }
}
