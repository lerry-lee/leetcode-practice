package _数组与排序;

/**
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
 * 示例1
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例2
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 *
 * 解法：暴力循环O(n^2)，优化O(n)
 */
public class FindLengthOfLCIS {

    //两层for循环，时间复杂度O(n^2)
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] > nums[i - 1]) continue;

            int k = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[j - 1]) k++;
                else break;
            }
            max = Math.max(max, k);
        }
        return max;
    }

    //一遍for循环
    public int improvedMethod(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i==0) temp=1;
            else if (i > 0 && nums[i] > nums[i - 1]) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 1;
            }
        }
        max = Math.max(max, temp);
        return max;
    }
}
