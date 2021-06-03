package _每日一题._2021年._21年6月;

import java.util.HashMap;

/**
 * @ClassName: _525连续数组
 * @Author: lerry_li
 * @CreateDate: 2021/06/03
 * @Description
 * 解法1：前缀和+枚举
 * 解法2：前缀和+哈希表
 */
public class _525连续数组 {

    public static void main(String[] args) {
        _525连续数组 instance = new _525连续数组();
        System.out.println(instance.findMaxLength(new int[]{0, 1}));//2
        System.out.println(instance.findMaxLength(new int[]{0, 1, 0}));//2
    }

    /**
     * 解法1：前缀和+枚举 时间O(N^2) 空间O(N)
     * 思路：
     *      0和1数量相同，则区间内的元素和=区间长度/2
     */
    public int findMaxLength1(int[] nums) {
        //特判
        if (nums == null || nums.length == 0) return 0;
        //len
        int n = nums.length;
        //前缀和
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        //结果
        int res = 1;
        //枚举区间
        for (int i = 1; i < n; i++) {
            for (int j = i + res; j <= n; j++) {
                int length = j + 1 - i;
                if (length % 2 == 0) {
                    if (prefixSum[j] - prefixSum[i - 1] == length / 2) {
                        res = Math.max(res, length);
                    }
                }
            }
        }
        return res == 1 ? 0 : res;
    }

    /**
     * 解法2：前缀和+哈希表 时间O(N) 空间O(N)
     */
    public int findMaxLength(int[] nums) {
        //特判
        if (nums == null || nums.length == 0) return 0;
        //len
        int length = 0;
        int n = nums.length;
        //将0看作-1，因此区间sum为0即为符合要求的区间，求最大区间长度即可
        //用一个变量记录区间sum
        int sum = 0;
        //假设空串为0，则计为-1
        //使用map记录<前缀和,第一次的下标>
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        for (int i = 0; i < n; i++) {
            //到当前元素的前缀和
            sum += nums[i] == 1 ? 1 : -1;
            if (hashMap.containsKey(sum)) {
                int prevIdx = hashMap.get(sum);
                if (i - prevIdx >= 2) length = Math.max(length, i - prevIdx);
            } else {
                hashMap.put(sum, i);
            }
        }
        return length;
    }

}
