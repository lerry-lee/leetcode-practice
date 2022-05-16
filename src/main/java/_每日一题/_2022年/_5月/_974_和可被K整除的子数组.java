package _每日一题._2022年._5月;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/16
 */
public class _974_和可被K整除的子数组 {
    /**
     * 同余定理浅谈：假设a和b模k的余数相同，均为r，则a-b模k的余数为0，即a-b能够被k整除。
     *            简单证明：
     *             已知a=n1*k+r
     *                b=n2*k+r
     *             则有a-b=(n1-n2)*k
     */
    /**
     * 解法1：前缀和+暴力枚举 时间O(N^2) 空间O(N)
     * 解法2：前缀和+哈希表 时间O(N) 空间O(N)
     * 解法3：解法2的另一种统计法
     */
    class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            int len = nums.length;
            // 前缀和模K的数组
            int[] prefixSumModK = new int[len];
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                // 防止负数
                prefixSumModK[i] = (sum % k + k) % k;
            }
            // 相同的余数出现频次
            Map<Integer, Integer> hashMap = new HashMap<>();
            // 初始化余数为0时，存在1次，这样如果一个前缀和模k==0，那么它本身就可以使res+1
            hashMap.put(0, 1);
            int res = 0;
            for (int i = 0; i < len; i++) {
                // 为什么把相同余数的累加？
                // 因为任意两个相同余数的前缀和p[i]和p[j]，它们中间的子数组p[i:j]都是满足条件的
                // 因此如果前面相同余数的有cnt个，那么对于当前的p[j]，和任意一个组合，都可以产生合法的一个结果
                int cnt = hashMap.getOrDefault(prefixSumModK[i], 0);
                res += cnt;
                hashMap.put(prefixSumModK[i], cnt + 1);
            }
            return res;
        }

        public int subarraysDivByK3(int[] nums, int k) {
            if (nums == null || nums.length == 0) return 0;
            int len = nums.length;
            // 前缀和模K的数组
            int[] prefixSumModK = new int[len];
            // 相同的余数出现频次
            Map<Integer, Integer> hashMap = new HashMap<>();
            hashMap.put(0, 1);
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                // 防止负数
                prefixSumModK[i] = (sum % k + k) % k;
                int cnt = hashMap.getOrDefault(prefixSumModK[i], 0);
                hashMap.put(prefixSumModK[i], cnt + 1);
            }
            int res = 0;
            for (int rem : hashMap.keySet()) {
                int cnt = hashMap.get(rem);
                res += cnt * (cnt - 1) / 2;
            }
            return res;
        }
    }
}
