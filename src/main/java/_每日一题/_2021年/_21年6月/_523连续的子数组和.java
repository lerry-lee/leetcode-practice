package _每日一题._2021年._21年6月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _523连续的子数组和
 * @Author: lerry_li
 * @CreateDate: 2021/06/02
 * @Description
 * 解法1：前缀和+枚举
 * 解法2：前缀和+map
 */
public class _523连续的子数组和 {

    public static void main(String[] args) {
        _523连续的子数组和 instance = new _523连续的子数组和();
        System.out.println(instance.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));//t
        System.out.println(instance.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));//t
        System.out.println(instance.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));//f
        System.out.println(instance.checkSubarraySum(new int[]{0, 0}, 1));//t
        System.out.println(instance.checkSubarraySum(new int[]{5, 1}, 3));//t
    }

    /**
     * 解法1：前缀和+枚举 时间O(N^2) 空间O(N)
     */
    public boolean checkSubarraySum1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = prefixSum[j] - prefixSum[i] + nums[i];
                if (sum % k == 0) return true;
            }
        }
        return false;
    }

    /**
     * 解法2：前缀和+map 时间O(N) 空间O(N)
     * 思路：
     *      同余定理：
     *      由a-b=n*k
     *      得a/k-b/k=n
     *      得a%k=b%k
     *      因此，只需预处理所有前缀和的余数即可
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        //特判
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //规定空的前缀的结束下标为 -1，由于空的前缀的元素和为 0，因此在哈希表中存入键值对 (0,-1)
        map.put(0, -1);
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int remainder = 0;
        for (int i = 0; i < n; i++) {
            remainder = prefixSum[i + 1] % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
