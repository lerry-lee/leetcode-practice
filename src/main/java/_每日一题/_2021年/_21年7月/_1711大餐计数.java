package _每日一题._2021年._21年7月;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _1711大餐计数
 * @Author: lerry_li
 * @CreateTime: 2021/07/11
 * @Description
 * 解法1：暴力枚举
 * 枚举2的幂
 */
public class _1711大餐计数 {

    public static void main(String[] args) {
        _1711大餐计数 instance = new _1711大餐计数();
        System.out.println(instance.countPairs(new int[]{1, 3, 5, 7, 9}));
        System.out.println(instance.countPairs(new int[]{1, 1, 1, 3, 3, 3, 7}));
        System.out.println(instance.countPairs(new int[]{2160, 1936, 3, 29, 27, 5, 2503, 1593, 2, 0, 16, 0, 3860, 28908, 6, 2, 15, 49, 6246, 1946, 23, 105, 7996, 196, 0, 2, 55, 457, 5, 3, 924, 7268, 16, 48, 4, 0, 12, 116, 2628, 1468}))
        ;
    }

    /**
     * 解法1：暴力枚举 时间O(N^2) 空间(1)
     */
    public int countPairs(int[] deliciousness) {
        //入参校验
        if (deliciousness == null || deliciousness.length == 0) return 0;
        int n = deliciousness.length;
        Arrays.sort(deliciousness);
        long res = 0;
        //二维枚举
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = deliciousness[i] + deliciousness[j];
                //若sum是2的幂
                if (sum>0&&(sum & (-sum)) == sum) {
                    //后面数字都相同，则直接加这一组
                    int cur = deliciousness[j];
                    int start = j;
                    while (j < n && deliciousness[j] == cur) {
                        j++;
                    }
                    res = res + (j - start);
                    j -= 1;
                }
            }
        }
        return (int) (res%1000000007);
    }

    /**
     * 解法2：枚举2的幂 时间O(N*logC) 空间O(1)
     */
    public int countPairs2(int[] deliciousness) {
        final int MOD = 1000000007;
        int n = deliciousness.length;
        //数组中最大的数
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        //最大值*2，用于枚举2的幂时最大限制
        int maxSum = maxVal * 2;
        //结果
        int res = 0;
        //map记录元素个数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //遍历数组
        for (int i = 0; i < n; i++) {
            //当前数值
            int val = deliciousness[i];
            //枚举2的幂
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                //
                int count = map.getOrDefault(sum - val, 0);
                res = (res + count) % MOD;
            }
            //遍历完当前元素在加入map，防止重复计算
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return res;
    }

}
