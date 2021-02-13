package _每日一题._2021年._21年2月;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _448找到所有数组中消失的数字
 * @Author: lerry_li
 * @CreateTime: 2021/02/13
 * @Description
 */
public class _448找到所有数组中消失的数字 {
    /**
     * 解法1：计数数组 时间O(N) 空间O(N)
     * 解法2：两次遍历原地修改 时间O(N) 空间O(1)
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;

        int[] freq = new int[n + 1];

        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (freq[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 解法2：
     * 思路；
     * 具体来说，遍历 nums，每遇到一个数 x，就让 nums[x−1] 增加 n。
     * 由于 nums 中所有数均在 [1,n] 中，增加以后，这些数必然大于 n。
     * 最后我们遍历 nums，若 nums[i] 未大于 n，就说明没有遇到过数 i+1。这样我们就找到了缺失的数字。
     *
     * 注意，当我们遍历到某个位置时，其中的数可能已经被增加过，因此需要对 n 取模来还原出它本来的值。
     *
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x=(nums[i]-1)%n;
            nums[x]+=n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <=n) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _448找到所有数组中消失的数字 instance=new _448找到所有数组中消失的数字();
        int[] nums={4,3,2,7,7,2,3,1};
        System.out.println(instance.findDisappearedNumbers2(nums));
    }
}
