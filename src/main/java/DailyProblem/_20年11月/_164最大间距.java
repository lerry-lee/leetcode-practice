package DailyProblem._20年11月;

import java.util.Arrays;

/**
 * @ClassName: _164最大间距
 * @Author: lerry_li
 * @CreateDate: 2020/11/26
 * @Description
 */
public class _164最大间距 {
    /**
     * 解法1：排序 时间O(NlogN) 空间O(1)
     */
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<2){
            return 0;
        }
        Arrays.sort(nums);
        int res=nums[1]-nums[0];
        for (int i = 2; i < nums.length; i++) {
            res=Math.max(res,nums[i]-nums[i-1]);
        }
        return res;
    }
}
