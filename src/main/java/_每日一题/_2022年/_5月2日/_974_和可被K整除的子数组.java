package _每日一题._2022年._5月2日;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _974_和可被K整除的子数组 {
    /**
     * 解法1：前缀和 超时
     */
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            int length = nums.length;
            int[] prefixSum = new int[length + 1];
            int res=0;
            for (int i = 1; i <= length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
                if(nums[i-1]%k==0) res++;
            }

            for (int i = 1; i <= length; i++) {
                for (int j = i+1; j <= length; j++) {
                    if((prefixSum[j]-prefixSum[i-1])%k==0) res++;
                }
            }
            return res;
        }
    }
    /**
     * 解法2：前缀和+同余定理（哈希表保存）
     */
    class Solution2 {
        public int subarraysDivByK(int[] nums, int k) {
            Map<Integer, Integer> record = new HashMap<>();
            //直接%k=0的数，结果可+1
            record.put(0, 1);
            int sum = 0;
            for (int elem : nums) {
                sum += elem;
                // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
                int modulus = (sum % k + k) % k;
                record.put(modulus, record.getOrDefault(modulus, 0) + 1);
            }

            int ans = 0;
            for (Map.Entry<Integer, Integer> entry: record.entrySet()) {
                ans += entry.getValue() * (entry.getValue() - 1) / 2;
            }
            return ans;
        }
    }
}
