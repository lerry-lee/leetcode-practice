package _每日一题._2022年._5月;

import java.util.Arrays;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/10
 */
public class _324_摆动排序2 {
    /**
     * 解法1：排序+分组+穿插 时间O(NlogN) 空间O(N)
     */
    class Solution {
        public void wiggleSort(int[] nums) {
            int[] help = nums.clone(); //不能写成int[] help = nums,排序后两个数组都改变
            Arrays.sort(help);
            int N = nums.length-1;
            //比如123456
            for (int i = 1; i < nums.length; i += 2) {
                nums[i] = help[N--]; //遍历完成后 x 6 x 5 x 4
            }
            for (int i = 0; i < nums.length; i += 2) {
                nums[i] = help[N--]; //便利完成后 3 6 2 5 1 4
            }
        }
    }
}
