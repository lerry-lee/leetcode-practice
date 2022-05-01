package _每日一题._2022年._befor5月;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/27
 * @Description
 */
public class _560_和为K的子数组 {

    public static void main(String[] args) {
        _560_和为K的子数组 instance = new _560_和为K的子数组();
        instance.new Solution().subarraySum(new int[]{-1, -1, -1}, 0);
    }

    /**
     * 解法1：前缀和 时间O(n^2) 空间O(n)
     */
    class Solution {
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            int[] preSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) preSum[i + 1] = preSum[i] + nums[i];
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    int sum = preSum[j + 1] - preSum[i];
                    if (sum == k) res++;
                }
            }
            return res;
        }
    }

    /**
     * 解法2：前缀和+哈希表 时间O(n) 空间O(n)
     */
    class Solution2 {
        public int subarraySum(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            int[] preSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) preSum[i + 1] = preSum[i] + nums[i];
            int res = 0;
            Map<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(0, 1);
            for (int i = 1; i <= nums.length; i++) {
                if (hashMap.containsKey(preSum[i] - k)) {
                    res += hashMap.get(preSum[i] - k);
                }
                hashMap.put(preSum[i], hashMap.getOrDefault(preSum[i], 0) + 1);
            }
            return res;
        }
    }
}
