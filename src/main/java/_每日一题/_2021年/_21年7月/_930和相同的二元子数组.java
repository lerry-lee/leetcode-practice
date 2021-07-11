package _每日一题._2021年._21年7月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _930和相同的二元子数组
 * @Author: lerry_li
 * @CreateTime: 2021/07/11
 * @Description
 * 解法1：前缀和+二维枚举
 * 解法2：前缀和+哈希
 */
public class _930和相同的二元子数组 {

    public static void main(String[] args) {
        _930和相同的二元子数组 instance = new _930和相同的二元子数组();
        System.out.println(instance.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(instance.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }

    /**
     * 解法1：前缀和+二维枚举 时间O(N^2) 空间O(N)
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        //入参校验
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] += prefixSum[i] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = prefixSum[j + 1] - prefixSum[i];
                if (sum > goal) break;
                else if (sum == goal) res++;
            }
        }
        return res;
    }

    /**
     * 解法2：前缀和+哈希 时间O(N) 空间O(N)
     */
    public int numSubarraysWithSum2(int[] nums, int goal) {
        //入参校验
        if (nums == null || nums.length == 0) return 0;
        //<前缀和,数量>map
        Map<Integer, Integer> hashMap = new HashMap<>();
        //存初始值<0,1>，表示前缀和为0时，空集合的数量为1
        //这样可以保证当子数组只有1个元素，且该元素=goal时，可以取到
        hashMap.put(0, 1);
        int res = 0;
        //前缀和,sum表示从0到当前元素的前缀和
        int sumJ = 0;
        //枚举num，计算sumJ => 枚举sumJ
        for (int num : nums) {
            //计算前缀和
            sumJ += num;
            //当sumJ-sumI=goal时，[i,j]子数组符合条件
            //因此看map里有多少个sumI
            res += hashMap.getOrDefault(sumJ - goal, 0);
            hashMap.put(sumJ, hashMap.getOrDefault(sumJ, 0) + 1);
        }
        return res;
    }

}
