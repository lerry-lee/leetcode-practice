package _每日一题._2021年._21年5月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _1074元素和为目标值的子矩阵数量
 * @Author: lerry_li
 * @CreateTime: 2021/05/29
 * @Description
 * 解法1：前缀和+暴力枚举
 * 解法2：前缀和+枚举优化
 */
public class _1074元素和为目标值的子矩阵数量 {

    public static void main(String[] args) {
        _1074元素和为目标值的子矩阵数量 instance = new _1074元素和为目标值的子矩阵数量();
        System.out.println(instance.numSubmatrixSumTarget(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0));//4
        System.out.println(instance.numSubmatrixSumTarget(new int[][]{{1, -1}, {-1, 1}}, 0));//5
        System.out.println(instance.numSubmatrixSumTarget(new int[][]{{904}}, 0));//0
    }

    /**
     * 解法1：前缀和+暴力枚举 时间O(M^2N^2) 空间O(MN)
     */
    public int numSubmatrixSumTarget1(int[][] matrix, int target) {
        //特判
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        //0行0列均为0
        //coding...
        int res = 0;
        //遍历填充
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //若单个元素符合条件，则res++
//                if (matrix[i][j] == target) res++;
                prefixSum[i + 1][j + 1] = prefixSum[i + 1][j] + prefixSum[i][j + 1] - prefixSum[i][j] + matrix[i][j];
            }
        }
        //枚举矩形左上角
        for (int i1 = 0; i1 < m; i1++) {
            for (int j1 = 0; j1 < n; j1++) {
                //枚举矩形右下角
                for (int i2 = i1; i2 < m; i2++) {
                    for (int j2 = j1; j2 < n; j2++) {
                        int sum =
                                prefixSum[i2 + 1][j2 + 1] - prefixSum[i2 + 1][j1] - prefixSum[i1][j2 + 1] + prefixSum[i1][j1];
                        if (sum == target) res++;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 解法2：前缀和+枚举优化 时间(M^2N) 空间O(MN)
     * 思路：
     *      固定上下边界，移动右边界，通过哈希表找左边界
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int res = 0;
        //枚举上边界
        for (int top = 1; top <= m; top++) {
            //枚举下边界
            for (int bottom = top; bottom <= m; bottom++) {
                int sum;
                //hashMap保存左边界的个数
                Map<Integer, Integer> hashMap = new HashMap<>();
                //枚举右边界
                for (int right = 1; right <= n; right++) {
                    sum = prefixSum[bottom][right] - prefixSum[top - 1][right];
                    if (sum == target) res++;
                    if (hashMap.containsKey(sum - target)) res += hashMap.get(sum - target);
                    hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return res;
    }

}
