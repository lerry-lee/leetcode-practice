package _每日一题._2021年._21年7月;

/**
 * @ClassName: _300最长递增子序列
 * @Author: lerry_li
 * @CreateDate: 2021/07/17
 * @Description
 */
public class _300最长递增子序列 {

    public static void main(String[] args) {
        _300最长递增子序列 instance = new _300最长递增子序列();
        int[] nums = {4, 10, 4, 3, 8, 9};
        System.out.println(instance.lengthOfLIS(nums));
    }

    /**
     * 一次遍历+二分搜索 时间O(NlogK) 空间O(N)
     */
    public int lengthOfLIS(int[] nums) {
        //特判
        if (nums == null) return 0;
        //保存递增子序列
        int[] dp = new int[nums.length];
        //最长长度的下标
        int end = -1;
        for (int num : nums) {
            //第一个元素直接追加
            //若num比dp末尾元素还大，直接追加
            if (end < 0 || num > dp[end]) {
                end++;
                dp[end] = num;
            }
            //否则，二分查找dp[:end]第一个大于等于num的元素，然后替换掉
            else {
                bSearch(dp, end, num);
            }
        }
        return end + 1;
    }

    private void bSearch(int[] nums, int end, int target) {
        int l = 0, r = end;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //如果mid元素==target，那么退出，不用替换了
            if (nums[mid] == target) return;
                //如果mid元素比target小，那么缩小区间为[mid+1,r]
            else if (nums[mid] < target) {
                l = mid + 1;
            }
            //如果mid元素比target大，那么缩小区间为[l,mid]
            else {
                r = mid;
            }
        }
        //最后替换
        nums[l] = target;
    }
}
