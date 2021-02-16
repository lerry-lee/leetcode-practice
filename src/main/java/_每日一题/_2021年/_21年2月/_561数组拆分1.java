package _每日一题._2021年._21年2月;

import java.util.Arrays;

/**
 * @ClassName: _561数组拆分1
 * @Author: lerry_li
 * @CreateDate: 2021/02/16
 * @Description
 */
public class _561数组拆分1 {
    /**
     * 解法1：排序 时间O(N) 空间O(1)
     */
    public int arrayPairSum(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            if(i%2==0){
                sum+=nums[i];
            }
        }
        return sum;
    }
}
