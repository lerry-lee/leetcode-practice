package _每日一题._2022年;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _153_寻找旋转排序数组中的最小值 {
    /**
     * 解法1：二分 时间O(logN) 空间O(1)
     */
    class Solution {
        public int findMin(int[] nums) {
            if(nums==null||nums.length==0) return Integer.MIN_VALUE;
            int l=0,r=nums.length-1;
            while(l<r){
                if(nums[l]<nums[r]) return nums[l];
                int mid=l+(r-l)/2;
                if(nums[mid]<nums[r]){
                    r=mid;
                }
                else{
                    l=mid+1;
                }
            }
            return nums[l];
        }
    }
}
