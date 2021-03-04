package _每日一题._2021年._21年3月;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: _354俄罗斯套娃信封问题
 * @Author: lerry_li
 * @CreateDate: 2021/03/04
 * @Description
 */
public class _354俄罗斯套娃信封问题 {
    /**
     * 解法1：动态规划：排序+暴力 时间O(N^2) 空间O(N)
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int len = envelopes.length;
        int[] dp = new int[len];

        for (int i = 1; i < len; i++) {
            int w = envelopes[i][0], h = envelopes[i][1];
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] < w && envelopes[j][1] < h) {
                    count = Math.max(count, dp[j] + 1);
                }
            }
            dp[i] = count;
        }
        int maxRes = 0;
        for (int i = 0; i < len; i++) {
            maxRes = Math.max(maxRes, dp[i]);
        }
        return maxRes + 1;
    }

    /**
     * 解法2：动态规划：排序+最长递增子序列 时间O() 空间O()
     * 思路：
     *      对第0列递增排序，然后对第1列求最长递增子序列
     */
    public int maxEnvelopes2(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        //1.对第0列递增排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    //第0列相等，第1列要降序，这样排除第0列相等但第1列递增的情况
                    return Integer.compare(o2[1], o1[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int len = envelopes.length;
        //2.然后对第1列求最长递增子序列
        int[] dp = new int[len];
        dp[0] = envelopes[0][1];
        int res = 1;
        for (int i = 1; i < len; i++) {
            int target = envelopes[i][1];
            if (target > dp[res - 1]) {
                dp[res] = target;
                res++;
            } else {
                //二分查找，找到刚好比它大的
                int idx=binarySearch(dp,0,res-1,target);
                dp[idx]=target;
            }
        }
        return res;
    }

    public int binarySearch(int[] array, int start, int end, int target) {
        int i = start, j = end;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (array[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        _354俄罗斯套娃信封问题 instance = new _354俄罗斯套娃信封问题();
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int[][] envelopes1={{4,5},{4,6},{6,7},{2,3},{1,1}};
        System.out.println(instance.maxEnvelopes2(envelopes));
        System.out.println(instance.maxEnvelopes2(envelopes1));
    }
}
