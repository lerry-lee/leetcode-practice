package _每日一题._2022年;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _34_在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
        _34_在排序数组中查找元素的第一个和最后一个位置 instance=new _34_在排序数组中查找元素的第一个和最后一个位置();
        instance.new Solution().searchRange(new int[]{5,7,7,8,8,10},8);
    }

    /**
     * 解法1：二分 时间O(logN) 空间O(1)
     */
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if(nums==null||nums.length==0) return new int[]{-1,-1};
            int l=0,r=nums.length-1;
            while(l<r){
                int mid=l+(r-l)/2;
                if(nums[mid]<target){
                    l=mid+1;
                }else if(nums[mid]==target){
                    r=mid;
                }else{
                    r=mid-1;
                }
            }
            int start=-1,end=-1;
            if(nums[l]==target) start=l;
            else return new int[]{-1,-1};
            l=0;r=nums.length-1;
            while(l<r){
                int mid=l+(r-l)/2;
                if(nums[mid]<=target){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
            if(nums[l]>target) end=l-1;
            return new int[]{start,end};
        }
    }
}
