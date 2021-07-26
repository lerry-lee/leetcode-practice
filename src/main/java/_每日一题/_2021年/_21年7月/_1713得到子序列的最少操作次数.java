package _每日一题._2021年._21年7月;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: _1713得到子序列的最少操作次数
 * @Author: lerry_li
 * @CreateDate: 2021/07/26
 * @Description
 * 解法1：dp
 * 解法2：转换为最长递增子序列
 */
public class _1713得到子序列的最少操作次数 {
    /**
     * 解法1：dp 时间O(NM) 空间O(NM)
     */
    public int minOperations(int[] target, int[] arr) {
        //特判
        if (target == null || target.length == 0 || arr == null || arr.length == 0) return 0;
        //dp[i][j]表示target[:i]和arr[:j]的最长公共子序列
        int m = target.length, n = arr.length;
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        dp[0][0] = 0;
        //状态转移
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //若target[i]==arr[j]
                if (target[i] == arr[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
                //若不等
                else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j], Math.max(dp[i + 1][j], dp[i][j + 1]));
                }
            }
        }
        //最终返回最长公共子序列
        return m - dp[m][n];
    }

    /**
     * 解法2：转换为最长递增子序列 时间O(N+MlogM) 空间O(N+M)
     * 思路：为什么能转换问题，可参考题解https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence/solution/de-dao-zi-xu-lie-de-zui-shao-cao-zuo-ci-hefgl/
     */
    public int minOperations2(int[] target, int[] arr) {
        //target长度
        int n = target.length;
        //target中的元素对应的下标
        Map<Integer, Integer> num2idx = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            num2idx.put(target[i], i);
        }
        //最长递增子序列
        List<Integer> longestSequence = new ArrayList<Integer>();
        //遍历arr数组
        for (int val : arr) {
            //如果arr中的当前元素val在target中，才去处理，否则不可能是公共子序列中的元素
            if (num2idx.containsKey(val)) {
                //拿到当前元素val在target中的下标
                int idx = num2idx.get(val);
                //找到下标在最长递增子序列中的位置(替换掉刚好比大的)
                int it = binarySearch(longestSequence, idx);
                //如果找到了刚好比it大的，那么替换掉
                if (it != longestSequence.size()) {
                    longestSequence.set(it, idx);
                } else {//否则，it比最长递增子序列中所有元素都大，直接在末尾追加
                    longestSequence.add(idx);
                }
            }
        }
        //返回n-最长公共子序列长度(最长递增子序列长度)
        return n - longestSequence.size();
    }

    //二分查找比target刚好大的第一个元素
    public int binarySearch(List<Integer> d, int target) {
        int size = d.size();
        if (size == 0 || d.get(size - 1) < target) {
            return size;
        }
        int low = 0, high = size - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            //若mid的值<target，区间变为[mid+1,high]
            if (d.get(mid) < target) {
                low = mid + 1;
            }
            //否则mid>=target，区间变为[low,mid]
            else {
                high = mid;
            }
        }
        return low;
    }
}
